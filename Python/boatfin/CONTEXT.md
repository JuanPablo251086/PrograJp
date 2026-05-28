# Boat Fin Project — Handoff Context

> Read this first if you're picking up the project on a new machine or in a new
> Claude Code session. Everything you need to continue the design conversation
> is in here. Pair it with [boatfin.py](boatfin.py).

## What this is

A small fin for a ~11 × 22 cm boat, 3-D-printable in PLA. Modelled
parametrically in Autodesk Fusion 360 via a Python script. Two pieces:

- **Fin_Base_Plate** — flat disk glued to the hull. Has a centre post and 8
  Ø2 mm pilot holes around a 10 mm-radius ring on its top face.
- **Fin_Assembly** — collar that drops onto the post, with the fin lofted
  out of its top face. 8 Ø2.5 mm clearance holes through the collar align
  with the base's pilot holes; the user picks any 45° rotation at install
  and bolts it down with 8 × M2.5 × 8 mm self-tapping screws.

User is targeting FDM PLA printing on a standard 0.4 mm-nozzle machine.

## Hard requirements from the user

- Fin "about 2.5 cm at its tallest" → matches `FIN_H = 2.50` (25 mm)
- Circular base — originally with click-stop rotation; **as of 2026-05-27 the
  pop-in detent design was scrapped as unfeasible** and replaced with screwed
  attachment (8 × M2.5). Rotation is still selectable at install time in 45°
  increments by which holes you line up; once tightened it's locked.
- Base is glued to the hull (so its bottom face is the flat side)
- User said don't worry about modelling the boat itself

## Current dimensions (all in cm, Fusion's internal unit)

These live at the top of `boatfin.py`. Each one has a reason — don't change
casually without re-reading the rationale below.

| Param | Value | Real | Rationale |
|---|---|---|---|
| `BASE_R` | 1.30 | Ø26 mm | Expanded from Ø22 → Ø26 so screw holes at 10 mm ring have FDM-safe outer wall (~1.75 mm) |
| `BASE_H` | 0.40 | 4 mm | Thicker than original 3 mm — gives ~2 D thread engagement for M2.5 self-tap into PLA |
| `POST_R` | 0.20 | Ø4 mm | Alignment post (no longer load-bearing — screws take the load) |
| `POST_H` | 0.15 | 1.5 mm | Engages 1.5 mm into the blind hole; 0.5 mm clearance below the ceiling |
| `SCREW_RNG` | 1.00 | 10 mm | Ring radius for the 8 screw holes; clears the 14 mm fin chord with margin |
| `SCREW_TAP_R` | 0.10 | Ø2.0 mm | Base-plate pilot — M2.5 self-taps into PLA at this hole size |
| `SCREW_CLR_R` | 0.125 | Ø2.5 mm | Collar clearance hole — line-to-line on M2.5 shank (snug after FDM shrink) |
| `N_SCREWS` | 8 | — | 8 positions every 45° — pick rotation at install, then lock |
| `COLLAR_R` | 1.30 | Ø26 mm | Matches base — holes must line up |
| `COLLAR_H` | 0.25 | 2.5 mm | Thick enough that the M3 screw head sits above the print without crushing the fin base |
| `HOLE_R` | 0.25 | Ø5 mm | **Blind hole** (not through). 1 mm diametric clearance on Ø4 post |
| `HOLE_D` | 0.20 | 2.0 mm | Blind-hole depth — leaves 0.5 mm solid ceiling so fin doesn't expose a gap |
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

2. **Screwed attachment, M2.5 × 8, around a 10 mm ring (2026-05-27 redesign).**
   - The original pop-in / detent click-stop was abandoned as unfeasible.
   - Base plate has 8 pilot holes (Ø2 mm) sized so an M2.5 self-tapping
     screw cuts fresh threads in PLA. Collar has matching Ø2.5 mm clearance
     holes (line-to-line on the screw shank — snug fit after FDM shrink).
     Same 8-fold symmetry → 8 rotation positions selectable at install.
   - Plate diameter grew from Ø22 → Ø26 mm and thickness from 3 → 4 mm to
     give proper FDM-safe walls around the screw holes and enough thread
     engagement (~2 D) for M2.5 into plastic.
   - Recommended fastener: M2.5 × 8 mm self-tapping (4 mm in base + 2.5 mm
     in collar = 6.5 mm engaged; 8 mm screws have ~1.5 mm of head-side
     standoff).
   - **Sizing note (2026-05-27):** First pass used M3 dimensions (Ø2.5 pilot,
     Ø3.4 clearance); user shrank both to Ø2 / Ø2.5 to switch to M2.5 hardware.

3. **Post is now just an alignment aid.** Post stays fully inside the collar
   hole; the fin's underside has 0.5 mm clearance above the post tip.
   Lateral and pull-off retention now come entirely from the 8 screws — the
   post just centres the collar before screws go in (no third-hand required).

4. **Fin shape = ellipse-to-ellipse loft.** Base ellipse 14 × 4.5 mm at
   collar top, tip ellipse 5 × 1.5 mm at 25 mm above. Tapers inward in both
   axes → zero overhangs, no support material needed.

5. **`SketchEllipses.add()` takes 3 Point3D args, NOT centre+axis+radius.**
   Third argument is *any point on the ellipse*. The script uses the
   minor-axis endpoint as the third point. (Tripped on this once — the API
   error is misleading.)

## Print recommendations (PLA, 0.4 mm nozzle)

- **Layer height: 0.15–0.20 mm.** No more detent-bump fine features to worry
  about — the smallest critical feature is now the Ø2.5 mm tap hole, which
  prints cleanly at any of these layer heights.
- **Walls: 3.** Infill: **100%** (parts are tiny, infill costs nothing).
  100% infill matters for the base plate — the screw threads bite into solid
  PLA, not into infill voids.
- **Orientation:** base plate post-up, fin assembly fin-up. Both flat sides
  on the bed. **No supports needed.**
- **Temps:** 205–215 °C hotend, 60 °C bed.
- **Cooling:** 100% from layer 3 — fin tip is small and needs aggressive
  cooling or it'll melt-distort.
- **Speed:** 30–40 mm/s on outer walls.
- **Brim:** 5 mm if first-layer adhesion is iffy (collar has 8 through-holes
  in its bottom, slightly reducing bed contact area).
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
   - If M2.5 screws bind / strip the pilot holes: bump `SCREW_TAP_R` by 0.01 cm.
   - If the collar holes won't accept the screw shanks (likely with current
     line-to-line sizing after FDM shrink): bump `SCREW_CLR_R` by 0.01–0.02 cm.
   - If the collar holes end up sloppy on the screws: drop `SCREW_CLR_R`
     by 0.005 cm.
   - If you'd rather use heat-set inserts than self-tapping: set
     `SCREW_TAP_R` to the insert's outer radius and shorten the cut depth.

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

6. **Pop-in detent design scrapped (2026-05-27)** — bumps + recesses turned
   out to be unfeasible in practice. Replaced with M3 screwed attachment.
   The 8-fold symmetry is preserved so rotation is still selectable at
   install (every 45°) — but now it's permanent until you unscrew it.
   Plate diameter grew Ø22 → Ø26 mm and thickness 3 → 4 mm to host the
   screw holes with FDM-safe walls and proper thread engagement.

## How to run

1. Open Fusion 360, File → New Design.
2. Tools → Scripts and Add-ins (Shift+S) → Scripts tab → + → select
   `boatfin.py`.
3. Run. Two bodies appear in the browser, 30 mm apart.
4. Right-click each body → Save As Mesh → STL.
