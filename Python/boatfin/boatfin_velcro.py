"""
boatfin_velcro.py  –  Autodesk Fusion 360 Python Script
========================================================
Velcro-attached variant of the boat fin. Replaces the screwed-down attachment
with two flat-mating disks that connect via a hook-and-loop velcro pad you
stick on yourself between them.

  Velcro_Base  – plain Ø22 × 3 mm disk; bottom glues to hull, top gets velcro
  Velcro_Top   – same Ø22 × 3 mm disk with the fin lofted on top; bottom gets
                 the matching velcro pad

All dimensions are in centimetres (Fusion 360 internal unit).

How to run
----------
1. Open Autodesk Fusion 360 with a new empty design.
2. Tools ▸ Scripts and Add-ins (Shift+S) ▸ Scripts tab ▸ + (Add) ▸ select this file.
3. Click Run.

The two bodies appear side-by-side (30 mm apart). Right-click each body →
Save As Mesh (STL) to export for printing.

Assembly
--------
1. Print both disks flat-side-down (Velcro_Top with fin pointing up).
2. Cut two Ø~18 mm velcro circles — hook side for one disk, loop side for
   the other. Adhesive-backed velcro is easiest.
3. Stick one velcro circle to the TOP face of Velcro_Base.
4. Stick the matching circle to the BOTTOM face of Velcro_Top.
5. Glue Velcro_Base to the hull (the bare flat bottom face).
6. Press Velcro_Top onto Velcro_Base at the desired heading — re-orient at
   any time by peeling apart and re-pressing.

Print notes
-----------
• Recommended layer height: 0.15–0.2 mm.
• Both mating surfaces are flat — no support, no bridging, no overhangs.
• 100% infill recommended (parts are tiny and need to be rigid).
• Bottom of Velcro_Base will be glued — do not put velcro on that side!
"""

import adsk.core
import adsk.fusion
import traceback

# ── Dimensions (centimetres) ──────────────────────────────────────────────────
# Base disk (glued to hull)
BASE_R   = 1.10   # radius            → 22 mm diameter
BASE_H   = 0.30   # thickness         →  3 mm

# Top disk (carries the fin)
TOP_R    = 1.10   # radius            → 22 mm diameter  (matches base)
TOP_H    = 0.30   # thickness         →  3 mm

# Fin body  (unchanged from screwed variant)
FIN_H    = 2.50   # fin height        → 25 mm
FIN_CA   = 1.40   # chord at base     → 14 mm
FIN_TA   = 0.45   # thickness at base →  4.5 mm
FIN_CT   = 0.50   # chord at tip      →  5 mm
FIN_TT   = 0.15   # thickness at tip  →  1.5 mm

# Side-by-side layout: top piece is offset this far in X from the base
LAYOUT_X = 3.00   # 30 mm separation between the two bodies
# ─────────────────────────────────────────────────────────────────────────────


def run(context):
    ui = None
    try:
        app  = adsk.core.Application.get()
        ui   = app.userInterface
        des  = adsk.fusion.Design.cast(app.activeProduct)
        root = des.rootComponent

        # Both bodies live in the root component (Part Design compatible).
        # Top piece is offset LAYOUT_X cm in X so it doesn't overlap the base.
        _make_velcro_base(root, cx=0.0,      cy=0.0)
        _make_velcro_top(root,  cx=LAYOUT_X, cy=0.0)

        ui.messageBox(
            'Velcro fin created!\n\n'
            'Two bodies in this design:\n'
            '  Velcro_Base  (left)  – glue flat bottom to hull, velcro on top\n'
            '  Velcro_Top   (right) – velcro on bottom, fin on top\n\n'
            'Total fin protrusion from hull ≈ 31 mm\n'
            '   (3 mm base + ~3 mm velcro stack + 25 mm fin)\n\n'
            'Right-click each body → Save As Mesh (STL) to export.'
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


def _new_body(comp, profile, height_cm):
    exts = comp.features.extrudeFeatures
    ei   = exts.createInput(profile,
                            adsk.fusion.FeatureOperations.NewBodyFeatureOperation)
    ei.setDistanceExtent(False, adsk.core.ValueInput.createByReal(height_cm))
    return exts.add(ei)


# ── body builders ─────────────────────────────────────────────────────────────

def _make_velcro_base(comp, cx, cy):
    """
    Velcro_Base
    ───────────
    Plain Ø22 × 3 mm disk. Bottom face glues to the hull,
    top face takes a velcro pad.
    """
    xy = comp.xYConstructionPlane
    sk = comp.sketches.add(xy)
    sk.sketchCurves.sketchCircles.addByCenterRadius(_pt(cx, cy), BASE_R)
    ext = _new_body(comp, sk.profiles.item(0), BASE_H)
    ext.bodies.item(0).name = 'Velcro_Base'


def _make_velcro_top(comp, cx, cy):
    """
    Velcro_Top
    ──────────
    Ø22 × 3 mm disk with the lofted fin on top:
    14 × 4.5 mm ellipse at disk top → 5 × 1.5 mm at 25 mm above.
    Bottom face stays flat to take the matching velcro pad.
    """
    xy = comp.xYConstructionPlane

    # flat disk → new body
    sk = comp.sketches.add(xy)
    sk.sketchCurves.sketchCircles.addByCenterRadius(_pt(cx, cy), TOP_R)
    ext = _new_body(comp, sk.profiles.item(0), TOP_H)
    ext.bodies.item(0).name = 'Velcro_Top'

    # fin loft: base ellipse at disk top → tip ellipse 25 mm above
    fin_base = _offset_plane(comp, xy, TOP_H)
    fin_tip  = _offset_plane(comp, xy, TOP_H + FIN_H)

    sk_b = comp.sketches.add(fin_base)
    sk_b.sketchCurves.sketchEllipses.add(
        _pt(cx, cy),                  # centre
        _pt(cx + FIN_CA / 2, cy),     # end of major axis (chord direction = X)
        _pt(cx, cy + FIN_TA / 2)      # any point on ellipse (here: end of minor axis)
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
