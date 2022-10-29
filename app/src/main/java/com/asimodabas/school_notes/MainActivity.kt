package com.asimodabas.school_notes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main.rv
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var notlarListe: ArrayList<Notlar>
    private lateinit var adapter: NotlarAdapter
    private lateinit var vt: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "My Notes"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        vt = VeritabaniYardimcisi(this)
        notlarListe = Notlardao().tumNotlar(vt)

        adapter = NotlarAdapter(this, notlarListe)

        rv.adapter = adapter

        var toplam = 0
        for (n in notlarListe) {
            toplam = toplam + (n.not1 + n.not2) / 2
        }
        if (toplam != 0) {
            toolbar.subtitle = "Average : ${toplam / notlarListe.size} "
        }

        fab.setOnClickListener {

            startActivity(Intent(this@MainActivity, NotKayitActivity::class.java))
        }
    }

    override fun onBackPressed() {

        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}