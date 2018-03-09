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
     * id : 265
     * ranking : 5
     * score : 8.9
     * pnum : 9020
     * name : 新世纪福音战士
     * faxing : 1995年10月4日
     * huashu : 26
     */
    @Id
    private String id;
    private int ranking;
    private String score;
    private int pnum;
    private String name;
    private String faxing;
    private String huashu;
    private String colour;
    private String url;
    @Generated(hash = 1295605776)
    public AnimeBean(String id, int ranking, String score, int pnum, String name,
            String faxing, String huashu, String colour, String url) {
        this.id = id;
        this.ranking = ranking;
        this.score = score;
        this.pnum = pnum;
        this.name = name;
        this.faxing = faxing;
        this.huashu = huashu;
        this.colour = colour;
        this.url = url;
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
    public int getRanking() {
        return this.ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public String getScore() {
        return this.score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public int getPnum() {
        return this.pnum;
    }
    public void setPnum(int pnum) {
        this.pnum = pnum;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFaxing() {
        return this.faxing;
    }
    public void setFaxing(String faxing) {
        this.faxing = faxing;
    }
    public String getHuashu() {
        return this.huashu;
    }
    public void setHuashu(String huashu) {
        this.huashu = huashu;
    }
    public String getColour() {
        return this.colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
