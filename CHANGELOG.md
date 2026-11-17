<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Code Gschpänli Changelog

## [Unreleased]

### Added

- Custom pets: import your own pixel-art pets from text files with **Tools | Code Gschpänli | Import Custom Pets...**
  (also in Adopt a Pet and in the settings). They form their own *Custom* group, can be adopted, and visit like the
  others (untick *Custom pets* under the visitor settings to keep them from visiting). The files are copied to
  `~/.code-gschpaenli/custom-pets`, shared by all your JetBrains IDEs; a file with a mistake is skipped with its line
  number. The settings list your custom pets with a preview and can delete them or open the folder.
- A guide to making pets, by hand or with an AI assistant, with the file format, drawing tips and a template:
  [docs/custom-pets.md](https://github.com/ProgrammiererEFZ/code-gschpaenli/blob/main/docs/custom-pets.md).
- 11 more pixel-art species: koala (a pixel-art one next to the cartoon koala), armadillo (rolls into a ball), beaver,
  polar bear cub (belly-slides), octopus (puffs ink when it falls), caterpillar (sleeps in a cocoon), alpaca, wolf pup
  (howls), ring-tailed lemur, mole (tunnels through dirt mounds) and baby dragon (puffs smoke rings), each in several
  colours.

### Changed

- The pixel-art gallery image shows all 50 pixel-art species.

## [0.1.3] - 2026-11-16

### Added

- 17 more pixel-art species: fox, bunny, red panda, sloth, flamingo, goat, cow (one colour is a brown Swiss cow
  with a bell), pony, fawn, hippo, elephant, kangaroo, platypus, chameleon (catches bugs with its tongue), puffin,
  toucan and meerkat, each in several colours.

### Changed

- Pixel art is now the default style: Adopt a Pet opens on the pixel-art pets, and first-time users get an orange
  pixel-art cat. Cartoon pets are still one click away in the Style box.
- The pixel-art gallery image shows all 39 pixel-art species.

### Fixed

- Dragging a pet no longer stutters or trails behind the cursor on Linux (KDE Plasma on Wayland and others): the pet
  still follows every mouse event, but the IDE under it is repainted at most once per frame instead of once per event,
  which high-polling-rate mice turned into up to 1000 repaints per second (#3).
- No longer uses `FileEditorManager.openFile`, which IntelliJ IDEA 2026.3 deprecates (reported by the JetBrains
  Marketplace verifier). It was only called by the developer benchmark and screenshot tools.

## [0.1.2] - 2026-11-14

### Added

- Pets that live on the IDE window itself: they walk along the window header and status bar, nap on tool windows,
  climb tool window borders, jump between surfaces and chase balls you throw.
- Two art styles: smooth cartoon pets (cat, dog, fox, bunny, panda, raccoon, hamster, pig) and pixel-art pets
  (cat, dog, duck, frog, hedgehog, penguin, mouse, turtle), each in several colours.
- Random visitors that drop by and leave again, on by default with 1 to 3 at a time.
- Right-click menu on every pet: Pet, Play Ball, Follow Me, Take a Nap / Wake Up, Stay / Free to Roam, Rename...,
  Color, Adopt (visitors) and Leave. An adopted pet that leaves comes back at the next IDE start or with Roll Call.
- Settings page with size, speed, activity, name tags, visitors and which IDE parts pets may walk on.
- New species: cartoon koala (big fluffy ears and nose), sheep (woolly fleece and cap) and lion (mane and tufted
  tail), and pixel-art owl (blinks, cocks its head, hops and flaps its wings), squirrel (bounds along in hops, sits up
  to nibble an acorn, sleeps under its bushy tail), ladybug and seal (galumphs along, belly-slides when running).
- More pixel-art species: chicken, axolotl, parrot, cockatoo (crest fans up when excited), bee, crab, snail, bat,
  ocelot and otter, each in several colours.

### Changed

- The plugin icon is now pixel art: the orange pixel cat peeking over an edge, paws first.

### Fixed

- Cartoon pets' near legs are drawn in front of the light belly and coat markings instead of disappearing behind them.
- Throwing a ball while the previous one was still around could show both balls at once when the animation was
  paused, e.g. because the Find Action popup had focus.

[Unreleased]: https://github.com/ProgrammiererEFZ/code-gschpaenli/compare/v0.1.3...HEAD
[0.1.3]: https://github.com/ProgrammiererEFZ/code-gschpaenli/compare/v0.1.2...v0.1.3
[0.1.2]: https://github.com/ProgrammiererEFZ/code-gschpaenli/commits/v0.1.2
