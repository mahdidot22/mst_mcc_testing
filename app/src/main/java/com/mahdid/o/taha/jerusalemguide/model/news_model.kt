package com.mahdid.o.taha.jerusalemguide.model

data class news_model(val title: String, val date: String, val des: String, val img: String, val url: String) {
    constructor(id: Int, title: String, date: String, des: String, img: String, url: String) : this(
        title,
        date,
        des,
        img,
        url
    )
    companion object {
        val COL_ID = "id"
        val COL_TITLE = "title"
        val COL_DATE = "date"
        val COL_DES = "des"
        val COL_IMG = "img"
        val COL_URL = "url"

        val TABLE_NAME = "news"
        val TABLE_CREATE = "CREATE TABLE $TABLE_NAME(" +
                "$COL_ID INTEGER PRIMARY KEY autoincrement," +
                "$COL_TITLE text not null," +
                "$COL_DATE text not null," +
                "$COL_DES text not null," +
                "$COL_IMG text not null," +
                "$COL_URL text not null)"
    }
}
