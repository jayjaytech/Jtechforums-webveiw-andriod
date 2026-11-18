# JTechForums for Android

A small Android app (Android 7.0+, `minSdk 24`) that shows the JTechForums website full-screen in a WebView.

- Back button walks back through pages; all links open inside the app.
- Stays logged in (cookies kept), file/photo attachments and downloads work, `alert()`/`confirm()` dialogs work, offline shows a "Try again" page.

## Set the forum address
Edit `SITE_URL` and `SITE_HOST` in `app/build.gradle.kts` (default is a placeholder: `https://jtechforums.org/`).

## Build
Needs JDK 17+ and the Android SDK (API 34):

```bash
ANDROID_HOME=/path/to/sdk ./gradlew assembleRelease
```
The APK appears in `app/build/outputs/apk/release/`. Sideload it (allow "install unknown apps"). It is signed with `keystore/jtechforums.jks`; keep using it so updates install over old versions, and bump `versionCode` each release.
