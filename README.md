# Orca Client — Minecraft 26.3

Fresh Fabric client starter for Minecraft 26.3.

## Requirements
- Windows
- JDK 25
- Internet connection for the first build

Fabric's 26.3 guidance uses Loom 1.17, Gradle 9.6.0, and Fabric Loader 0.19.5.
This project uses official/unobfuscated Minecraft names rather than Yarn mappings.

## Build a JAR

Double-click `build.bat`, or open CMD in this folder and run:

    gradlew.bat build

The finished JAR will be in:

    build\libs\

## Run Minecraft from the development environment

Run:

    gradlew.bat runClient

or double-click `run-client.bat`.

## Open Orca Client

Press Right Shift.

## Current starter features
- Floating non-fullscreen window
- Draggable window
- Ocean-themed interface
- Sidebar categories
- Home dashboard
- Orca AI placeholder panel
- FPS/Ping/Time/Name cards
- Right Shift keybind
