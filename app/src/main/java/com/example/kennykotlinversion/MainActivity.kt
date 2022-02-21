package com.example.kennykotlinversion

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var score = 0
    var imagearray= ArrayList<ImageView>()
    var runnable= Runnable {  }
    var handler=Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hidden()

        imagearray.add(imageView)
        imagearray.add(imageView2)
        imagearray.add(imageView3)
        imagearray.add(imageView4)
        imagearray.add(imageView5)
        imagearray.add(imageView6)
        imagearray.add(imageView7)
        imagearray.add(imageView8)
        imagearray.add(imageView9)


        object : CountDownTimer(15500, 1000) {
            override fun onTick(p0: Long) {
                timetext.text="Time "+ p0/1000
            }

            override fun onFinish() {
                timetext.text="Time:0"
                for (image in imagearray){
                    image.visibility=View.INVISIBLE
                }
            timetext.text="Time:0"
                val alert=AlertDialog.Builder(this@MainActivity)
            alert.setMessage("Game Over!")
            alert.setMessage("Restart the Game")
                alert.setPositiveButton("Yes"){dialog,which->
                    //Restat
                    val intent=intent
                    finish()
                    startActivity(intent)
                   }
                alert.setNegativeButton("No"){dialog,which->
                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()

                }
                alert.show()
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
    fun hidden(){
        runnable= object : Runnable {
            override fun run() {
                for (image in imagearray){
                    image.visibility=View.INVISIBLE
                }
                val random= Random(9)
                val randomIndex=random.nextInt(9)
                imagearray[randomIndex].visibility=View.VISIBLE
                handler.postDelayed(runnable,200)
            }

        }

      handler.post(runnable)
    }

        fun increaseScore(view: View) {
            score = score + 1
            scoreText.text = "Score: $score"
        }

}