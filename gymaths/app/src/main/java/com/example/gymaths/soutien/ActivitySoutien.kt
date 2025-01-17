package com.example.gymaths.soutien

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.gymaths.ActivityApropos
import com.example.gymaths.R
import com.instabug.library.Instabug


class ActivitySoutien : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.soutien_activity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val url : String =  "https://theboje.github.io/Gymaths/com/example/gymaths/equations/package-summary.html";
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, ActivityApropos::class.java)
                startActivity(intent)
                true
            }

            R.id.action_bug -> {
                Instabug.show()
                true
            }
            R.id.manuel_utilisation -> {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}