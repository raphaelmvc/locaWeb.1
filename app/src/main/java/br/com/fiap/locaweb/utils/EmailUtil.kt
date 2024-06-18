package br.com.fiap.locaweb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.someMenuItemId -> {
                    // Call the email function here
                    sendTestEmail()
                    true
                }
                else -> false
            }
        }
    }

    private fun sendTestEmail() {
        val to = "recipient@example.com"
        val subject = "Test Email"
        val body = "This is a test email sent from Kotlin."

        // Sending email on a separate thread to avoid blocking the main thread
        Thread {
            EmailUtil.sendEmail(to, subject, body)
        }.start()
    }
}
