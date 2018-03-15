package com.example.lls.bangdan;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LLS on 2018/2/27.
 */
@Entity
public class AnimeBean {
    /**
     * id : 253
     * name : カウボーイビバップ
     * name_cn : 星际牛仔
     * eps_count : 26
     * air_date : 1998-10-23
     * rating_score : 9.1
     * images_small : http://lain.bgm.tv/pic/cover/s/c2/4c/253_t3XWb.jpg
     * rank : 1
     * collection_collect : 4805
     */
    @Id
    private String id;
    private String name;
    private String name_cn;
    private int eps_count;
    private String air_date;
    private double rating_score;
    private String images_small;
    private int rank;
    private int collection_collect;
    private String colour;
    @Generated(hash = 1377772390)
    public AnimeBean(String id, String name, String name_cn, int eps_count,
            String air_date, double rating_score, String images_small, int rank,
            int collection_collect, String colour) {
        this.id = id;
        this.name = name;
        this.name_cn = name_cn;
        this.eps_count = eps_count;
        this.air_date = air_date;
        this.rating_score = rating_score;
        this.images_small = images_small;
        this.rank = rank;
        this.collection_collect = collection_collect;
        this.colour = colour;
    }
    @Generated(hash = 1637982863)
    public AnimeBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName_cn() {
        return this.name_cn;
    }
    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }
    public int getEps_count() {
        return this.eps_count;
    }
    public void setEps_count(int eps_count) {
        this.eps_count = eps_count;
    }
    public String getAir_date() {
        return this.air_date;
    }
    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }
    public double getRating_score() {
        return this.rating_score;
    }
    public void setRating_score(double rating_score) {
        this.rating_score = rating_score;
    }
    public String getImages_small() {
        return this.images_small;
    }
    public void setImages_small(String images_small) {
        this.images_small = images_small;
    }
    public int getRank() {
        return this.rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getCollection_collect() {
        return this.collection_collect;
    }
    public void setCollection_collect(int collection_collect) {
        this.collection_collect = collection_collect;
    }
    public String getColour() {
        return this.colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    
}
//@Entity
//public class AnimeBean {
//    /**
//     * id : 265
//     * ranking : 5
//     * score : 8.9
//     * pnum : 9020
//     * name : 新世纪福音战士
//     * faxing : 1995年10月4日
//     * huashu : 26
//     */
//    @Id
//    private String id;
//    private int ranking;
//    private String score;
//    private int pnum;
//    private String name;
//    private String faxing;
//    private String huashu;
//    private String colour;
//    private String url;
//    @Generated(hash = 1295605776)
//    public AnimeBean(String id, int ranking, String score, int pnum, String name,
//            String faxing, String huashu, String colour, String url) {
//        this.id = id;
//        this.ranking = ranking;
//        this.score = score;
//        this.pnum = pnum;
//        this.name = name;
//        this.faxing = faxing;
//        this.huashu = huashu;
//        this.colour = colour;
//        this.url = url;
//    }
//    @Generated(hash = 1637982863)
//    public AnimeBean() {
//    }
//    public String getId() {
//        return this.id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public int getRanking() {
//        return this.ranking;
//    }
//    public void setRanking(int ranking) {
//        this.ranking = ranking;
//    }
//    public String getScore() {
//        return this.score;
//    }
//    public void setScore(String score) {
//        this.score = score;
//    }
//    public int getPnum() {
//        return this.pnum;
//    }
//    public void setPnum(int pnum) {
//        this.pnum = pnum;
//    }
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getFaxing() {
//        return this.faxing;
//    }
//    public void setFaxing(String faxing) {
//        this.faxing = faxing;
//    }
//    public String getHuashu() {
//        return this.huashu;
//    }
//    public void setHuashu(String huashu) {
//        this.huashu = huashu;
//    }
//    public String getColour() {
//        return this.colour;
//    }
//    public void setColour(String colour) {
//        this.colour = colour;
//    }
//    public String getUrl() {
//        return this.url;
//    }
//    public void setUrl(String url) {
//        this.url = url;
//    }
//}
