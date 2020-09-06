package com.example.tptiendamobile.ui.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tptiendamobile.R
import com.example.tptiendamobile.TpViewModel
import com.example.tptiendamobile.model.Product
import com.example.tptiendamobile.ui.home.ProductListener

class OffersFragment : Fragment(), ProductListener {

//    override fun onClick(producto: Producto, view: View) {
//        val intent = Intent(context, ProductDetailActivity::class.java)
//        val bundle = Bundle()
//        bundle.putParcelable("product", producto)
//        intent.putExtras(bundle)
//        startActivity(intent)
//    }

    private lateinit var tpViewModel: TpViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_offers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//
//        tpViewModel = activity?.run { ViewModelProviders.of(this).get(TpViewModel::class.java) }
//            ?: throw Exception("Invalid Activity")
//
//
//        tpViewModel.getEvents(1)?.observe(this, Observer {
//            searchEvent(it)
//        })
//    }
//
//    private fun searchEvent(events: List<Evento>?) {
//        events?.forEach {
//            if (it.estado) {
//                return render(it)
//            }
//        }
    }
//
//    private fun render(evento: Evento) {
//        evento.let {
//            val imageUri = Uri.parse(it.logo)
//            banner.setImageURI(imageUri, context)
//            rvOffers.layoutManager = GridLayoutManager(context, 2)
//            rvOffers.adapter = OffersAdapter(it, this)
//        }
//    }

    override fun onClick(product: Product, view: View) {
        TODO("Not yet implemented")
    }

}