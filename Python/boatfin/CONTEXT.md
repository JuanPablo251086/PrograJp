# Boat Fin Project — Handoff Context

> Read this first if you're picking up the project on a new machine or in a new
> Claude Code session. Everything you need to continue the design conversation
> is in here. Pair it with [boatfin.py](boatfin.py).

## What this is

A small rotatable fin for a ~11 × 22 cm boat, 3-D-printable in PLA. Modelled
parametrically in Autodesk Fusion 360 via a Python script. Two pieces:

- **Fin_Base_Plate** — flat disk glued to the hull. Has a centre post and 8
  detent bumps on its top face.
- **Fin_Assembly** — collar that slides over the post, with the fin lofted
  out of its top face. Recesses on the collar's underside engage the bumps
  to lock rotation in 8 indexed positions (every 45°).

User is targeting FDM PLA printing on a standard 0.4 mm-nozzle machine.

## Hard requirements from the user

- Fin "about 2.5 cm at its tallest" → matches `FIN_H = 2.50` (25 mm)
- Circular base with "a certain kind of rotation setting" → interpreted as
  indexed click-stops, implemented as 8-position detent (bump + recess pair)
- Base is glued to the hull (so its bottom face is the flat side)
- User said don't worry about modelling the boat itself

## Current dimensions (all in cm, Fusion's internal unit)

These live at the top of `boatfin.py`. Each one has a reason — don't change
casually without re-reading the rationale below.

| Param | Value | Real | Rationale |
|---|---|---|---|
| `BASE_R` | 1.10 | Ø22 mm | Plate; gives glue area without being huge for an 11 × 22 cm boat |
| `BASE_H` | 0.30 | 3 mm | Stiff enough to resist peeling under fin side loads |
| `POST_R` | 0.20 | Ø4 mm | Rotation axis |
| `POST_H` | 0.15 | 1.5 mm | Engages 1.5 mm into the blind hole; 0.5 mm clearance below the ceiling |
| `BUMP_RNG` | 0.80 | 8 mm | Bump-ring radius; fits inside collar Ø22 with margin |
| `BUMP_R` | 0.08 | Ø1.6 mm | Detent bump; near FDM minimum but printable |
| `BUMP_H` | 0.08 | 0.8 mm | **Must be ≤ `RECESS_D`** so the collar seats flat |
| `N_BUMPS` | 8 | — | Click positions every 45° |
| `COLLAR_R` | 1.10 | Ø22 mm | Matches base |
| `COLLAR_H` | 0.25 | 2.5 mm | Thick enough to host recesses without breaking through |
| `HOLE_R` | 0.25 | Ø5 mm | **Blind hole** (not through). 1 mm diametric clearance on Ø4 post |
| `HOLE_D` | 0.20 | 2.0 mm | Blind-hole depth — leaves 0.5 mm solid ceiling so fin doesn't expose a gap |
| `RECESS_R` | 0.11 | Ø2.2 mm | 0.3 mm radial clearance on bump — FDM-safe |
| `RECESS_D` | 0.09 | 0.9 mm | 0.1 mm deeper than bump — collar seats flat at detent positions |
| `FIN_H` | 2.50 | 25 mm | User's "tallest" target |
| `FIN_CA` | 1.40 | 14 mm | Fin chord at base |
| `FIN_TA` | 0.45 | 4.5 mm | Fin thickness at base — **chunkier than ideal hydrodynamic ratio** (see open items) |
| `FIN_CT` | 0.50 | 5 mm | Tip chord |
| `FIN_TT` | 0.15 | 1.5 mm | Tip thickness |
| `LAYOUT_X` | 3.00 | 30 mm | Just a visual offset between bodies in Fusion |

## Key design decisions and why

1. **Two bodies, not two components.** Fusion's Part Design document doesn't
   allow sub-components. The script writes both shapes as bodies in the root
   component and offsets the fin assembly 30 mm in X so they don't overlap.
   Right-click → Save As Mesh exports each one to STL.

2. **Click-stop mechanism = bumps + recesses, sturdier variant.**
   - Bumps (0.8 mm) sit fully inside recesses (0.9 mm). At detent positions
     the collar's flat bottom touches the base's flat top → full surface
     contact, no wobble.
   - Rotation works by lifting the collar ~0.8 mm to clear the bumps, swinging
     45°, then dropping into the next pocket.
   - Considered alternative ("bumps taller than recesses" → harder click +
     floating collar). User chose flush/sturdier.

