# Custom pets

You can add your own pixel-art pets to Code Gschpänli. A pet is one plain-text file: a few pixel-art frames drawn with
letters, which animations use which frames, and one or more colourings. Imported pets get their own **Custom** group:
you can adopt them like any other pet, and they drop by as visitors.

- [Import pets](#import-pets)
- [Make a pet](#make-a-pet): [a small example](#a-small-example), [the file format](#the-file-format),
  [drawing tips](#drawing-tips), [making pets with an AI assistant](#making-pets-with-an-ai-assistant),
  [checklist](#checklist)

## Import pets

Any of these opens a file chooser. Choose one or more pet files (`.txt`), or folders: every `.txt` file directly inside
a chosen folder is imported.

- **Tools | Code Gschpänli | Import Custom Pets...**
- *Settings | Tools | Code Gschpänli*, section *Custom pets*: the **+** button
- **Adopt a Pet...**: the *Import custom pets...* link

Then adopt one with **Tools | Code Gschpänli | Adopt a Pet...** (style *Custom*), or wait for one to visit.

Good to know:

- Imported files are **copied** to `.code-gschpaenli/custom-pets` in your home folder (on Windows
  `C:\Users\<you>\.code-gschpaenli\custom-pets`). All your JetBrains IDEs with the plugin share this folder, so a pet
  imported in IntelliJ IDEA is in PyCharm and PhpStorm too. You can also copy files there yourself and click
  **Reload** in the settings.
- Pets are listed in the order of their file names, so `001_sprout.txt`, `002_pebble.txt`, ... keeps a series in order.
- Importing a pet with the same `ANIMAL` name as an existing custom pet replaces it, so you can fix a pet and import it
  again.
- A file with a mistake is skipped, and you're told the line and what's wrong. All other files are still imported.
- The *Custom pets* section of the settings lists your custom pets with a preview. The toolbar deletes one (its adopted
  pets leave too), opens the folder, and reloads it.
- Custom visitors: under *Visitors can be*, untick *Custom pets* if only your adopted custom pets should be around.

## Make a pet

### A small example

This is a complete pet. Save it as `blob.txt` and import it:

```text
ANIMAL: Blob
CANVAS: 10 x 8
SLOT NOTES: A = shading under the body

FRAME STAND
..........
...OOOO...
..OBBBBO..
.OBBBYWBO.
.OBBBYYBO.
.OLLLLLLO.
.OAAAAAAO.
..OOOOOO..

FRAME STAND_BLINK
..........
...OOOO...
..OBBBBO..
.OBBBBBBO.
.OBBBOOBO.
.OLLLLLLO.
.OAAAAAAO.
..OOOOOO..

FRAME SQUISH
..........
..........
..OOOOOO..
.OBBBYWBO.
.OBBBYYBO.
OLLLLLLLLO
OAAAAAAAAO
.OOOOOOOO.

ANIMATIONS
STAND  2.5 fps : STAND STAND STAND STAND_BLINK
WALK   stride  : STAND SQUISH STAND SQUISH

PALETTES (B L G E O Y N A T)
Lime  : #8BD450 #D8F5B0 #6BAE3A #6BAE3A #234015 #1E1E24 #234015 #6BAE3A #FFFFFF
Berry : #D2508B #F7C6DC #A83A6C #A83A6C #3E1226 #1E1E24 #3E1226 #A83A6C #FFFFFF
```

A full pet has an animation for every pose. [`custom-pets/example-frog.txt`](custom-pets/example-frog.txt) is the
built-in pixel-art frog in this format: a good template to copy.

### The file format

A pet file has four parts, in this order: the header, the frames, `ANIMATIONS` and `PALETTES`. Empty lines separate
frames; upper and lower case don't matter in keywords and frame names.

#### Header

| Line | Meaning |
|---|---|
| `ANIMAL: <name>` | Required. The name shown in the menus, at most 30 characters. It identifies the pet: importing another file with the same name replaces it. |
| `CANVAS: <width> x <height>` | Required. The size of every frame in pixels: at least 6 x 6, at most 28 x 24. Use **20 x 16** for upright animals and **20 x 14** for low, flat ones; long animals can be up to 24 wide. |
| `SLOT NOTES: ...` | Optional notes for people, e.g. which slot is used for what. The plugin ignores this and any other `KEY: value` line in the header. |

#### Frames

`FRAME <name>` followed by exactly *height* rows of exactly *width* characters. Names use letters, digits, `_` and
`-` (`STAND`, `STAND_BLINK`, `WALK_1`). One character is one pixel. A character is a colour *slot*, not a colour: each
colouring in `PALETTES` fills the slots differently, so the same frames work for every colouring.

| Char | Slot | Typical use |
|---|---|---|
| `.` | transparent | background |
| `O` | outline | the darkest colour, outlines |
| `B` | body | main fur, feathers, shell |
| `L` | light | belly, muzzle, chest |
| `G` | legs | legs, paws, feet |
| `E` | ear / second colour | inner ear, beak, a second colour |
| `A` | accent | stripes, spots, shading, the far legs |
| `T` | tip / highlight | tail tip, whiskers, highlights |
| `Y` | eye | pupils, iris |
| `N` | nose | nose, beak, mouth |
| `W` | white (always `#FFFFFF`) | eye highlights, wide-open eyes |
| `K` | black (always `#141418`) | open mouth, pupils in startled eyes |
| `P` | pink (always `#FF8FA3`) | cheek blush |

The slot names are only suggestions. Use a slot for whatever your pet needs (say `E` for a flame or `T` for sparks) and
write it down in `SLOT NOTES`.

How the plugin shows a frame:

- The pet faces **right**. Frames are mirrored when it walks to the left.
- It stands on the **bottom row**: the feet (or the belly, for pets without legs) touch the last row.
- It's centred on the middle column. Keep the body there in every frame, or the pet jumps sideways when it turns.
- Pixels are enlarged to whole screen pixels with hard edges, at the same scale for all pets, so a 20 x 16 pet is about
  as big as the built-in pets.
- `WALK` frames are also used, turned by 90 degrees, when the pet climbs up or down a wall.

#### ANIMATIONS

One line per pose: `<POSE> <speed> : <frames>`. The frames play in a loop; list a frame several times to hold it,
which is how you make rare idle moves (`STAND STAND STAND STAND_TAIL STAND STAND_BLINK`). The speed is `<n> fps`
(frames per second), or `stride` for poses whose frames follow the pet's steps (`WALK`, `RUN`). Without a speed a pose
gets the usual one from the table.

| Pose | What to draw | Frames | Usual speed |
|---|---|---|---|
| `STAND` | Required. Relaxed standing: a base frame, a blink, 1-2 idle moves (tail flick, ear twitch, sniff) | 3-4 distinct, 6-9 in the loop | 2.5 fps |
| `WALK` | Steps: contact, passing, contact (other legs), passing. The body 1 pixel higher on the passing frames, far legs in `A` | 4 | stride |
| `RUN` | Gallop or bound: stretched and gathered body, longer reach. Leave it out for pets that never run | 4 | stride |
| `SIT` | Upright, tail wrapped forward; a blink | 1-3 | 2 fps |
| `SLEEP` | Curled up or lying on the bottom rows, eyes closed; the second frame breathes 1 pixel higher | 2 | 1.2 fps |
| `JUMP` | Launch: body stretched diagonally, hind legs extended. Flyers: 2 or more wing beats | 1 | 1 fps (wing beats 10-14) |
| `FALL` | Startled: wide eyes (`W` with a `K` pupil), open mouth (`K`), limbs flailing in turns | 2 | 6-8 fps |
| `HELD` | Picked up by the scruff: front view, head at the top row, startled face, legs dangling and kicking in turns | 2 | 4 fps |

Only `STAND` is required; a missing pose borrows a related one (no `RUN`: `WALK`; no `SLEEP`: `SIT`; no `HELD`: `FALL`,
then `JUMP`; and so on). A pet with all eight poses looks best. About 20 distinct frames is typical.

#### PALETTES

`PALETTES (B L G E O Y N A T)` followed by one line per colouring: a name, a colon, and nine colours `#RRGGBB` in the
order of the header (`#` is optional). The first colouring is the default. 2-4 colourings is a good number; natural
colours first.

- `O` should be the darkest colour, so the outline closes the pet on light and dark IDE themes.
- `L` is usually lighter than `B`, and `A` darker than `B`.
- The eye colour must stand out against the face.

### Drawing tips

- **Original designs.** Draw your own pets; don't copy sprites from games.
- **Cute and chunky:** a slightly big head, round shapes, a clear silhouette that reads at a glance.
- **Side view.** The head in profile (one eye) or turned towards the viewer (two eyes); keep that in all frames except
  `HELD`, which is a front view.
- **One closed outline.** A 1-pixel `O` line around the whole pet, also under the feet. Inner `O` lines only where parts
  overlap (head over body, near leg over body). Thin details like whiskers or antennae may be single pixels.
- **Round corners.** Step the outline diagonally at the corners of head, body and legs; boxy shapes look stiff.
- **Eyes** are 2 x 2: eye colour plus one `W` highlight on top, `YY` below. To blink, the lower row becomes `O` and the
  upper row the colour around the eye. A `P` blush pixel on the cheek is optional.
- **Flat colours.** No dithering or noise; shade with `A`, brighten with `L`.
- **Leave room.** 1-2 empty rows above the head in `STAND`, so the pet can hop and bob.
- **Small steps.** Between frames, move only what moves, by 1 pixel at a time, and keep the proportions.
- **Sleep.** Draw `SLEEP` carefully once, then make the second frame by moving only the back up 1 pixel, not the feet.
- **No extras.** No text, ground lines, shadows or props, except an item that belongs to the pet. Everything must still
  look right when mirrored.

### Making pets with an AI assistant

Chat assistants are good at this format, and can make a whole series of pets for you. Paste the request below and
replace the part in angle brackets. Assistants that can read web pages can follow the link; otherwise paste this whole
guide along with it.

```
Draw <animal or character> as an animated pixel-art pet for the Code Gschpänli IDE plugin. Follow this guide
exactly: https://github.com/ProgrammiererEFZ/code-gschpaenli/blob/main/docs/custom-pets.md

- Canvas 20 x 16 (or 20 x 14 for a low, flat animal), facing right, feet on the bottom row, centred.
- Frames: STAND (3-4: base, blink, idle moves), WALK (4), RUN (4), SIT (1-3), SLEEP (2), JUMP (1), FALL (2), HELD (2).
- 3 colourings, the natural one first.
- Before you answer, check every frame: each row has exactly 20 characters, each frame exactly 16 rows, only the
  characters . O B L G E A T Y N W K P, and the outline is closed.
- Answer with the pet file only, in one plain-text block.
```

Save the answer as a `.txt` file and import it. If the import reports a problem, give the message (it names the line)
back to the assistant and ask it to fix the file. Assistants that can run code do best when they write a small script
that builds the frames from a hand-drawn base frame and checks the row lengths, instead of typing every frame by hand.

**Characters from games, films or comics:** you can make fan-art pets of them for yourself, but they are usually
protected by copyright and trademarks, so don't publish or share those files.

### Checklist

- [ ] `ANIMAL` and `CANVAS` lines at the top.
- [ ] Every row of every frame has the same length; every frame has the same number of rows.
- [ ] Only `. O B L G E A T Y N W K P` in the frames, no spaces.
- [ ] A `STAND` animation; `WALK` and `RUN` with 4 frames each.
- [ ] Feet on the last row in `STAND`, `WALK`, `RUN`, `SIT` and `SLEEP`; the body centred and not drifting between frames.
- [ ] The outline is closed, and nothing looks wrong when the frame is mirrored.
- [ ] Nine colours per colouring, `O` the darkest.
