package com.asimodabas.school_notes

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NotlarAdapter(private val mContext: Context, private val notlarListe: List<Notlar>) :
    RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim) {

        var not_card: CardView
        var textViewDers: TextView
        var textViewnot1: TextView
        var textViewnot2: TextView

        init {

            not_card = tasarim.findViewById(R.id.not_card)
            textViewDers = tasarim.findViewById(R.id.textViewDers)
            textViewnot1 = tasarim.findViewById(R.id.textViewnot1)
            textViewnot2 = tasarim.findViewById(R.id.textViewnot2)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}