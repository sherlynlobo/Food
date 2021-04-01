package com.sl.food

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mylayout.view.*


class MainActivity : AppCompatActivity() {
    var adapter: FoodAdapter? = null
    var foodlist = ArrayList<Food>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load foods
        foodlist.add(Food("Coffee","INSERT COFFEE DATA", R.drawable.coffee_pot))
        foodlist.add(Food("Espersso","INSERT ESPRESSO DATA", R.drawable.espresso))
        foodlist.add(Food("French Fires","INSERT FRENCH FRIES DATA", R.drawable.french_fries))
        foodlist.add(Food("Honey","INSERT HONEY DATA",R.drawable.honey))
        foodlist.add(Food("Strawberry", "INSERT STRAWBERRY DATA",R.drawable.strawberry_ice_cream))
        foodlist.add(Food("Sugar cubes", "INSERT SUGAR CUBES DATA",R.drawable.sugar_cubes))
        adapter = FoodAdapter(this, foodlist)

        gridView.adapter = adapter
    }


    class FoodAdapter : BaseAdapter {
        var foodlist = ArrayList<Food>()
         var context : Context? = null

        constructor(context: Context?, foodist: ArrayList<Food>) : super() {
            this.foodlist = foodist
            this.context = context
        }


        override fun getCount(): Int {
            return foodlist.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(index: Int, convertView: View?, parent: ViewGroup?): View {
            var food: Food = this.foodlist[index]
            var inflater: LayoutInflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview = inflater.inflate(R.layout.mylayout,null)
            foodview.imageView.setImageResource(food.image!!)
            foodview.textView.text = food.name!!
            return foodview
        }

    }
}