3. **Post 2 mm tall + collar 2.5 mm thick.** Post stays fully inside the
   collar hole; the fin's underside has 0.5 mm clearance above the post tip.
   Lateral retention comes from the bumps + post engagement together.

4. **Fin shape = ellipse-to-ellipse loft.** Base ellipse 14 × 4.5 mm at
   collar top, tip ellipse 5 × 1.5 mm at 25 mm above. Tapers inward in both
   axes → zero overhangs, no support material needed.

5. **`SketchEllipses.add()` takes 3 Point3D args, NOT centre+axis+radius.**
   Third argument is *any point on the ellipse*. The script uses the
   minor-axis endpoint as the third point. (Tripped on this once — the API
   error is misleading.)

## Print recommendations (PLA, 0.4 mm nozzle)

- **Layer height: 0.12 mm.** Bumps are only 0.8 mm tall — at 0.2 mm that's
  4 layers and they print lumpy.
- **Walls: 3.** Infill: **100%** (parts are tiny, infill costs nothing).
- **Orientation:** base plate post-up, fin assembly fin-up. Both flat sides
  on the bed. **No supports needed.**
- **Temps:** 205–215 °C hotend, 60 °C bed.
- **Cooling:** 100% from layer 3 — fin tip is small and needs aggressive
  cooling or it'll melt-distort.
- **Speed:** 30–40 mm/s on outer walls.
- **Brim:** 5 mm if first-layer adhesion is iffy (collar has 8 recess
  holes in its bottom, slightly reducing bed contact area).
- **Total print time estimate:** 30–45 min for both parts together.
- **Internal bridging note:** The collar's blind hole closes at 2 mm from the
  bottom, so the printer bridges Ø5 mm internally near the top of the part.
  Quality of this internal ceiling doesn't matter functionally — it's never
  touched by the post (0.5 mm clearance below it).

## Open items / things to consider for v2

These were discussed but not applied:

1. **Slimmer fin profile** — current 3:1 chord/thickness ratio is chunky for
   a hydrodynamic fin. A real boat fin would be 6:1 or 8:1.
   Suggestion if user wants this: drop `FIN_TA` from 0.45 → 0.25 and `FIN_TT`
   from 0.15 → 0.10.

2. **Fillet at post-to-base junction.** Sharp 90° corner is a stress riser if
   the fin is bumped sideways. A 0.5 mm fillet would help longevity. Not in
   the script yet.

3. **Empirical fit tuning after first print:**
   - If collar binds on the post: bump `HOLE_R` by 0.01–0.02 cm.
   - If clicks are mushy: bump `RECESS_D` by 0.01–0.02 cm.
   - If clicks are too stiff: bump `RECESS_R` by 0.01 cm.

## Iteration history (errors hit and how they were resolved)

Skim this so you don't re-hit the same walls.

1. **`addNewComponent` failed** — Part Design documents can only hold one
   component. Fixed by writing both shapes as bodies under the root component.

2. **`SketchEllipses.add()` TypeError** — third arg must be a Point3D, not a
   minor-radius float. See design decision #5.

3. **Post would crash into the fin's underside** — the fin's base ellipse
   covers the centre hole. Fixed by shortening `POST_H` to 2 mm (less than
   `COLLAR_H = 2.5 mm`).

4. **Tolerances were too tight for FDM** — original `HOLE_R = 0.22` and
   `RECESS_R = 0.09` would have been interference fits after FDM compensation.
   Loosened to current values.

5. **Visible gap around fin base** — fin's base ellipse is 4.5 mm thick but
   the through-hole was Ø5 mm, so two crescents of hole peeked out on either
   side of the fin. Fixed by switching to a **blind hole**: the collar is now
   built as a solid disk and the hole is cut from the bottom up to depth
   `HOLE_D = 2 mm`, leaving 0.5 mm of solid plastic between the post tip and
   the fin's underside. `POST_H` was reduced from 2 mm → 1.5 mm to keep
   clearance.

## How to run

1. Open Fusion 360, File → New Design.
2. Tools → Scripts and Add-ins (Shift+S) → Scripts tab → + → select
   `boatfin.py`.
3. Run. Two bodies appear in the browser, 30 mm apart.
4. Right-click each body → Save As Mesh → STL.
