package com.example.lojavirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.example.lojavirtual.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toogle: ActionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout, toolbar,
                    R.string.toogle_open,R.string.toogle_close)
        drawerLayout.addDrawerListener(toogle)

        toogle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun insertListeners (){
        binding.ivRecentProduct.setOnClickListener{
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_home -> Toast.makeText(this, "Página Inicial", Toast.LENGTH_LONG).show()
            R.id.nav_category -> Toast.makeText(this, "Categoria", Toast.LENGTH_LONG).show()
            R.id.nav_orders -> Toast.makeText(this, "Meus Pedidos", Toast.LENGTH_LONG).show()
            R.id.nav_cart -> Toast.makeText(this, "Meu Carrinho", Toast.LENGTH_LONG).show()
            R.id.nav_logout -> Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
}