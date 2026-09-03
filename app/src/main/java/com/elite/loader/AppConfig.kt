package com.elite.loader

/**
 * ELITE LOADER - EASY CONFIG
 * Yahan se sab change karo - naam, package, api, color
 * No need to search other files
 */
object AppConfig {
    // 1. APP NAAM - yahan change karo (File Manager me bhi dikhega)
    const val APP_NAME = "Elite Loader"

    // 2. THEME COLOR - yahan color code change karo
    const val THEME_PRIMARY = "#00E5FF" // Neon Cyan
    const val THEME_SECONDARY = "#7B61FF" // Purple
    const val THEME_BG = "#060A14" // Dark Bg

    // 3. API / PANEL LINK - yahan apna panel link dalo
    const val PANEL_URL = "https://manishflash.online/api/connect.php"
    const val API_URL = "https://manishflash.online/api/"

    // 4. SDK KEY - yahan apna key dalo
    const val SDK_KEY = "BABATILUSDK"

    // 5. GAME PACKAGE - yahan game pkg dalo
    const val GAME_PACKAGE = "com.tencent.ig" // BGMI

    // 6. LOADER SO NAME - yahan .so naam
    const val LOADER_SO = "libElite.so"

    // 7. EASY - Version
    const val VERSION_NAME = "1.0"
    const val VERSION_CODE = 1
}
