#!/usr/bin/env bash
# Start the emulator
echo "emulator is getting started" &
emulator -avd Nexus_5_API_22 -no-boot-anim -no-snapshot-load -no-snapshot-save -no-window &
sleep 30m &

# Start appium
echo "Appium is getting started" &
appium --address "127.0.0.1" --session-override --pre-launch --debug-log-spacing --default-capabilities '{"platformName":"Android","platformVersion":"5.1","automationName":"Appium","deviceName":"Nexus_5_API_22"}' &
sleep 30m &

# Start test from maven
echo "Test is getting started" &
mvn clean test &

# end appium session
ps -A | grep 'bin/appium'| awk '{print $1}' | while read line; do kill -9 $line;done &

# close simulator
adb devices | grep emulator | awk '{print $1}' | while read line; do adb -s $line emu kill; done