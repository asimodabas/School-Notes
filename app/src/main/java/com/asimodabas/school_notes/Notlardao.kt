package com.asimodabas.school_notes

import android.content.ContentValues

class Notlardao {

    fun notSil(vt: VeritabaniYardimcisi, not_id: Int) {

        val db = vt.writableDatabase
        db.delete("notlar", "not_id", arrayOf(not_id.toString()))
        db.close()
    }

    fun notEkle(vt: VeritabaniYardimcisi, ders_adi: String, not1: Int, not2: Int) {

        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("ders_adi", ders_adi)
        values.put("not1", not1)
        values.put("not2", not2)

        db.insertOrThrow("notlar", null, values)
        db.close()
    }


    fun notGuncelle(vt: VeritabaniYardimcisi, not_id: Int, ders_adi: String, not1: Int, not2: Int) {

        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("ders_adi", ders_adi)
        values.put("not1", not1)
        values.put("not2", not2)

        db.update("notlar", values, "not_id=?", arrayOf(not_id.toString()))
        db.close()
    }

}