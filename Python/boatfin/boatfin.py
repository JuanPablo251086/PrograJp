"""
boatfin.py  –  Autodesk Fusion 360 Python Script
==================================================
Creates two 3-D-printable bodies inside the active component:

  Fin_Base_Plate  – flat disk glued to the hull; has a centre post and
                    8 tap-drilled screw holes around the rim
  Fin_Assembly    – collar + fin; drops onto the post and is fastened
                    down with 8 screws through matching clearance holes

All dimensions are in centimetres (Fusion 360 internal unit).

How to run
----------
1. Open Autodesk Fusion 360 with a new empty design.
2. Tools ▸ Scripts and Add-ins (Shift+S) ▸ Scripts tab ▸ + (Add) ▸ select this file.
3. Click Run.

The two bodies appear side-by-side (30 mm apart) for easy inspection.
Right-click each body → Save As Mesh (STL) to export for printing.

Assembly
--------
1. Glue Fin_Base_Plate flat-side-down to the hull.
2. Drop Fin_Assembly onto the centre post — post centres the collar.
3. Rotate to the desired heading (any 45° increment — 8 positions line up).
4. Drive 8 × M2.5 × 8 mm self-tapping screws down through the collar's
   clearance holes into the base plate's pilot holes.

Print notes
-----------
• Recommended layer height: 0.15–0.2 mm.
• Print both pieces flat-side-down (no support needed).
• If the collar binds on the post, increase HOLE_R by 0.01 cm and re-run.
• Tap holes are sized for an M2.5 self-tapping screw cutting fresh threads
  in PLA. If you prefer cut threads, run an M2.5 tap through them first.
"""

import adsk.core
import adsk.fusion
import traceback
import math

# ── Dimensions (centimetres) ──────────────────────────────────────────────────
# Base plate
BASE_R   = 1.30   # radius            → 26 mm diameter  (hosts screw holes at 10 mm ring with FDM-safe walls)
BASE_H   = 0.40   # thickness         →  4 mm  (≈2 D thread engagement for M2.5 self-tapping into PLA)

# Centre post (on top of base plate) — alignment aid, not load-bearing
POST_R   = 0.20   # radius            →  4 mm diameter
POST_H   = 0.15   # height above base →  1.5 mm  (sits inside blind hole with 0.5 mm clearance below ceiling)

# Screw holes  (8 × 45 ° around a common ring)
SCREW_RNG    = 1.00   # ring radius        → 10 mm from centre  (clears 14 mm fin chord; sits inside 26 mm plate with 1.6 mm wall)
SCREW_TAP_R  = 0.10   # tap-hole radius    →  2.0 mm diameter   (pilot for M2.5 self-tap into PLA — base plate)
SCREW_CLR_R  = 0.125  # clearance radius   →  2.5 mm diameter   (line-to-line on M2.5 shank — collar)
N_SCREWS     = 8

# Collar (top piece)
COLLAR_R = 1.30   # radius            → 26 mm diameter  (matches base — holes must line up)
COLLAR_H = 0.25   # thickness         →  2.5 mm
HOLE_R   = 0.25   # blind-hole radius →  5.0 mm  (1 mm diametric clearance on 4 mm post — FDM-safe sliding fit)
HOLE_D   = 0.20   # blind-hole depth  →  2.0 mm  (leaves 0.5 mm solid ceiling at the top — no gap around fin)

# Fin body
FIN_H    = 2.50   # fin height        → 25 mm
FIN_CA   = 1.40   # chord at base     → 14 mm
FIN_TA   = 0.45   # thickness at base →  4.5 mm
FIN_CT   = 0.50   # chord at tip      →  5 mm
FIN_TT   = 0.15   # thickness at tip  →  1.5 mm

# Side-by-side layout: fin assembly is offset this far in X from the base plate
LAYOUT_X = 3.00   # 30 mm separation between the two bodies
# ─────────────────────────────────────────────────────────────────────────────


def run(context):
    ui = None
    try:
        app  = adsk.core.Application.get()
        ui   = app.userInterface
        des  = adsk.fusion.Design.cast(app.activeProduct)
        root = des.rootComponent

        # Both bodies live inside the root component (Part Design compatible).
        # The fin assembly is offset LAYOUT_X cm in X so they don't overlap.
        _make_base_plate(root,   cx=0.0,      cy=0.0)
        _make_fin_assembly(root, cx=LAYOUT_X, cy=0.0)

        ui.messageBox(
            'Boat fin created!\n\n'
            'Two bodies in this design:\n'
            '  Fin_Base_Plate  (left)  – glue flat bottom to hull, then\n'
            '                            screw the assembly down through it\n'
            '  Fin_Assembly    (right) – drops onto post, fastens with 8 × M2.5 screws\n\n'
            '8 screw positions every 45 ° — pick any rotation at install.\n'
            'Total fin protrusion from hull ≈ 30 mm.\n\n'
            'Right-click each body → Save As Mesh (STL) to export.\n'
            'Recommended fasteners: 8 × M2.5 × 8 mm self-tapping screws.\n'
            'If the collar binds on the post, adjust HOLE_R ± 0.01 cm and re-run.'
        )

    except:
        if ui:
            ui.messageBox('Script failed:\n{}'.format(traceback.format_exc()))


# ── helpers ───────────────────────────────────────────────────────────────────

def _pt(x, y, z=0):
    return adsk.core.Point3D.create(x, y, z)


def _offset_plane(comp, ref_plane, z_cm):
    planes = comp.constructionPlanes
    pi     = planes.createInput()
    pi.setByOffset(ref_plane, adsk.core.ValueInput.createByReal(z_cm))
    return planes.add(pi)


