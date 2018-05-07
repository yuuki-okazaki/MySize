package com.ok.yuuki.mysize

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply {
            neck.setText(getString("NECK", ""))
            sleeve.setText(getString("SLEEVE", ""))
            waist.setText(getString("WAIST", ""))
            inseam.setText(getString("INSEAM", ""))
        }

        save.setOnClickListener { onSaveTapped() }

        heightButton.setOnClickListener { startActivity<HeightActivity>() }
    }

    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("NECK", neck.text.toString())
                .putString("SLEEVE", sleeve.text.toString())
                .putString("WAIST", waist.text.toString())
                .putString("INSEAM", inseam.text.toString())
                .apply()
    }
}
