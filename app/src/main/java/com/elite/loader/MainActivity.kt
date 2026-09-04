package com.elite.loader

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teamdark.loader.R

class MainActivity : AppCompatActivity() {
    private lateinit var tvStatus: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvAppName).text = AppConfig.APP_NAME
        findViewById<TextView>(R.id.tvSubtitle).text = "Powered by Elite SDK • " + AppConfig.GAME_PACKAGE
        findViewById<TextView>(R.id.tvPanelLink).text = AppConfig.PANEL_URL
        tvStatus = findViewById(R.id.tvStatus)
        tvStatus.text = "Ready • Key: ${AppConfig.SDK_KEY}"
        findViewById<View>(R.id.btnInstall).setOnClickListener { toast("Install") }
        findViewById<View>(R.id.btnLaunch).setOnClickListener { toast("Launch") }
        findViewById<View>(R.id.btnUninstall).setOnClickListener { toast("Uninstall") }
        findViewById<View>(R.id.btnCheckPanel).setOnClickListener { toast(AppConfig.PANEL_URL) }
        findViewById<View>(R.id.btnChangeName).setOnClickListener { toast("AppConfig.kt me badlo") }
    }
    private fun toast(m: String) = Toast.makeText(this, m, Toast.LENGTH_SHORT).show()
}
