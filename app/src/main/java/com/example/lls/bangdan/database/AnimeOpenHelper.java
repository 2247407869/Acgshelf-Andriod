package com.example.lls.bangdan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LLS on 2018/2/24.
 */

public class AnimeOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "anime.db";  //数据库名
    private static final int DB_VERSION = 1;    //数据库版本号

    public AnimeOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE IF NOT EXISTS " + TableDefine.TABLE_ANIME + " ("
                + TableDefine.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TableDefine.COLUMN_ANIME_ID + " TEXT, "
                + TableDefine.COLUMN_ANIME_RANKING + " TEXT, "
                + TableDefine.COLUMN_ANIME_SCORE + " TEXT, "
                + TableDefine.COLUMN_ANIME_PNUM + " TEXT, "
                + TableDefine.COLUMN_ANIME_NAME + " TEXT, "
                + TableDefine.COLUMN_ANIME_FAXING + " TEXT, "
                + TableDefine.COLUMN_ANIME_HUASHU + " TEXT, "
                + "colour" + " TEXT "
//                + TableDefine.COLUMN_ANIME_USED + " BOOLEAN, "
//                + TableDefine.COLUMN_ANIME_WHO + " TEXT"
                + ")";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
