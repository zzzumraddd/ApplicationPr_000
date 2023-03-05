package uz.itschool.applicationpr_000

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CartActivity(context: Activity, val arrayList: ArrayList<Products>) : ArrayAdapter<Products>(context,R.layout.cartproducts_item,arrayList) {
    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater:LayoutInflater=LayoutInflater.from(context)
        var view:View = inflater.inflate(R.layout.cartproducts_item,null)
        var imageView: ImageView =view.findViewById(R.id.img_cart_pr)
        var name_product: TextView =view.findViewById(R.id.name_cart_pr)
        var price_product: TextView =view.findViewById(R.id.total_price)
        var count: TextView =view.findViewById(R.id.count_id)
        imageView.setImageResource(arrayList[position].img)
        name_product.text=arrayList[position].name
        price_product.text= arrayList[position].price
        count.text="1"
        return view
    }
}