package com.sulistyolabs.submisionandroidpemula

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val toolbar = supportActionBar
        toolbar?.setDisplayHomeAsUpEnabled(true)
        toolbar?.title = "About"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
