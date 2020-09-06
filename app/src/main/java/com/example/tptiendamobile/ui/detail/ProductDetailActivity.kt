package com.example.tptiendamobile.ui.detail

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tptiendamobile.R
import com.example.tptiendamobile.model.Product
import com.example.tptiendamobile.ui.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        ActivityOptions.makeSceneTransitionAnimation(this)


        product = intent?.extras?.get("product") as Product

        render(product)
        clickListeners()
    }

    private fun clickListeners() {
        buyButton.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java).apply {
                putExtras(Bundle().apply {
                    putParcelable("product", product)
                })
            }, ActivityOptions.makeSceneTransitionAnimation(this, view, "view").toBundle())
        }
    }

    private fun render(product: Product) {


        image.setImageURI(product.image)
        titleProduct.text = product.title
        description.text = product.description
        artist.text = product.artist.fullName
        price.text = resources.getString(R.string.price_formatter, product.price?.toInt().toString())
    }

}