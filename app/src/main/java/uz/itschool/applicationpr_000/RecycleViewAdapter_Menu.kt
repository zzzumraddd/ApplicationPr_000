package uz.itschool.applicationpr_000

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapter_Menu(var fields:MutableList<Menu_Items>):RecyclerView.Adapter<RecycleViewAdapter_Menu.innnerCLass_Menu>() {
    class innnerCLass_Menu(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name:Button=itemView.findViewById(R.id.button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innnerCLass_Menu {
        var innerclass_Holder=innnerCLass_Menu(LayoutInflater.from(parent.context).inflate(R.layout.recycleview_menu,parent,false))
        return innerclass_Holder
    }

    override fun onBindViewHolder(holder: innnerCLass_Menu, position: Int) {
        val field:Menu_Items=fields.get(position)
        holder.name.text=field.name
    }

    override fun getItemCount(): Int {
        return fields.size
    }

}