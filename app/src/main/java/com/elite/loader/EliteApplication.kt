package com.elite.loader

import android.app.Application
import android.content.Context

class EliteApplication : Application() {
    companion object { lateinit var instance: EliteApplication; private set }
    override fun attachBaseContext(base: Context) { super.attachBaseContext(base) }
    override fun onCreate() { super.onCreate(); instance = this }
}
