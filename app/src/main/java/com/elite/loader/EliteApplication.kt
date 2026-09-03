package com.elite.loader

import android.app.Application
import android.content.Context
import com.elite.EliteInstaller
import com.elite.app.configuration.ClientConfiguration

/**
 * ELITE LOADER - Application
 * Yahan kuch change karne ki zarurat nahi - sab AppConfig se hota hai
 */
class EliteApplication : Application() {
    companion object { lateinit var instance: EliteApplication; private set }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // Elite core attach
        try {
            EliteInstaller.get().doAttachBaseContext(base, object : ClientConfiguration() {
                override fun getHostPackageName(): String = base.packageName
                override fun isEnableDaemonService(): Boolean = true
            })
        } catch (e: Exception) { e.printStackTrace() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        try { EliteInstaller.get().doCreate() } catch (e: Exception) { e.printStackTrace() }
        // Panel link + Key already set in AppConfig - auto fetch
        // EliteInstaller.get().installPackageAsUser etc will use AppConfig.PANEL_URL
    }
}
