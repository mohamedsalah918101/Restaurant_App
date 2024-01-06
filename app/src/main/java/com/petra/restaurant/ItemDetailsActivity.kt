package com.petra.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ItemDetailsActivity : AppCompatActivity() {

    private lateinit var itemNameTextView: TextView
    private lateinit var itemPriceTextView: TextView
    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var countTextView: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        itemNameTextView = findViewById(R.id.item_name)
        itemPriceTextView = findViewById(R.id.item_price)
        plusButton = findViewById(R.id.plus_button)
        minusButton = findViewById(R.id.minus_button)
        countTextView = findViewById(R.id.count_text)

        val itemName = intent.getStringExtra("itemName")
        val itemPrice = intent.getDoubleExtra("itemPrice", 0.0)

        itemNameTextView.text = itemName
        itemPriceTextView.text = itemPrice.toString()

        plusButton.setOnClickListener {
            count++
            countTextView.text = count.toString()
        }

        minusButton.setOnClickListener {
            if (count > 0) {
                count--
                countTextView.text = count.toString()
            }
        }
    }
}