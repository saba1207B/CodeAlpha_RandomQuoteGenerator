# ✨ Random Quote Generator

A native Android application that displays inspirational quotes and provides simple actions for generating, copying, sharing, and favoriting quotes.

## ✨ Features

- 💬 Display random inspirational quotes.
- 🔄 Generate a new quote with **New Quote**.
- 📋 Copy the current quote to the clipboard.
- 📤 Share the current quote using Android's share functionality.
- ❤️ Favorite quotes.
- 🎨 Clean Android user interface.

## 🛠️ Technology Stack

- **Platform:** Android
- **Language:** Kotlin
- **Build System:** Gradle / Kotlin DSL
- **UI:** Native Android UI
- **CI/CD:** GitHub Actions

## 🚀 Build the Project

For local development/testing:

```bash
./gradlew assembleDebug
```

For a Release build:

```bash
./gradlew assembleRelease
```

The Release APK is normally generated at:

```text
app/build/outputs/apk/release/app-release.apk
```

## 🤖 GitHub Actions APK Build

The repository includes a GitHub Actions workflow that builds a **signed Release APK**.

The current workflow:

1. Checks out the repository.
2. Configures the Java/Gradle build environment.
3. Generates a CI release signing key.
4. Builds the application with `assembleRelease`.
5. Verifies the APK signature.
6. Uploads the signed Release APK as a workflow artifact.

To obtain the latest CI-built APK:

1. Open the repository on GitHub.
2. Go to **Actions**.
3. Open the latest successful Android workflow run.
4. Download the signed Release APK artifact.
5. Extract the artifact to access the APK.

> **Signing note:** The current CI workflow generates an ephemeral signing key for each CI build. For a production application with future updates, a stable developer signing key should be securely retained and reused.

## 🛡️ Google Play Protect & Security Verification

This project is maintained transparently in a public GitHub repository, with its Android source code, build configuration, and CI workflow available for inspection.

The submitted APK is generated from the repository source through GitHub Actions as a **signed Release APK**, and the workflow verifies the APK signature before publishing the build artifact.

### Play Protect status

A physical-device installation test has been performed with Google Play Protect enabled. The tested APK completed the available Play Protect installation check and was allowed to install without the previous harmful-app warning.

This should be understood as an **observed test result for the tested APK and device**, not as a universal Play Protect approval or certification.

**Important device-compatibility note:** Google Play Protect is a dynamic security system. The exact scan screen, warning, or safe-to-install message may not appear on every device or installation. Results and displayed messages can vary depending on the device, Android version, Google Play services, account/device state, APK version, installation history, and Google's current security systems. Therefore, this project does not claim that every device will display the same verification screen or produce the same result for every future build.

A dedicated Play Protect screenshot is not currently available in this repository because the device may not display the same installation-scan dialog again after an APK has already been evaluated. The `screenshots/` directory is retained for future evidence.

### Security/maintenance indicators

| Check | Status |
|---|---|
| Public source repository | ✅ |
| Source available for inspection | ✅ |
| Signed Release APK | ✅ |
| APK signature verified in CI | ✅ |
| Android permissions | ✅ No unnecessary permissions declared |
| Physical-device Play Protect test | ✅ Completed |
| Universal Play Protect approval/certification | ❌ Not claimed |
| Dedicated Play Protect screenshot | ⏳ Not currently available |

Keep Google Play Protect enabled when installing APKs from outside Google Play.

## 🎯 CodeAlpha Internship

This project was created as part of the **CodeAlpha App Development Internship**.

## 👨‍💻 Developer

**Sabareesh**  
GitHub: [@saba1207B](https://github.com/saba1207B)

## 📄 License

This project is provided for educational and internship purposes.
