package com.sl.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        var bundle = intent.extras
        textView2.text = bundle!!.getString("name")
        textView3.text = bundle!!.getString("des")
        imageView2.setImageResource(bundle!!.getInt("image"))
        println("I am in foofdetailsactivity")
    }
}