def _extrude_op(comp, profile_or_coll, height_cm, op):
    exts = comp.features.extrudeFeatures
    ei   = exts.createInput(profile_or_coll, op)
    ei.setDistanceExtent(False, adsk.core.ValueInput.createByReal(height_cm))
    return exts.add(ei)


def _new_body(comp, profile, height_cm):
    return _extrude_op(comp, profile, height_cm,
                       adsk.fusion.FeatureOperations.NewBodyFeatureOperation)


def _join(comp, profile, height_cm):
    return _extrude_op(comp, profile, height_cm,
                       adsk.fusion.FeatureOperations.JoinFeatureOperation)


def _cut(comp, profile, depth_cm):
    return _extrude_op(comp, profile, depth_cm,
                       adsk.fusion.FeatureOperations.CutFeatureOperation)


def _ring_sketch(comp, plane, cx, cy, ring_r, circle_r, n):
    """n circles arranged in a ring of radius ring_r, centred at (cx, cy)."""
    sk = comp.sketches.add(plane)
    for i in range(n):
        a = 2.0 * math.pi * i / n
        sk.sketchCurves.sketchCircles.addByCenterRadius(
            _pt(cx + ring_r * math.cos(a),
                cy + ring_r * math.sin(a)), circle_r)
    return sk


def _all_profiles(sketch):
    coll = adsk.core.ObjectCollection.create()
    for i in range(sketch.profiles.count):
        coll.add(sketch.profiles.item(i))
    return coll


def _annular_profile(sketch):
    """Annular (donut) profile = the profile whose loop count is 2."""
    for i in range(sketch.profiles.count):
        p = sketch.profiles.item(i)
        if p.profileLoops.count == 2:
            return p
    return sketch.profiles.item(0)   # fallback


# ── body builders ─────────────────────────────────────────────────────────────

def _make_base_plate(comp, cx, cy):
    """
    Fin_Base_Plate
    ──────────────
    Flat disk (26 mm dia × 4 mm) with a 4 mm centre post and
    8 Ø2 mm pilot holes at 10 mm ring radius spaced 45 °.
    M2.5 self-tapping screws cut their own threads in the PLA when driven
    from above through the fin assembly's clearance holes.
    """
    xy = comp.xYConstructionPlane

    # flat disk → new body
    sk = comp.sketches.add(xy)
    sk.sketchCurves.sketchCircles.addByCenterRadius(_pt(cx, cy), BASE_R)
    ext = _new_body(comp, sk.profiles.item(0), BASE_H)
    ext.bodies.item(0).name = 'Fin_Base_Plate'

    # centre post joined on top
    top = _offset_plane(comp, xy, BASE_H)
    sk2 = comp.sketches.add(top)
    sk2.sketchCurves.sketchCircles.addByCenterRadius(_pt(cx, cy), POST_R)
    _join(comp, sk2.profiles.item(0), POST_H)

    # Ø2 mm pilot holes for M2.5 self-tap, cut all the way through the base
    sk3 = _ring_sketch(comp, xy, cx, cy, SCREW_RNG, SCREW_TAP_R, N_SCREWS)
    _cut(comp, _all_profiles(sk3), BASE_H)


def _make_fin_assembly(comp, cx, cy):
    """
    Fin_Assembly
    ────────────
    Collar (26 mm dia, blind 5 mm hole for the post) with 8 Ø2.5 mm
    clearance holes through the full thickness, plus the lofted fin:
    14 × 4.5 mm ellipse at collar top → 5 × 1.5 mm at tip (25 mm tall).
    Centred at (cx, cy) so it sits beside Fin_Base_Plate in the viewport.
    """
    xy = comp.xYConstructionPlane

    # collar as a solid disk → new body
    sk = comp.sketches.add(xy)
    sk.sketchCurves.sketchCircles.addByCenterRadius(_pt(cx, cy), COLLAR_R)
    ext = _new_body(comp, sk.profiles.item(0), COLLAR_H)
    ext.bodies.item(0).name = 'Fin_Assembly'

    # blind centre hole cut from the bottom — stops short of the top face
    # so the collar's top remains a fully closed surface under the fin
    sk_hole = comp.sketches.add(xy)
    sk_hole.sketchCurves.sketchCircles.addByCenterRadius(_pt(cx, cy), HOLE_R)
    _cut(comp, sk_hole.profiles.item(0), HOLE_D)

    # Ø2.5 mm clearance holes cut all the way through the collar
    sk_s = _ring_sketch(comp, xy, cx, cy, SCREW_RNG, SCREW_CLR_R, N_SCREWS)
    _cut(comp, _all_profiles(sk_s), COLLAR_H)

    # fin loft: base ellipse at collar top → tip ellipse 25 mm above
    fin_base = _offset_plane(comp, xy, COLLAR_H)
    fin_tip  = _offset_plane(comp, xy, COLLAR_H + FIN_H)

    sk_b = comp.sketches.add(fin_base)
    sk_b.sketchCurves.sketchEllipses.add(
        _pt(cx, cy),                     # centre
        _pt(cx + FIN_CA / 2, cy),        # end of major axis (chord direction = X)
        _pt(cx, cy + FIN_TA / 2)         # any point on ellipse (here: end of minor axis)
    )

    sk_t = comp.sketches.add(fin_tip)
    sk_t.sketchCurves.sketchEllipses.add(
        _pt(cx, cy),
        _pt(cx + FIN_CT / 2, cy),
        _pt(cx, cy + FIN_TT / 2)
    )

    lofts = comp.features.loftFeatures
    li    = lofts.createInput(adsk.fusion.FeatureOperations.JoinFeatureOperation)
    li.loftSections.add(sk_b.profiles.item(0))
    li.loftSections.add(sk_t.profiles.item(0))
    lofts.add(li)
