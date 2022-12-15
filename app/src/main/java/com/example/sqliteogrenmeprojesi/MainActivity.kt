package com.example.sqliteogrenmeprojesi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //try catch
        try {
            val veritabani=this.openOrCreateDatabase("Urunler",Context.MODE_PRIVATE,null)
            veritabani.execSQL("create table if not exists urunler(id INTEGER primary key ,isim varchar,fiyat int)")
           //veritabani.execSQL("insert into urunler (isim,fiyat) values('elbise',150)")
          // veritabani.execSQL("insert into urunler (isim,fiyat) values('tsirt',50)")
          // veritabani.execSQL("insert into urunler (isim,fiyat) values('atki',213)")
          // veritabani.execSQL("insert into urunler (isim,fiyat) values('bere',10)")

           val cursor=veritabani.rawQuery("select *from urunler",null)
           //val cursor=veritabani.rawQuery("select *from urunler where isim='bere'",null)
           //val cursor=veritabani.rawQuery("select *from urunler where id=3",null)
          // val cursor=veritabani.rawQuery("select *from urunler where isim like '%e'",null)
            val idColumIndex=cursor.getColumnIndex("id")
            val isimColumIndex=cursor.getColumnIndex("isim")
            val fiyatColumIndex=cursor.getColumnIndex("fiyat")
           // veritabani.execSQL("delete from urunler where id=5")
           // veritabani.execSQL("Update  urunler set fiyat=3000 where id=4")
            veritabani.execSQL("Update  urunler set isim='ayakkabii' where id=1")
            while (cursor.moveToNext())
            {
                println("ID : ${cursor.getInt(idColumIndex)}")
                println("İsim : ${cursor.getString(isimColumIndex)}")
                println("Fiyat : ${cursor.getInt(fiyatColumIndex)}")
            }
            cursor.close()
        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }

    }
}