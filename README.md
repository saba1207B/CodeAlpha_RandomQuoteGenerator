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

The signed Release APK is **expected to pass Google Play Protect verification** under normal conditions. A physical-device installation test has also been performed with Google Play Protect enabled. On the tested installation flow, Play Protect completed its scan and allowed installation without the previous harmful-app warning.

For this repository, a dedicated Play Protect evidence screenshot is not currently available because Play Protect may not display the scan dialog again after an APK has already been evaluated on the device. The `screenshots/` directory is retained for future evidence.

**Important:** Play Protect is a dynamic security system. Results can vary depending on the device, Android version, APK version, account/device state, and Google's current detection systems. Therefore, this project does not claim a universal guarantee for every device or every future build.

### Security/maintenance indicators

| Check | Status |
|---|---|
| Public source repository | ✅ |
| Source available for inspection | ✅ |
| Signed Release APK | ✅ |
| APK signature verified in CI | ✅ |
| Android permissions | ✅ No unnecessary permissions declared |
| Play Protect expectation | ✅ Expected to pass under normal conditions |
| Dedicated Play Protect screenshot | ⏳ Not currently available |

Keep Google Play Protect enabled when installing APKs from outside Google Play.

## 🎯 CodeAlpha Internship

This project was created as part of the **CodeAlpha App Development Internship**.

## 👨‍💻 Developer

**Sabareesh**  
GitHub: [@saba1207B](https://github.com/saba1207B)

## 📄 License

This project is provided for educational and internship purposes.
