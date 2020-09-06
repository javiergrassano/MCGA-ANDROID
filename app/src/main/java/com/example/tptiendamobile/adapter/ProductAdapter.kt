package com.example.tptiendamobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tptiendamobile.R
import com.example.tptiendamobile.model.Product
import com.example.tptiendamobile.ui.home.ProductListener
import com.facebook.drawee.view.SimpleDraweeView


class ProductAdapter(private val productList: List<Product>, private val listener: ProductListener) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_product_item, parent, false))
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = productList[position]

        val imageUri = product.image
        holder.apply {
            image.apply {
                setImageURI(imageUri, holder.image.context)
                scaleType = ImageView.ScaleType.FIT_XY
            }
            title.text = product.title
            price.text = holder.price.context.resources.getString(R.string.price_formatter, product.price?.toInt().toString())
            card.setOnClickListener {
                listener.onClick(productList[position], holder.image)
            }
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal val image: SimpleDraweeView = view.findViewById(R.id.image)
        internal val title: TextView = view.findViewById(R.id.title)
        internal val price: TextView = view.findViewById(R.id.price)
        internal val card: CardView = view.findViewById(R.id.card)
    }
}