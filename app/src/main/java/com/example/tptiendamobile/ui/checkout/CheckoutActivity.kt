package com.example.tptiendamobile.ui.checkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.tptiendamobile.R
import com.example.tptiendamobile.TpViewModel
import com.example.tptiendamobile.model.Product
import com.example.tptiendamobile.networking.Api
import com.example.tptiendamobile.networking.Repository
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity() {

    private lateinit var product: Product

    private lateinit var tpViewModel: TpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        tpViewModel = getViewModel()

        product = intent?.extras?.get("product") as Product

        render(product)


    }

    private fun render(product: Product) {


        imageCheckout.setImageURI(product.image, this)
        titulo.text = product.title
        textView4.text = resources.getString(R.string.price_formatter, product.price?.toInt().toString())
//        productCode.text = "Articulo " + producto.codigo_producto
    }

    private fun validate(): Boolean {
        return when {
            edName.text.isBlank() -> {
                edName.setHintTextColor(ContextCompat.getColor(this, R.color.red))
                false
            }
            edMail.text.isBlank() -> {
                edMail.setHintTextColor(ContextCompat.getColor(this, R.color.red))
                false
            }
            edAddress.text.isBlank() -> {
                edAddress.setHintTextColor(ContextCompat.getColor(this, R.color.red))
                false
            }
            else -> true
        }
    }


    private fun getViewModel(): TpViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = Repository(Api.create())
                @Suppress("UNCHECKED_CAST")
                return TpViewModel(repository) as T
            }
        })[TpViewModel::class.java]
    }
}