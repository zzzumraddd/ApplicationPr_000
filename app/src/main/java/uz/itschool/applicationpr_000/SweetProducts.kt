package uz.itschool.applicationpr_000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_sweets.*
import uz.itschool.applicationpr_000.databinding.ActivityDrinkProductsBinding
import uz.itschool.applicationpr_000.databinding.ActivityMainBinding
import uz.itschool.applicationpr_000.databinding.ActivitySweetsBinding

class SweetProducts : AppCompatActivity() {
    private lateinit var binding:ActivitySweetsBinding
    private lateinit var products_ArrayList:ArrayList<Products>
    private lateinit var menu_obj:MutableList<Menu_Items>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySweetsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val imageId_list= intArrayOf(
            R.drawable.s1,
            R.drawable.s10,
            R.drawable.s11,
            R.drawable.s13,
            R.drawable.s14,
            R.drawable.s15,
            R.drawable.s17,
            R.drawable.s18,
            R.drawable.s19,
            R.drawable.s2,//10
            R.drawable.s20,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6,//15
            R.drawable.s7,
            R.drawable.s8,
            R.drawable.s9
        )

        val name_list= arrayOf(
            "Sweet",
            "Choco",
            "Choco",
            "Sweet",
            "Choco",
            "Sweet",
            "Cake",
            "Sweet",
            "Cake",
            "Choco",//10
            "Cake",
            "Choco",
            "Choco in box"

        )

        val price_list= arrayOf(
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",//10
            "$1",
            "$1",
            "$1"
        )
        val calorie_list= arrayOf(
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
        )
        val time_list= arrayOf(
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
        )
        val info_list= arrayOf(
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie."
        )

        menu_obj= mutableListOf<Menu_Items>()
        menu_obj.add(Menu_Items("Menu"))
        menu_obj.add(Menu_Items("Drink"))
        menu_obj.add(Menu_Items("Sweet"))
        menu_obj.add(Menu_Items("Meal"))


        val layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val adapter_menu=RecycleViewAdapter_Menu(menu_obj)
        binding.recyclerview.layoutManager=layoutManager
        binding.recyclerview.adapter=adapter_menu
        products_ArrayList=ArrayList()

        for(i in name_list.indices){
            val product_obj=Products(name_list[i],info_list[i],price_list[i],imageId_list[i],calorie_list[i],time_list[i])
            products_ArrayList.add(product_obj)
        }

        binding.listviewID.isClickable=true
        binding.listviewID.adapter=ClassAdapter_1(this,products_ArrayList)

        binding.listviewID.setOnItemClickListener { parent, view, position, id ->

            val name_p=name_list[position]
            val info_p=info_list[position]
            val price_p=price_list[position]
            val img_p=imageId_list[position]
            val calorie_p=calorie_list[position]
            val time_p=time_list[position]

            val intent=Intent(this, ProductActivity::class.java)
            intent.putExtra("name_p",name_p)
            intent.putExtra("info_p",info_p)
            intent.putExtra("price_p",price_p)
            intent.putExtra("img_p",img_p)
            intent.putExtra("calorie_p",calorie_p)
            intent.putExtra("time_p",time_p)
            startActivity(intent)
        }


        binding.search.addTextChangedListener {
            var filter= mutableListOf<Products>()
            if( it !=null){
                for(p in products_ArrayList){
                    if(p.name.toLowerCase().contains(it.toString().toLowerCase())){
                        filter.add(p)
                    }
                }
                var productAdapter=ClassAdapter_1(this, filter as ArrayList<Products>)
                binding.listviewID.adapter=productAdapter
            }
        }

        cartButton.setOnClickListener {
            var i=Intent(this, CartActivity::class.java)
            startActivity(i)
        }
    }
}