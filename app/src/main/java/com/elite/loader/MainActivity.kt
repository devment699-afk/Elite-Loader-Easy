package com.elite.loader

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elite.EliteInstaller
import com.elite.loader.databinding.ActivityMainBinding

/**
 * ELITE LOADER - EASY UI
 * Yahan UI ka logic hai - AppConfig se naam/color auto aayega
 * Button: Install, Launch, Uninstall, Check Panel
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // EASY: AppConfig se naam set
        binding.tvAppName.text = AppConfig.APP_NAME
        binding.tvSubtitle.text = "Powered by Elite SDK • " + AppConfig.GAME_PACKAGE
        binding.tvPanelLink.text = AppConfig.PANEL_URL

        // Show current config
        binding.tvStatus.text = "Ready • Key: ${AppConfig.SDK_KEY}\nTap Install to add ${AppConfig.GAME_PACKAGE}"

        binding.btnInstall.setOnClickListener { installGame() }
        binding.btnLaunch.setOnClickListener { launchGame() }
        binding.btnUninstall.setOnClickListener { uninstallGame() }
        binding.btnCheckPanel.setOnClickListener { checkPanel() }
        binding.btnChangeName.setOnClickListener {
            Toast.makeText(this, "AppConfig.kt me APP_NAME change karo", Toast.LENGTH_LONG).show()
        }
    }

    private fun installGame() {
        val pkg = AppConfig.GAME_PACKAGE
        // EliteInstaller uses virtual install - select APK via file picker in real app
        // For demo: check if installed
        val installed = EliteInstaller.get().isInstalled(pkg, 0)
        if (installed) {
            binding.tvStatus.text = "✓ Already installed: $pkg"
            toast("Already installed")
        } else {
            binding.tvStatus.text = "Installing $pkg ... (pick APK in file picker)"
            // Real: EliteInstaller.get().installPackageAsUser(apkFile, 0)
            toast("Pick APK to install")
        }
    }

    private fun launchGame() {
        val pkg = AppConfig.GAME_PACKAGE
        if (!EliteInstaller.get().isInstalled(pkg, 0)) {
            binding.tvStatus.text = "✗ Not installed: $pkg"
            toast("Install first")
            return
        }
        val ok = EliteInstaller.get().launchApk(pkg, 0)
        binding.tvStatus.text = if (ok) "▶️ Launched $pkg" else "✗ Launch failed"
        toast(if (ok) "Launched" else "Failed")
    }

    private fun uninstallGame() {
        val pkg = AppConfig.GAME_PACKAGE
        EliteInstaller.get().uninstallPackageAsUser(pkg, 0)
        binding.tvStatus.text = "🗑️ Uninstalled $pkg"
        toast("Uninstalled")
    }

    private fun checkPanel() {
        // Check online panel
        binding.tvStatus.text = "Checking ${AppConfig.PANEL_URL} ..."
        // In real: OkHttp fetch AppConfig.PANEL_URL
        toast("Panel: ${AppConfig.PANEL_URL}")
    }

    private fun toast(m: String) = Toast.makeText(this, m, Toast.LENGTH_SHORT).show()
}
