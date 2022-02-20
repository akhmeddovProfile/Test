package com.example.kennykotlinversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var score = 0
    var imagearray= ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        object : CountDownTimer(1500, 1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {

            }
        }

        //Alert
        var alert=AlertDialog.Builder(this)
        alert.setTitle("Game Over")
        alert.setMessage("Restart again")
        alert.setPositiveButton("Yes"){dialog,which->
            val intent=intent
            finish()
            startActivity(intent)
        }
    }

        fun increaseScore(view: View) {
            score = score + 1
            scoreText.text = "Score: $score"
        }

}