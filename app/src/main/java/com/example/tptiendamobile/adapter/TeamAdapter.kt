package com.example.tptiendamobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tptiendamobile.R
import com.example.tptiendamobile.model.Team
import com.facebook.drawee.view.SimpleDraweeView

class TeamAdapter(private val teamList: List<Team>) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false))
    }

    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teamList[position]

        holder.image.setImageURI(team.image)
        holder.fullName.text = team.fullName
        holder.rol.text = team.rol
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal val image = view.findViewById<SimpleDraweeView>(R.id.image)
        internal val fullName = view.findViewById<TextView>(R.id.name)
        internal val rol = view.findViewById<TextView>(R.id.rol)
    }
}