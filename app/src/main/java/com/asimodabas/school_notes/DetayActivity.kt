package com.asimodabas.school_notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_not_kayit.*

class DetayActivity : AppCompatActivity() {

    private lateinit var not: Notlar
    private lateinit var vt: VeritabaniYardimcisi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        toolbarNotDetay.title = "Note Detail"
        setSupportActionBar(toolbarNotDetay)
        vt= VeritabaniYardimcisi(this)

        not = intent.getSerializableExtra("nesne") as Notlar

        editTextDerss.setText(not.ders_adi)
        editTextNot11.setText((not.not1).toString())
        editTextNot22.setText((not.not2).toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_sil -> {
                Snackbar.make(
                    toolbarNotDetay,
                    "Are you want to delete this ?",
                    Snackbar.LENGTH_SHORT
                )
                    .setAction("YES") {

                        Notlardao().notSil(vt,not.not_id)

                        startActivity(Intent(this@DetayActivity, MainActivity::class.java))
                        finish()
                    }.show()

                return true
            }

            R.id.action_duzenle -> {

                val dersAdi=editTextDerss.text.toString().trim()
                val not1=editTextNot11.text.toString().trim()
                val not2=editTextNot22.text.toString().trim()

                if (TextUtils.isEmpty(dersAdi)){
                    Snackbar.make(toolbarNotDetay,"Enter lesson name",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if (TextUtils.isEmpty(not1)){
                    Snackbar.make(toolbarNotDetay,"Enter note 1",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if (TextUtils.isEmpty(not2)){
                    Snackbar.make(toolbarNotDetay,"Enter note 2",Snackbar.LENGTH_SHORT).show()
                    return false
                }

                Notlardao().notGuncelle(vt,not.not_id,dersAdi,not1.toInt(),not2.toInt())


                startActivity(Intent(this@DetayActivity, MainActivity::class.java))
                finish()

                return true
            }
            else ->
                return false

        }
    }

}