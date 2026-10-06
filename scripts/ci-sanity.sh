#!/usr/bin/env bash
set -euo pipefail
grep -q 'applicationId = "ir.madreseyar.teacher"' app/build.gradle.kts
grep -q 'versionName = "1.1.0"' app/build.gradle.kts
grep -q 'android:label="مدرسه‌یار معلم"' app/src/main/AndroidManifest.xml
grep -q 'class MainActivity' app/src/main/java/ir/madreseyar/teacher/MainActivity.kt
grep -q 'MadreseyarTeacherAndroid/1.1.0' app/src/main/java/ir/madreseyar/teacher/MainActivity.kt
echo 'Madreseyar Teacher GitHub package sanity check: PASS'
