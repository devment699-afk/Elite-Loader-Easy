# ELITE LOADER EASY - KAISE USE KARE

## 1. APP NAAM KAHAN CHANGE KARE?
- `app/src/main/java/com/elite/loader/AppConfig.kt` -> `APP_NAME = "Elite Loader"` yahan badlo
- `app/src/main/res/values/strings.xml` -> `<string name="app_name">Elite Loader</string>` yahan bhi badlo
- `build.gradle` (top) -> `appName = "Elite Loader"` yahan bhi

## 2. PACKAGE NAME KAHAN CHANGE KARE?
- `build.gradle` (top) -> `appPackage = "com.elite.loader"` yahan badlo
- `app/build.gradle` automatically lega

## 3. PANEL LINK KAHAN DALO?
- `app/src/main/java/com/elite/loader/AppConfig.kt` -> `PANEL_URL = "https://manishflash.online/api/connect.php"`

## 4. SDK KEY KAHAN DALO?
- `AppConfig.kt` -> `SDK_KEY = "BABATILUSDK"`

## 5. THEME COLOR KAHAN BADLO?
- `AppConfig.kt` -> `THEME_PRIMARY = "#00E5FF"`
- `app/src/main/res/values/colors.xml` -> `elite_neon` etc

## 6. GAME PACKAGE?
- `AppConfig.kt` -> `GAME_PACKAGE = "com.tencent.ig"`

## 7. BUILD KAISE KARE?
- Android Studio me `Elite-Loader-Easy` open karo
- `Build -> Make Project` ya `./gradlew :app:assembleDebug`
- APK milega `app/build/outputs/apk/debug/app-debug.apk`

## 8. ELITE SDK KAHAN HAI?
- `elite-sdk/` folder me pura SDK hai
- `elite-sdk/src/main/java/com/elite/` me core hai
- Change karne ki zarurat nahi, bas `AppConfig.kt` se control karo

## 9. UI KAHAN HAI?
- `app/src/main/res/layout/activity_main.xml` - yahan UI change karo
- `app/src/main/java/com/elite/loader/MainActivity.kt` - yahan logic
- `app/src/main/java/com/elite/loader/EliteApplication.kt` - auto init

## SIMPLE - 1 FILE SE SAB CONTROL: AppConfig.kt
