package com.example.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var listoffoods = ArrayList<Food>()
    var adapter:FoodAdapter?=null
    var main_activity_main :ListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadfood()

        adapter= FoodAdapter(listoffoods,this)
        main_activity_main =findViewById(R.id.main_activity_main)

        main_activity_main!!.adapter=adapter


    }

    fun loadfood(){
        listoffoods.add(Food("coffee","this is coffee corner hot chocklet coffe",
            R.drawable.ic_launcher_foreground))

        listoffoods.add(Food("meat","this is meat corner hot steak",
            R.drawable.ic_launcher_foreground))

        listoffoods.add(Food("rice","this is rice corner hot rice",
            R.drawable.ic_launcher_background))

        listoffoods.add(Food("shawerma","this is shawerma corner shawerma not exist",
            R.drawable.ic_launcher_foreground))

        listoffoods.add(Food("macrona","this is macrona corner hot spagete with meat",
            R.drawable.ic_launcher_background))
    }

    inner class FoodAdapter:BaseAdapter{
        var listoffoodslocal = ArrayList<Food>()
        var context:Context?=null

        constructor(listoffoodslocal: ArrayList<Food>, context: Context?) : super() {
            this.listoffoodslocal = listoffoodslocal
            this.context = context
        }
        override fun getCount(): Int {
            return listoffoodslocal.size
        }

        override fun getItem(p0: Int): Any {
            return listoffoodslocal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var view:View = LayoutInflater.from(context).inflate(R.layout.card_list_view,p2,false)
            var food =listoffoodslocal.get(p0)
            //var layoutinflater= context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            /*
            */
            var image:ImageView? =view.findViewById<ImageView>(R.id.imageView)
            var name:TextView? =view.findViewById<TextView>(R.id.name_cardview_meal)
            var desc:TextView? =view.findViewById<TextView>(R.id.description_cardview_meal)

            image!!.setImageResource(food.img!!)
            name!!.setText(food.name)
            desc!!.setText(food.des)


            image.setOnClickListener {
                //deleteat(p0)

                val intent = Intent(context,ActivityDetails::class.java)
                intent.putExtra("name",food.name)
                intent.putExtra("desc",food.des)
                intent.putExtra("img",food.img!!)
                context!!.startActivity(intent)
            }

            return view
        }

    }

    fun deleteat(pos:Int){
        listoffoods.removeAt(pos)
        adapter!!.notifyDataSetChanged()
    }

    fun add(index:Int){
        listoffoods.add(index,listoffoods.get(index))
    }
}