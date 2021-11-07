package com.example.hw_product_recycleview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.R
import com.example.hw_product_recycleview.datsource.data
import com.example.hw_product_recycleview.modul.datamodule

class itemadapter (private val context: Context, private val dataset:List<datamodule>):RecyclerView.Adapter<itemadapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val phoneimage: ImageView = view.findViewById(R.id.phoneimage)
        val pname: TextView = view.findViewById(R.id.pname)
        val price: TextView = view.findViewById(R.id.price)
        val starimg: ImageView = view.findViewById(R.id.startimage)
        val buybutton:  Button = view.findViewById(R.id.buybutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adlayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adlayout)


    }

    @SuppressLint("StringFormatInvalid", "StringFormatMatches")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val resources = context.resources
        holder.phoneimage.setImageResource(item.image)
        holder.pname.text = resources?.getString(R.string.prodact_name, item.name)
        holder.price.text = resources?.getString(R.string.price, item.price)


        if (item.isvip){
           holder.starimg.visibility = View.VISIBLE
        }

        holder.buybutton.setOnClickListener {
            if (item.qnum > 0){
                val intent = Intent(context, MainActivityLast::class.java)
                intent.putExtra("image", item.image)
                intent.putExtra("name", item.name)
                context.startActivity(intent)

            }else{
                Toast.makeText(context, "Product is not avilable right now", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}