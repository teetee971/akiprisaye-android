# Guide de Publication Play Store - Akiprisaye

Ce document contient toutes les informations nécessaires pour publier l'application sur le Google Play Store.

## Informations de Base

### Nom de l'Application
**Akiprisaye**

### Description Courte (80 caractères max)
Application officielle Akiprisaye - Accès rapide au site web

### Description Complète

Bienvenue sur l'application mobile officielle Akiprisaye !

Cette application vous permet d'accéder rapidement et facilement au site web Akiprisaye (https://akiprisaye-web.pages.dev) directement depuis votre smartphone ou tablette Android.

Caractéristiques :
✅ Interface simple et épurée
✅ Navigation fluide et rapide
✅ Pas de publicité
✅ Aucune collecte de données personnelles
✅ Respect total de votre vie privée
✅ Code source ouvert (open source)

L'application est un simple conteneur web optimisé pour offrir la meilleure expérience possible du site Akiprisaye sur mobile. Toutes les fonctionnalités du site web sont accessibles directement dans l'application.

Sécurité et Confidentialité :
🔒 Communication sécurisée (HTTPS uniquement)
🔒 Aucun tracker ou analytics
🔒 Aucune donnée collectée ou partagée
🔒 Code source auditable sur GitHub

Cette application est parfaite si vous utilisez régulièrement le site Akiprisaye et souhaitez y accéder plus rapidement depuis votre appareil mobile.

---

## Catégorie
**Outils** ou **Productivité**

## Type de contenu
Application / Tous publics

## Adresse e-mail de contact
À renseigner avec votre email

## Site web
https://akiprisaye-web.pages.dev

## Politique de confidentialité
https://github.com/teetee971/akiprisaye-android/blob/main/PRIVACY_POLICY.md

---

## Captures d'écran requises

Pour publier sur le Play Store, vous aurez besoin de :

### Smartphone (Requis)
- Minimum : 2 captures d'écran
- Maximum : 8 captures d'écran
- Dimensions : 16:9 ratio
- Résolution min : 320px
- Résolution max : 3840px

**Suggestions de captures d'écran :**
1. Page d'accueil du site dans l'application
2. Navigation dans le site
3. Exemple de contenu

### Tablette 7 pouces (Optionnel mais recommandé)
- Même format que smartphone

### Tablette 10 pouces (Optionnel mais recommandé)
- Même format que smartphone

### Bannière (Requis pour certaines sections)
- Dimensions : 1024 x 500 pixels
- Format : PNG ou JPEG

### Icône de l'application
- Dimensions : 512 x 512 pixels
- Format : PNG 32-bit avec alpha channel
- L'icône actuelle dans le projet convient, il faudra peut-être la personnaliser

### Bannière de fonctionnalité (Feature Graphic)
- Dimensions : 1024 x 500 pixels
- Format : PNG ou JPEG
- Pas de transparence

---

## Classification du contenu

### Questionnaire Google Play
Répondre au questionnaire de classification :

1. **L'application contient-elle des publicités ?** Non
2. **L'application collecte-t-elle des données utilisateur ?** Non
3. **L'application est-elle destinée aux enfants ?** Non (tout public)
4. **L'application contient-elle du contenu généré par les utilisateurs ?** Dépend du site web
5. **L'application permet-elle des achats ?** Dépend du site web

### Groupe d'âge cible
Tous publics

---

## Prix et distribution

### Prix
Gratuit

### Pays de distribution
Tous les pays (ou selon préférence)

### Appareils Android
- Smartphones : Oui
- Tablettes : Oui
- Android TV : Non
- Wear OS : Non
- Chromebooks : Oui (compatible)

---

## Informations techniques

### Package Name
`dev.akiprisaye.android`

### Version actuelle
- Version Code : 1
- Version Name : 1.0

### API minimum
Android 7.0 (API 24)

### API cible
Android 14 (API 34)

### Permissions utilisées
- `INTERNET` : Pour charger le contenu web
- `ACCESS_NETWORK_STATE` : Pour vérifier la connectivité

---

## Checklist avant publication

- [ ] Signer l'APK/AAB avec une clé de signature (keystore)
- [ ] Tester l'application sur plusieurs appareils
- [ ] Vérifier que le site web s'affiche correctement
- [ ] Préparer les captures d'écran
- [ ] Créer une bannière de fonctionnalité (1024x500)
- [ ] Rédiger la description complète
- [ ] Héberger la politique de confidentialité en ligne
- [ ] Compléter le questionnaire de contenu
- [ ] Générer un AAB (Android App Bundle) pour la production :
  ```bash
  ./gradlew bundleRelease
  ```

---

## Notes importantes

### Format AAB vs APK
Google Play préfère maintenant les fichiers AAB (Android App Bundle) plutôt que les APK. Pour générer un AAB :
```bash
./gradlew bundleRelease
```

Le fichier sera généré dans : `app/build/outputs/bundle/release/app-release.aab`

### Signature de l'application
N'oubliez pas de créer et sécuriser votre keystore. **Ne jamais perdre ce fichier**, vous en aurez besoin pour toutes les futures mises à jour.

### Test interne
Utilisez d'abord la piste de test interne du Play Store pour vérifier que tout fonctionne avant de publier en production.

### Délai de vérification
La première publication peut prendre plusieurs jours pour être vérifiée par Google.

---

## Ressources utiles

- Documentation Play Store : https://developer.android.com/distribute
- Console Play Store : https://play.google.com/console
- Guide de signature : https://developer.android.com/studio/publish/app-signing
- Critères de qualité : https://developer.android.com/quality
