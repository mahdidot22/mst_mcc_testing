package com.mahdid.o.taha.jerusalemguide.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.mahdid.o.taha.jerusalemguide.model.news_model
import com.mahdid.o.taha.jerusalemguide.model.recent_model
import kotlin.collections.ArrayList

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "news"
        val DATABASE_VERSION = 9
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(news_model.TABLE_CREATE)
        db.execSQL(recent_model.TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists ${news_model.TABLE_NAME}")
        db.execSQL("drop table if exists ${recent_model.TABLE_NAME}")
        onCreate(db)
    }

    fun add_news(title: String, publishedAt: String, description: String, urlToImage: String, url: String) {
        val db = writableDatabase
        val cv = ContentValues()
        cv.put("title", title)
        cv.put("date", publishedAt)
        cv.put("des", description)
        cv.put("img", urlToImage)
        cv.put("url", url)
        db.insert(news_model.TABLE_NAME, null, cv)
    }

    fun add_recent_news(title: String, urlToImage: String) {
        val db = writableDatabase
        val cv = ContentValues()
        cv.put("title", title)
        cv.put("img", urlToImage)
        db.insert(recent_model.TABLE_NAME, null, cv)
    }


    fun get_news(): ArrayList<news_model> {
        val db = readableDatabase
        val sql = "select * from ${news_model.TABLE_NAME} order by ${news_model.COL_DATE} DESC"
        val list = ArrayList<news_model>()
        val c = db.rawQuery(sql, null)
        c.moveToFirst()

        while (!c.isAfterLast) {
            list.add(
                news_model(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5)
                )
            )
            c.moveToNext()
        }
        c.close()
        return list
    }

    fun get_recent_news(): ArrayList<recent_model> {
        val db = readableDatabase
        val sql = "select * from ${recent_model.TABLE_NAME} order by ${recent_model.COL_ID}"
        val list = ArrayList<recent_model>()
        val c = db.rawQuery(sql, null)
        c.moveToFirst()

        while (!c.isAfterLast) {
            list.add(
                recent_model(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2)
                )
            )
            c.moveToNext()
        }
        c.close()
        return list
    }

    fun update_news(title: String, publishedAt: String, description: String, urlToImage: String, url: String) {
        val db = writableDatabase
        db.delete(news_model.TABLE_NAME, null, null)
        val cv = ContentValues()
        cv.put("title", title)
        cv.put("date", publishedAt)
        cv.put("des", description)
        cv.put("img", urlToImage)
        cv.put("url", url)
        db.insert(news_model.TABLE_NAME, null, cv)
    }

    fun update_news_test(title: String, publishedAt: String, description: String, urlToImage: String, url: String):Boolean {
        val db = writableDatabase
        db.delete(news_model.TABLE_NAME, null, null)
        val cv = ContentValues()
        cv.put("title", title)
        cv.put("date", publishedAt)
        cv.put("des", description)
        cv.put("img", urlToImage)
        cv.put("url", url)
        return db.insert(news_model.TABLE_NAME, null, cv) > 0
    }
}
