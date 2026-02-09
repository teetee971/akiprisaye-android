# Akiprisaye Android

Application Android minimaliste en Kotlin pour charger le site web Akiprisaye dans une WebView.

## Description

Cette application Android charge simplement https://akiprisaye-web.pages.dev dans une WebView native. Elle ne collecte aucune donnée personnelle.

## Caractéristiques

- **WebView native** : Affichage du site web dans l'application
- **Navigation interne** : Le bouton retour permet de naviguer dans l'historique du WebView
- **JavaScript activé** : Support complet des fonctionnalités web modernes
- **Aucune collecte de données** : Pas de tracking, pas d'analytics, respect de la vie privée
- **Prêt pour le Play Store** : Structure standard Android avec tous les fichiers nécessaires

## Structure du projet

```
akiprisaye-android/
├── app/
│   ├── build.gradle.kts           # Configuration de l'application
│   ├── proguard-rules.pro         # Règles ProGuard
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/dev/akiprisaye/android/
│           │   └── MainActivity.kt
│           └── res/
│               ├── drawable/
│               ├── mipmap-*/         # Icônes de l'application
│               └── values/
│                   ├── colors.xml
│                   ├── strings.xml
│                   └── themes.xml
├── build.gradle.kts               # Configuration du projet
├── settings.gradle.kts            # Configuration Gradle
├── gradle.properties              # Propriétés Gradle
└── gradlew                        # Wrapper Gradle
```

## Prérequis

- Android Studio Arctic Fox ou plus récent
- JDK 17 ou plus récent
- Android SDK API 34 (Android 14)
- Gradle 8.2

## Installation et build

1. Cloner le repository :
```bash
git clone https://github.com/teetee971/akiprisaye-android.git
cd akiprisaye-android
```

2. Ouvrir le projet dans Android Studio

3. Laisser Gradle synchroniser les dépendances

4. Builder le projet :
```bash
./gradlew build
```

5. Pour générer un APK de release :
```bash
./gradlew assembleRelease
```

## GitHub Actions

Le projet inclut des workflows GitHub Actions pour automatiser la construction :

### Build automatique

Le workflow `.github/workflows/android-build.yml` se déclenche sur chaque push et génère automatiquement :
- APK de debug et release
- AAB (Android App Bundle) pour le Play Store

### Release signée (optionnel)

Pour activer la génération d'AAB signé automatiquement :

1. Créer un keystore :
```bash
keytool -genkey -v -keystore akiprisaye-release.keystore -alias akiprisaye -keyalg RSA -keysize 2048 -validity 10000
```

2. Encoder le keystore en base64 :
```bash
cat akiprisaye-release.keystore | base64 -w 0
```

3. Ajouter les secrets GitHub suivants (Settings → Secrets → Actions) :
   - `ANDROID_KEYSTORE_BASE64` : Keystore encodé en base64
   - `ANDROID_KEYSTORE_PASSWORD` : Mot de passe du keystore
   - `ANDROID_KEY_ALIAS` : Alias de la clé (ex: "akiprisaye")
   - `ANDROID_KEY_PASSWORD` : Mot de passe de la clé

4. Décommenter la section `on:` dans `.github/workflows/android-release.yml`

## Configuration pour le Play Store

### 1. Signature de l'application (locale)

Ajouter dans `app/build.gradle.kts` :
```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("path/to/akiprisaye-release.keystore")
            storePassword = "your-store-password"
            keyAlias = "akiprisaye"
            keyPassword = "your-key-password"
        }
    }
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            // ...
        }
    }
}
```

### 2. Informations Play Store nécessaires

- **Application ID** : `dev.akiprisaye.android`
- **Version** : 1.0 (versionCode: 1)
- **Permissions** : INTERNET, ACCESS_NETWORK_STATE
- **API minimale** : 24 (Android 7.0)
- **API cible** : 34 (Android 14)

## Sécurité et confidentialité

- Aucune donnée utilisateur n'est collectée
- Aucun tracker ou analytics
- Communication uniquement avec https://akiprisaye-web.pages.dev
- Pas d'accès à la caméra, microphone, ou autres capteurs
- Code source ouvert et auditable

## Licence

Ce projet est open source. Voir le fichier LICENSE pour plus de détails.

## Contact

Pour toute question ou problème, ouvrir une issue sur GitHub.
