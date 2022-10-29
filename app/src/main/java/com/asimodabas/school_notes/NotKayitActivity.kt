package com.asimodabas.school_notes

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_not_kayit.buttonKaydet
import kotlinx.android.synthetic.main.activity_not_kayit.editTextDers
import kotlinx.android.synthetic.main.activity_not_kayit.editTextNot1
import kotlinx.android.synthetic.main.activity_not_kayit.editTextNot2
import kotlinx.android.synthetic.main.activity_not_kayit.toolbarNotKayit

class NotKayitActivity : AppCompatActivity() {

    private lateinit var vt: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_kayit)

        vt = VeritabaniYardimcisi(this)

        toolbarNotKayit.title = "Note Save"
        setSupportActionBar(toolbarNotKayit)

        buttonKaydet.setOnClickListener {

            val dersAdi = editTextDers.text.toString().trim()
            val not1 = editTextNot1.text.toString().trim()
            val not2 = editTextNot2.text.toString().trim()

            if (TextUtils.isEmpty(dersAdi)) {
                Snackbar.make(toolbarNotKayit, "Enter lesson name", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not1)) {
                Snackbar.make(toolbarNotKayit, "Enter note 1", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not2)) {
                Snackbar.make(toolbarNotKayit, "Enter note 2", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Notlardao().notEkle(vt, dersAdi, not1.toInt(), not2.toInt())

            startActivity(Intent(this@NotKayitActivity, MainActivity::class.java))
            finish()
        }
    }
}