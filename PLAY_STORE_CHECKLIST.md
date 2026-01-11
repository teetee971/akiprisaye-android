# Google Play Store Submission Checklist

## ✅ Technical Compliance (COMPLETE)

- [x] **Target SDK 34** - Required by Google Play (August 2023+)
- [x] **Compile SDK 34** - Latest Android APIs
- [x] **Data Extraction Rules** - Android 12+ compliance
- [x] **Backup Rules** - Proper data backup configuration
- [x] **Code Shrinking Enabled** - R8 optimization active
- [x] **ProGuard Rules** - Proper obfuscation configuration
- [x] **Signing Config** - Environment variable based, secure
- [x] **No Dangerous Permissions** - Zero permissions declared
- [x] **No Debug Signing in Release** - Proper build separation
- [x] **AAB Build Support** - bundleRelease task configured

## 🔄 Pre-Upload Testing (TO DO)

- [ ] Build release AAB successfully: `./gradlew bundleRelease`
- [ ] Verify AAB with bundletool
- [ ] Test on physical device
- [ ] Verify app launches correctly
- [ ] Test on different Android versions (24-34)
- [ ] Check for crashes or ANRs
- [ ] Verify ProGuard doesn't break functionality

## 📝 Play Console Configuration (TO DO)

### Store Listing
- [ ] App name: "AkiPrisaye"
- [ ] Short description (80 chars)
- [ ] Full description (4000 chars)
- [ ] App icon (512x512 PNG)
- [ ] Feature graphic (1024x500)
- [ ] Screenshots (minimum 2, recommended 8)
- [ ] App category selection
- [ ] Content rating questionnaire

### Data Safety
- [ ] Declare: "No data collected"
- [ ] Confirm: No data sharing with third parties
- [ ] Confirm: All processing is local

### Distribution
- [ ] Select target countries
- [ ] Set pricing (Free)
- [ ] Add support email
- [ ] Privacy policy URL (recommended)

### Internal Testing
- [ ] Upload signed AAB
- [ ] Add internal testers (email addresses)
- [ ] Create release notes
- [ ] Start rollout

## 🔐 GitHub Secrets (REQUIRED FOR CI/CD)

Ensure these secrets are configured in repository settings:

- [ ] `ANDROID_KEYSTORE_BASE64` - Base64 encoded keystore
- [ ] `ANDROID_KEYSTORE_PASSWORD` - Keystore password
- [ ] `ANDROID_KEY_ALIAS` - Key alias name
- [ ] `ANDROID_KEY_PASSWORD` - Key password

## 📊 File Checklist

All required files present:

- [x] `app/build.gradle.kts` - Updated with SDK 34
- [x] `app/src/main/AndroidManifest.xml` - Backup rules configured
- [x] `app/src/main/res/xml/backup_rules.xml` - Created
- [x] `app/src/main/res/xml/data_extraction_rules.xml` - Created
- [x] `app/proguard-rules.pro` - Enhanced rules
- [x] `.github/workflows/android-build.yml` - CI/CD configured
- [x] `GOOGLE_PLAY_AUDIT_REPORT.md` - Full audit documentation
- [x] `IMPLEMENTATION_SUMMARY.md` - Implementation details

## 🎯 Quick Commands

### Build Release AAB
```bash
export ANDROID_KEYSTORE_PATH=/path/to/keystore.jks
export ANDROID_KEYSTORE_PASSWORD=your_password
export ANDROID_KEY_ALIAS=your_alias
export ANDROID_KEY_PASSWORD=your_key_password
./gradlew clean bundleRelease
```

### Verify AAB Location
```bash
ls -lh app/build/outputs/bundle/release/app-release.aab
```

### Test with bundletool
```bash
bundletool build-apks --bundle=app/build/outputs/bundle/release/app-release.aab \
  --output=app.apks \
  --mode=universal \
  --ks=/path/to/keystore.jks \
  --ks-key-alias=your_alias \
  --ks-pass=pass:your_keystore_password \
  --key-pass=pass:your_key_password
```

### Install Test APK
```bash
bundletool install-apks --apks=app.apks
```

## 🚨 Critical Reminders

1. **Never commit keystore files** - Use GitHub Secrets only
2. **Test thoroughly** on Internal Testing before Production
3. **Version codes must increment** with each upload
4. **Keep keystore secure** - Loss means you can't update the app
5. **Privacy policy recommended** even if no data collected

## 📈 Current Status

**READY FOR INTERNAL TESTING** ✅

All technical compliance issues resolved. App can be uploaded to Play Console Internal Testing track.

**Production readiness:** Consider adding more functionality before public release.

---

**For questions or issues, refer to:**
- `GOOGLE_PLAY_AUDIT_REPORT.md` - Complete audit findings
- `IMPLEMENTATION_SUMMARY.md` - Detailed implementation notes
- [Google Play Console Help](https://support.google.com/googleplay/android-developer)
