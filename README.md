# AkiPrisaye Android

An Android application configured with secure signing for release builds and Google Play App Signing compatibility.

## 🔐 Signing Configuration

This project is configured with proper Android signing for release builds. The signing configuration uses environment variables to securely handle keystore credentials.

### Required Secrets

The following GitHub secrets must be configured in your repository:

1. **ANDROID_KEYSTORE_BASE64** - Your keystore file encoded in Base64
2. **ANDROID_KEYSTORE_PASSWORD** - Password for the keystore
3. **ANDROID_KEY_ALIAS** - Alias of the key in the keystore
4. **ANDROID_KEY_PASSWORD** - Password for the key

### How to Create and Configure Secrets

#### 1. Generate a Keystore (if you don't have one)

```bash
keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-key-alias
```

#### 2. Convert Keystore to Base64

```bash
base64 -i my-release-key.jks -o keystore-base64.txt
# On macOS, use: base64 -i my-release-key.jks -o keystore-base64.txt
# On Linux, use: base64 my-release-key.jks > keystore-base64.txt
```

#### 3. Add Secrets to GitHub

1. Go to your repository on GitHub
2. Navigate to Settings → Secrets and variables → Actions
3. Click "New repository secret"
4. Add each of the following secrets:
   - Name: `ANDROID_KEYSTORE_BASE64`, Value: (contents of keystore-base64.txt)
   - Name: `ANDROID_KEYSTORE_PASSWORD`, Value: (your keystore password)
   - Name: `ANDROID_KEY_ALIAS`, Value: (your key alias)
   - Name: `ANDROID_KEY_PASSWORD`, Value: (your key password)

## ⚙️ GitHub Actions Workflow

The GitHub Actions workflow (`.github/workflows/android-build.yml`) automatically:

1. ✅ Decodes the Base64-encoded keystore
2. ✅ Builds debug and release APKs
3. ✅ Signs the release APK with your keystore
4. ✅ Uploads build artifacts
5. ✅ Supports Android App Bundle (AAB) for Google Play

## 🏗️ Build Configuration

The `app/build.gradle.kts` file contains signing configurations that:

- Read keystore credentials from environment variables
- Configure release builds to use the signing config
- Support Google Play App Signing requirements

## 🔒 Google Play App Signing

This configuration is fully compatible with Google Play App Signing:

- The release build is signed with your upload key
- Google Play will re-sign with the app signing key
- Both APK and AAB formats are supported

## 🚀 Building Locally

### Debug Build

```bash
./gradlew assembleDebug
```

### Release Build (requires keystore environment variables)

```bash
export ANDROID_KEYSTORE_PATH=/path/to/your/keystore.jks
export ANDROID_KEYSTORE_PASSWORD=your_keystore_password
export ANDROID_KEY_ALIAS=your_key_alias
export ANDROID_KEY_PASSWORD=your_key_password

./gradlew assembleRelease
```

## 📦 Build Outputs

After a successful build, you'll find:

- Debug APK: `app/build/outputs/apk/debug/app-debug.apk`
- Release APK: `app/build/outputs/apk/release/app-release.apk`
- Release AAB: `app/build/outputs/bundle/release/app-release.aab`

## ✅ Status

- 🔐 ANDROID_KEYSTORE_BASE64 → Configured via GitHub Secrets
- 🔐 ANDROID_KEYSTORE_PASSWORD → Configured via GitHub Secrets
- 🔐 ANDROID_KEY_ALIAS → Configured via GitHub Secrets
- 🔐 ANDROID_KEY_PASSWORD → Configured via GitHub Secrets
- 🏗️ build.gradle → Signing configs OK
- ⚙️ GitHub Actions Workflow → Decoding + Signing OK
- 🔒 Google Play App Signing → Compatible