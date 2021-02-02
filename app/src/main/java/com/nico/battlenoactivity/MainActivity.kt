package com.nico.battlenoactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.nico.battlenoactivity.storage.AppPreferences

class MainActivity : AppCompatActivity() {

    var tvHighScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        val btnExit = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById(R.id.tv_high_score)

        btnNewGame.setOnClickListener(this::btnCreateNewGameClick)
        btnResetScore.setOnClickListener(this::btnResetScoreClick)
        btnExit.setOnClickListener(this::btnExitGameClick)
    }


    private fun btnCreateNewGameClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
    @SuppressLint("SetTextI18n")
    private fun btnResetScoreClick(view: View) {
        val preferences = AppPreferences(this)
//        preferences.clearHighScore()

        val snackbar = Snackbar.make(view, "Score successful reset!", Snackbar.LENGTH_SHORT)
        snackbar.setTextColor(0XFF81C784.toInt())
        snackbar.setBackgroundTint(0XFF555555.toInt())
        snackbar.show()

        tvHighScore?.text = "High score: ${preferences.getHighScore()}"
    }
    private fun btnExitGameClick(view: View) {
        System.exit(0)
    }
}