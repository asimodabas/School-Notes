package com.asimodabas.school_notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_not_kayit.*

class NotKayitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_kayit)

        toolbarNotKayit.title = "Note Save"
        setSupportActionBar(toolbarNotKayit)

        buttonKaydet.setOnClickListener {

            startActivity(Intent(this@NotKayitActivity, MainActivity::class.java))
            finish()

        }
    }
}