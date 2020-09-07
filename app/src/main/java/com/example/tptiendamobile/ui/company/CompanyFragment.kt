package com.example.tptiendamobile.ui.company

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tptiendamobile.R
import com.example.tptiendamobile.adapter.TeamAdapter
import com.example.tptiendamobile.mockTeam
import kotlinx.android.synthetic.main.fragment_company.*


class CompanyFragment : Fragment(R.layout.fragment_company) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        render()
    }

    private fun render() {
        mockTeam()
        rvTeam.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvTeam.adapter = TeamAdapter(mockTeam())
    }

    private fun callAction(number: String?) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$number")
        startActivity(callIntent)
    }

    private fun isPermissionGranted(): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            return if (checkSelfPermission(requireContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                true
            } else {
                ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(CALL_PHONE), 1)
                false
            }
        }
        return true
    }
}