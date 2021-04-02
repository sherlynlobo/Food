package com.sl.food

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mylayout.view.*


class MainActivity : AppCompatActivity() {
    var adapter: FoodAdapter? = null
    var foodlist = ArrayList<Food>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To disable dark theme on the entire app
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        // load food
        foodlist.add(Food("Coffee","Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. When coffee berries turn from green to bright red in color – indicating ripeness – they are picked, processed, and dried. Dried coffee seeds are roasted to varying degrees, depending on the desired flavor.", R.drawable.coffee_pot))
        foodlist.add(Food("Espersso","Espresso is a coffee-brewing method of Italian origin, in which a small amount of nearly boiling water is forced under 9–10 bars of pressure through finely-ground coffee beans. Espresso coffee can be made with a wide variety of coffee beans and roast degrees.", R.drawable.espresso))
        foodlist.add(Food("French Fires","French fries primarily contain carbohydrates (mostly in the form of starch) and protein from the potato, and fat absorbed during the deep-frying process. Salt, which contains sodium, is almost always applied as a surface seasoning.", R.drawable.french_fries))
        foodlist.add(Food("Honey","Honey is a sweet, viscous food substance made by honey bees and some related insects. Bees produce honey from the sugary secretions of plants or from secretions of other insects, by regurgitation, enzymatic activity, and water evaporation. Bees store honey in wax structures called honeycombs.",R.drawable.honey))
        foodlist.add(Food("Strawberry", "The garden strawberry is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness.",R.drawable.strawberry_ice_cream))
        foodlist.add(Food("Sugar cubes", "Sugar cubes may refer to one of the following: Sugar cube, sugar pressed together in block shape that is used to sweeten drinks.",R.drawable.sugar_cubes))
        foodlist.add(Food("Daal Fry", "Ingredients-\n" +
                "Yellow daal(toor)-250 gm\n" +
                "onion chopped-2 medium size\n" +
                "Tomato chopped-2 \n" +
                "Dry red chilli-2\n" +
                "Ginger garlic paste-1 tbsp\n" +
                "Asafoetida(hing)-2 pinch\n" +
                "Cumin seeds-1 tsp\n" +
                "Turmeric powder-2 tsp\n" +
                "Cooking oil -2 tbsp\n" +
                "salt to taste\n" +
                "Chopped coriander leaves for garnish\n" +
                "Method-\n" +
                "Add salt and turmeric powder and boil the toor daal in pressure cooker(4-5 whistle),\n" +
                "Heat oil in a pan, after it is heated, add cumin seeds,red chilli and Asafoetida (hing) and let  it splutter for few seconds.\n" +
                "Add chopped onion and fry for 3-4 mins.\n" +
                "Add ginger garlic paste and cook it for 2 mins, keep steering it to ensure it does not burn.\n" +
                "Add tomatoes and cook it for few more mins. \n" +
                "Add boiled toor daal in the pan and stir,simmer the flame.\n" +
                "Garnish with chopped coriander leaves and turn off the flame.\n" +
                "Ready to serve with rice and rotis.",R.drawable.daal))

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
            var inflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview = inflater.inflate(R.layout.mylayout,null)
            foodview.imageView.setImageResource(food.image!!)
            foodview.textView.text = food.name!!
            foodview.imageView.setOnClickListener{
                var intent = Intent(context, FoodDetailsActivity::class.java)
                intent.putExtra("name", food.name!!)
                intent.putExtra("des", food.des!!)
                intent.putExtra("image", food.image!!)

                context!!.startActivity(intent)
            }
            return foodview
        }

    }
}