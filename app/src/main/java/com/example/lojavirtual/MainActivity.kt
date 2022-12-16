package com.example.lojavirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojavirtual.adapter.ProductCategoryAdapter
import com.example.lojavirtual.databinding.ActivityMainBinding
import com.example.lojavirtual.model.ProductCategory


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerCategory: RecyclerView
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
        recyclerListener()


        val arrayCategory = arrayListOf<ProductCategory>(ProductCategory("1", "Camisetas"),
            ProductCategory("2", "Calças"),
            ProductCategory("3", "Meias"),
            ProductCategory("4", "Sapatos"))

        //recyclerCategory = findViewById(R.id.rv_product_category)

        val adapterCategory = ProductCategoryAdapter(arrayCategory, this)
        //recyclerCategory.adapter = adapterCategory
        //recyclerCategory.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false)

    }

    private fun insertListeners (){
        binding.ivRecentProduct.setOnClickListener{
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun recyclerListener(){
        binding.llCategory.setOnClickListener{
            val intent = Intent(this,ProductCategoryActivity::class.java)
            startActivity(intent)
        }
    }
}