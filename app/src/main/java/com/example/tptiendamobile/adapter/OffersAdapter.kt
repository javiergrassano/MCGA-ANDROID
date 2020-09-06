package com.example.tptiendamobile.adapter


class OffersAdapter()  {


}

//class OffersAdapter(private val evento: Evento, private val listener: ProductListener) : RecyclerView.Adapter<OffersAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_product_item_event, parent, false))
//    }
//
//    override fun getItemCount(): Int = evento.productos_detalle!!.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//
//        val imageUri = Uri.parse(evento.productos_detalle!![position].imagen_set?.get(0)?.url)
//
//        holder.image.setImageURI(imageUri, holder.image.context)
//        holder.title.text = evento.productos_detalle[position].nombre
//        holder.price.text = evento.productos_detalle[position].precio
//
//        if (evento.envio_gratis) {
//            holder.freeShipping.visibility = View.VISIBLE
//        } else {
//            holder.freeShipping.visibility = View.GONE
//        }
//
//        holder.card.setOnClickListener {
//            listener.onClick(
//                    evento.productos_detalle[position],
//                    holder.image
//            )
//        }
//    }
//
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//        val image = view.findViewById<SimpleDraweeView>(R.id.imageOffer)
//        val title = view.findViewById<TextView>(R.id.titleOffer)
//        val price = view.findViewById<TextView>(R.id.priceOffer)
//        val freeShipping = view.findViewById<TextView>(R.id.freeShipping)
//        val card = view.card
//    }
//}