package com.mahdid.o.taha.jerusalemguide.model

data class recent_model(val id: Int, val img: String, val titel: String) {

    companion object {
        val TABLE_NAME = "recent"
        val COL_ID = "id"
        val COL_IMG = "img"
        val COL_TITLE = "title"

        val TABLE_CREATE = "create table $TABLE_NAME(" +
                "$COL_ID integer primary key autoincrement," +
                "$COL_IMG text not null," +
                "$COL_TITLE text not null)"
    }
}
