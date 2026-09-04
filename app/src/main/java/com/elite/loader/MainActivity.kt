package com.elite.loader

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elite.EliteInstaller
import com.teamdark.loader.R

/**
 * ELITE LOADER - EASY UI
 * Yahan UI ka logic hai - AppConfig se naam/color auto aayega
 * Button: Install, Launch, Uninstall, Check Panel
 */
class MainActivity : AppCompatActivity() {
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // EASY: AppConfig se naam set
        findViewById<TextView>(R.id.tvAppName).text = AppConfig.APP_NAME
        findViewById<TextView>(R.id.tvSubtitle).text = "Powered by Elite SDK • " + AppConfig.GAME_PACKAGE
        findViewById<TextView>(R.id.tvPanelLink).text = AppConfig.PANEL_URL

        tvStatus = findViewById(R.id.tvStatus)
        // Show current config
        tvStatus.text = "Ready • Key: ${AppConfig.SDK_KEY}\nTap Install to add ${AppConfig.GAME_PACKAGE}"

        findViewById<View>(R.id.btnInstall).setOnClickListener { installGame() }
        findViewById<View>(R.id.btnLaunch).setOnClickListener { launchGame() }
        findViewById<View>(R.id.btnUninstall).setOnClickListener { uninstallGame() }
        findViewById<View>(R.id.btnCheckPanel).setOnClickListener { checkPanel() }
        findViewById<View>(R.id.btnChangeName).setOnClickListener {
            Toast.makeText(this, "AppConfig.kt me APP_NAME change karo", Toast.LENGTH_LONG).show()
        }
    }

    private fun installGame() {
        val pkg = AppConfig.GAME_PACKAGE
        val installed = EliteInstaller.get().isInstalled(pkg, 0)
        if (installed) {
            tvStatus.text = "✓ Already installed: $pkg"
            toast("Already installed")
        } else {
            tvStatus.text = "Installing $pkg ... (pick APK in file picker)"
            toast("Pick APK to install")
        }
    }

    private fun launchGame() {
        val pkg = AppConfig.GAME_PACKAGE
        if (!EliteInstaller.get().isInstalled(pkg, 0)) {
            tvStatus.text = "✗ Not installed: $pkg"
            toast("Install first")
            return
        }
        val ok = EliteInstaller.get().launchApk(pkg, 0)
        tvStatus.text = if (ok) "▶️ Launched $pkg" else "✗ Launch failed"
        toast(if (ok) "Launched" else "Failed")
    }

    private fun uninstallGame() {
        val pkg = AppConfig.GAME_PACKAGE
        EliteInstaller.get().uninstallPackageAsUser(pkg, 0)
        tvStatus.text = "🗑️ Uninstalled $pkg"
        toast("Uninstalled")
    }

    private fun checkPanel() {
        tvStatus.text = "Checking ${AppConfig.PANEL_URL} ..."
        toast("Panel: ${AppConfig.PANEL_URL}")
    }

    private fun toast(m: String) = Toast.makeText(this, m, Toast.LENGTH_SHORT).show()
}
