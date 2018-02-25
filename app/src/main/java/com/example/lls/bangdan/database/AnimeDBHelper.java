package com.example.lls.bangdan.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lls.bangdan.Animeitem;
import com.example.lls.bangdan.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LLS on 2018/2/24.
 */

public class AnimeDBHelper {

    private static final String TAG = "AnimeDBHelper";

    private static AnimeDBHelper dbHelper;
    private AnimeOpenHelper sqlHelper;
    private SQLiteDatabase db;

    private AnimeDBHelper() {
        sqlHelper = new AnimeOpenHelper(App.getContext());
    }

    /** 单例 */
    public static AnimeDBHelper getInstance() {
        if(dbHelper == null) {
            synchronized (AnimeDBHelper.class) {
                if(dbHelper == null) {
                    dbHelper = new AnimeDBHelper();
                }
            }
        }
        return dbHelper;
    }

    /** 插入一个动漫 */
    public void insertAnime(Animeitem.AnimeBean anime) {
        db = getWritableDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.COLUMN_ANIME_ID,anime.getId());
        contentValues.put(TableDefine.COLUMN_ANIME_RANKING,anime.getRanking());
        contentValues.put(TableDefine.COLUMN_ANIME_SCORE,anime.getScore());
        contentValues.put(TableDefine.COLUMN_ANIME_PNUM,anime.getPnum());
        contentValues.put(TableDefine.COLUMN_ANIME_NAME,anime.getName());
        contentValues.put(TableDefine.COLUMN_ANIME_FAXING,anime.getFaxing());
        contentValues.put(TableDefine.COLUMN_ANIME_HUASHU,anime.getHuashu());
//        contentValues.put(TableDefine.COLUMN_ANIME_USED,anime.getUsed());
//        contentValues.put(TableDefine.COLUMN_ANIME_WHO,anime.getWho());
        db.insert(TableDefine.TABLE_ANIME,null,contentValues);
        closeIO(null);
    }
