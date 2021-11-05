package com.asimodabas.school_notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_main.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        toolbarNotDetay.title = "Note Detail"
        setSupportActionBar(toolbarNotDetay)

        val not = intent.getSerializableExtra("nesne") as Notlar
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
            R.id.action_sil -> { Snackbar.make(toolbarNotDetay,"Are you want to delete this ?", Snackbar.LENGTH_SHORT)
                    .setAction("YES"){

                        startActivity(Intent(this@DetayActivity, MainActivity::class.java))
                        finish()
                    }.show()

                return true
            }

            R.id.action_duzenle -> {

                startActivity(Intent(this@DetayActivity, MainActivity::class.java))
                finish()

                return true
            }
            else ->
                return false

        }
    }

}