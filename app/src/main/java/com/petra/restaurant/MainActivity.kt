package com.petra.restaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create sample data (replace this with your actual data)
        val itemList = listOf(
            MenuItem("Pizza", R.drawable.pizza_image, 10.99),
            MenuItem("Burger", R.drawable.burger_image, 8.99),
            MenuItem("Drinks", R.drawable.drinks_image, 2.99)
        )

        // Initialize Adapter
        menuAdapter = MenuAdapter(itemList) { selectedItem ->
            val intent = Intent(this, ItemDetailsActivity::class.java)
            intent.putExtra("itemName", selectedItem.name)
            intent.putExtra("itemPrice", selectedItem.price)
            startActivity(intent)
        }
        recyclerView.adapter = menuAdapter
    }
}