//    public static final String COLUMN_ANIME_RANKING = "ranking";
//    public static final String COLUMN_ANIME_SCORE = "score";
//    public static final String COLUMN_ANIME_PNUM = "pnum";
//    public static final String COLUMN_ANIME_NAME = "name";
//    public static final String COLUMN_ANIME_FAXING = "faxing";
//    public static final String COLUMN_ANIME_HUASHU = "huashu";
    /** 插入一堆动漫(使用事务) */
    public void insertAnimes(List<Animeitem.AnimeBean> animes) {
        db = getWritableDB();
        db.beginTransaction();
        try{
            for (Animeitem.AnimeBean anime: animes) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(TableDefine.COLUMN_ANIME_ID,anime.getId());
                contentValues.put(TableDefine.COLUMN_ANIME_RANKING,anime.getRanking());
                contentValues.put(TableDefine.COLUMN_ANIME_SCORE,anime.getScore());
                contentValues.put(TableDefine.COLUMN_ANIME_PNUM,anime.getPnum());
                contentValues.put(TableDefine.COLUMN_ANIME_NAME,anime.getName());
                contentValues.put(TableDefine.COLUMN_ANIME_FAXING,anime.getFaxing());
                contentValues.put(TableDefine.COLUMN_ANIME_HUASHU,anime.getHuashu());
                db.insert(TableDefine.TABLE_ANIME,null,contentValues);
            }
            db.setTransactionSuccessful();
        } finally {
            if(db != null && db.isOpen()) {
                db.endTransaction();
                closeIO(null);
            }
        }
    }

    /** 删除动漫(根据_id) */
    public void deleteAnime(String _id) {
        db = getWritableDB();
        db.delete(TableDefine.TABLE_ANIME,"_id =?",new String[]{_id});
        closeIO(null);
    }

    /** 删除所有动漫 */
    public void deleteAllAnimes() {
        db = getWritableDB();
        db.delete(TableDefine.TABLE_ANIME,null,null);
        closeIO(null);
    }

    /** 更新动漫信息(根据_id) */
    public void updateAnime(String _id,Animeitem.AnimeBean anime) {
        db = getWritableDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.COLUMN_ANIME_ID,anime.getId());
        contentValues.put(TableDefine.COLUMN_ANIME_RANKING,anime.getRanking());
        contentValues.put(TableDefine.COLUMN_ANIME_SCORE,anime.getScore());
        contentValues.put(TableDefine.COLUMN_ANIME_PNUM,anime.getPnum());
        contentValues.put(TableDefine.COLUMN_ANIME_NAME,anime.getName());
        contentValues.put(TableDefine.COLUMN_ANIME_FAXING,anime.getFaxing());
        contentValues.put(TableDefine.COLUMN_ANIME_HUASHU,anime.getHuashu());
        db.update(TableDefine.TABLE_ANIME,contentValues,"_id =?",new String[]{_id});
        closeIO(null);
    }

    /** 更新动漫colour(根据_id) */
    public void updateColour(String _id,String color) {
        db = getWritableDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("colour",color);
        db.update(TableDefine.TABLE_ANIME,contentValues,"_id =?",new String[]{_id});
        closeIO(null);
    }

    /** 查询当前表中有多少个动漫 */
    public int getAnimesCount() {
        db = getReadableDB();
        Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM " + TableDefine.TABLE_ANIME,null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        Log.v(TAG,"count：" + count);
        closeIO(cursor);
        return count;
    }

    /** 分页查询动漫，参数为当前页和每一个的数量，页数从0开始算 */
    public List<Animeitem.AnimeBean> getAnimesLimit(int curPage, int limit) {
        db =  getReadableDB();
        List<Animeitem.AnimeBean> animes = new ArrayList<>();
        String startPos = String.valueOf(curPage * limit);  //数据开始位置
        if(db != null) {
            Cursor cursor = db.query(TableDefine.TABLE_ANIME,new String[] {
                    TableDefine.COLUMN_ANIME_ID, TableDefine.COLUMN_ANIME_RANKING,
                    TableDefine.COLUMN_ANIME_SCORE, TableDefine.COLUMN_ANIME_PNUM,
                    TableDefine.COLUMN_ANIME_NAME, TableDefine.COLUMN_ANIME_FAXING,
                    TableDefine.COLUMN_ANIME_HUASHU, "colour",
            },null,null,null,null,TableDefine.COLUMN_ID,startPos + "," + limit);
            while (cursor.moveToNext()) {
                Animeitem.AnimeBean anime = new Animeitem.AnimeBean();
                anime.setId(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_ID)));
                anime.setRanking(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_RANKING)));
                anime.setScore(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_SCORE)));
                anime.setPnum(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_PNUM)));
                anime.setName(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_NAME)));
                anime.setFaxing(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_FAXING)));
                anime.setHuashu(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_HUASHU)));
                anime.setColour(cursor.getString(cursor.getColumnIndex("colour")));
                animes.add(anime);
            }
            closeIO(cursor);
        }
        return animes;
    }

    /** 查询所有动漫 */
    public List<Animeitem.AnimeBean> getAllAnimes() {
        db = getReadableDB();
        List<Animeitem.AnimeBean> animes = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TableDefine.TABLE_ANIME,null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            Animeitem.AnimeBean anime = new Animeitem.AnimeBean();
            anime.setId(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_ID)));
            anime.setRanking(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_RANKING)));
            anime.setScore(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_SCORE)));
            anime.setPnum(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_PNUM)));
            anime.setName(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_NAME)));
            anime.setFaxing(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_FAXING)));
            anime.setHuashu(cursor.getString(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_HUASHU)));
//            anime.setUsed(cursor.getInt(cursor.getColumnIndex(TableDefine.COLUMN_ANIME_USED)));
            animes.add(anime);
        }
        closeIO(cursor);
        return animes;
    }

    /** 获得可写数据库的方法 */
    private SQLiteDatabase getWritableDB() {
        return sqlHelper.getWritableDatabase();
    }

    /** 获得可读数据库的方法 */
    private SQLiteDatabase getReadableDB() {
        return sqlHelper.getReadableDatabase();
    }

    /** 关闭cursor和数据库的方法 */
    private void closeIO(Cursor cursor) {
        if(cursor != null) {
            cursor.close();
        }
        if(db != null) {
            db.close();
        }
    }

}