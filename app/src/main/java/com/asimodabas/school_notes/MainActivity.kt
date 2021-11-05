package com.asimodabas.school_notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notlarListe: ArrayList<Notlar>
    private lateinit var adapter: NotlarAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "My Notes"
        toolbar.subtitle = "Average : 60"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        notlarListe = ArrayList()

        val n1 = Notlar(1, "tarih", 40, 80)
        val n2 = Notlar(1, "fizik", 70, 20)
        val n3 = Notlar(1, "kimya", 20, 10)

        notlarListe.add(n1)
        notlarListe.add(n2)
        notlarListe.add(n3)

        adapter = NotlarAdapter(this, notlarListe)

        rv.adapter = adapter

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