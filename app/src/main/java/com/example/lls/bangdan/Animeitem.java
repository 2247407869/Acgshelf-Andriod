package com.example.lls.bangdan;

import java.util.List;

/**
 * Created by King_ on 2018/2/17.
 */

public class Animeitem {

    private List<AnimeBean> anime;

    public List<AnimeBean> getAnime() {
        return anime;
    }

    public void setAnime(List<AnimeBean> anime) {
        this.anime = anime;
    }

    public static class AnimeBean {
        /**
         * id : 265
         * ranking : 5
         * score : 8.9
         * pnum : 9020
         * name : 新世纪福音战士
         * faxing : 1995年10月4日
         * huashu : 26
         */

        private String id;
        private String ranking;
        private String score;
        private String pnum;
        private String name;
        private String faxing;
        private String huashu;
        private String colour;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRanking() {
            return ranking;
        }

        public void setRanking(String ranking) {
            this.ranking = ranking;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getPnum() {
            return pnum;
        }

        public void setPnum(String pnum) {
            this.pnum = pnum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFaxing() {
            return faxing;
        }

        public void setFaxing(String faxing) {
            this.faxing = faxing;
        }

        public String getHuashu() {
            return huashu;
        }

        public void setHuashu(String huashu) {
            this.huashu = huashu;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }
    }
}