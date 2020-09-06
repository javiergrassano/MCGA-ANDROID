package com.example.tptiendamobile.ui.company

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import com.example.tptiendamobile.R
import com.example.tptiendamobile.TpViewModel


class CompanyFragment : Fragment() {

    private lateinit var tpViewModel: TpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_company, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        tpViewModel = activity?.run { ViewModelProviders.of(this).get(TpViewModel::class.java) }
//            ?: throw Exception("Invalid Activity")
//
//
//        tpViewModel.getCompany(1).observe(this, Observer {
//            render(it.company)
//        })


    }

//    private fun render(company: Empresa?) {
//
//        company?.let {
//            val imageUri = Uri.parse(it.logo)
//            val telefono = it.telefono
//            logo.setImageURI(imageUri, context)
//            description.text = it.descripcion
//
//            button.setOnClickListener {
//                if (isPermissionGranted()) {
//                    call_action(telefono)
//                }
//            }
//        }
//    }

    private fun call_action(number: String?) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$number")
        startActivity(callIntent)
    }


    private fun isPermissionGranted(): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            return if (checkSelfPermission(
                    requireContext(),
                    CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                true
            } else {
                ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(CALL_PHONE), 1)
                false
            }
        }
        return true
    }


}