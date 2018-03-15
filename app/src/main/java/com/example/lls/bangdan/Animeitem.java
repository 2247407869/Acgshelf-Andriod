package com.example.lls.bangdan;
//
//    private List<AnimeBean> anime;
//
//    public List<AnimeBean> getAnime() {
//        return anime;
//    }
//
//    public void setAnime(List<AnimeBean> anime) {
//        this.anime = anime;
//    }

import java.util.List;

/**
 * Created by King_ on 2018/2/17.
 */

public class Animeitem {

    /**
     * status : true
     * message : 成功
     * Anime : [{"id":"253","name":"カウボーイビバップ","name_cn":"星际牛仔","eps_count":"26","air_date":"1998-10-23","rating_score":"9.1","images_small":"http://lain.bgm.tv/pic/cover/s/c2/4c/253_t3XWb.jpg","rank":"1","collection_collect":"4805"},{"id":"326","name":"攻殻機動隊 S.A.C. 2nd GIG","name_cn":"攻壳机动队 S.A.C. 2nd GIG","eps_count":"26","air_date":"2004-01-01","rating_score":"9.1","images_small":"http://lain.bgm.tv/pic/cover/s/a6/66/326_M9f1M.jpg","rank":"2","collection_collect":"3277"},{"id":"324","name":"攻殻機動隊 STAND ALONE COMPLEX","name_cn":"攻壳机动队 STAND ALONE COMPLEX","eps_count":"26","air_date":"2002-10-01","rating_score":"9.0","images_small":"http://lain.bgm.tv/pic/cover/s/f2/fc/324_psuXk.jpg","rank":"3","collection_collect":"4077"},{"id":"876","name":"CLANNAD ～AFTER STORY～","name_cn":"","eps_count":"24","air_date":"2008-10-02","rating_score":"9.0","images_small":"http://lain.bgm.tv/pic/cover/s/67/d1/876_lJkik.jpg","rank":"4","collection_collect":"9586"},{"id":"265","name":"新世紀エヴァンゲリオン","name_cn":"新世纪福音战士","eps_count":"26","air_date":"1995-10-04","rating_score":"8.9","images_small":"http://lain.bgm.tv/pic/cover/s/e5/69/265_Z5Uou.jpg","rank":"5","collection_collect":"11455"},{"id":"11834","name":"銀魂'","name_cn":"银魂'","eps_count":"51","air_date":"2011-04-04","rating_score":"8.9","images_small":"http://lain.bgm.tv/pic/cover/s/e1/36/11834_fEZvv.jpg","rank":"6","collection_collect":"5608"},{"id":"237","name":"GHOST IN THE SHELL / 攻殻機動隊","name_cn":"攻壳机动队","eps_count":"0","air_date":"1995-11-18","rating_score":"8.9","images_small":"http://lain.bgm.tv/pic/cover/s/53/9f/237_78UdL.jpg","rank":"7","collection_collect":"3584"},{"id":"247","name":"銀魂","name_cn":"银魂","eps_count":"201","air_date":"2006-04-04","rating_score":"8.8","images_small":"http://lain.bgm.tv/pic/cover/s/3c/ec/247_s5jA0.jpg","rank":"8","collection_collect":"6398"},{"id":"6049","name":"新世紀エヴァンゲリオン劇場版 Air/まごころを、君に","name_cn":"新世纪福音战士剧场版 Air/真心为你","eps_count":"0","air_date":"1997-07-19","rating_score":"8.8","images_small":"http://lain.bgm.tv/pic/cover/s/fe/45/6049_3NRYn.jpg","rank":"9","collection_collect":"5773"},{"id":"1608","name":"スラムダンク","name_cn":"灌篮高手","eps_count":"101","air_date":"1993-10-16","rating_score":"8.8","images_small":"http://lain.bgm.tv/pic/cover/s/fa/af/1608_3I59P.jpg","rank":"10","collection_collect":"5951"},{"id":"110467","name":"SHIROBAKO","name_cn":"白箱","eps_count":"24","air_date":"2014-10-09","rating_score":"8.8","images_small":"http://lain.bgm.tv/pic/cover/s/73/26/110467_o4AEr.jpg","rank":"11","collection_collect":"6069"},{"id":"1728","name":"るろうに剣心 -明治剣客浪漫譚- 追憶編","name_cn":"浪客剑心 追忆篇","eps_count":"4","air_date":"1999-02-20","rating_score":"8.8","images_small":"http://lain.bgm.tv/pic/cover/s/71/37/1728_HLsCr.jpg","rank":"12","collection_collect":"2768"},{"id":"1428","name":"鋼の錬金術師 FULLMETAL ALCHEMIST","name_cn":"钢之炼金术师 FULLMETAL ALCHEMIST","eps_count":"64","air_date":"2009-04-05","rating_score":"8.7","images_small":"http://lain.bgm.tv/pic/cover/s/06/63/1428_xwkMI.jpg","rank":"13","collection_collect":"7665"},{"id":"340","name":"蟲師","name_cn":"虫师","eps_count":"26","air_date":"2005-10-22","rating_score":"8.7","images_small":"http://lain.bgm.tv/pic/cover/s/40/00/340_zgE5O.jpg","rank":"14","collection_collect":"5410"},{"id":"2907","name":"銀河英雄伝説","name_cn":"银河英雄传说","eps_count":"110","air_date":"1988-01-08","rating_score":"8.8","images_small":"http://lain.bgm.tv/pic/cover/s/c7/55/2907_3iLtK.jpg","rank":"15","collection_collect":"843"},{"id":"3302","name":"ヱヴァンゲリヲン新劇場版:破","name_cn":"福音战士新剧场版：破","eps_count":"0","air_date":"2009-06-27","rating_score":"8.7","images_small":"http://lain.bgm.tv/pic/cover/s/6f/ab/3302_7lBlW.jpg","rank":"16","collection_collect":"6976"},{"id":"25961","name":"Tom and Jerry","name_cn":"猫和老鼠","eps_count":"162","air_date":"1940-02-10","rating_score":"8.6","images_small":"http://lain.bgm.tv/pic/cover/s/fd/60/25961_WDKz6.jpg","rank":"17","collection_collect":"2972"},{"id":"238","name":"イノセンス","name_cn":"攻壳机动队2 无罪","eps_count":"1","air_date":"2004-03-06","rating_score":"8.6","images_small":"http://lain.bgm.tv/pic/cover/s/ac/1d/238_8OzU0.jpg","rank":"18","collection_collect":"2824"},{"id":"1270","name":"ARIA The ORIGINATION","name_cn":"水星领航员 第三季","eps_count":"14","air_date":"2008-01-07","rating_score":"8.7","images_small":"http://lain.bgm.tv/pic/cover/s/c8/50/1270_Lf71m.jpg","rank":"19","collection_collect":"1244"},{"id":"839","name":"PERFECT BLUE","name_cn":"蓝色恐惧","eps_count":"1","air_date":"1998-02-28","rating_score":"8.6","images_small":"http://lain.bgm.tv/pic/cover/s/8f/7d/839_ETN3n.jpg","rank":"20","collection_collect":"2695"},{"id":"770","name":"天元突破グレンラガン","name_cn":"天元突破 红莲螺岩","eps_count":"27","air_date":"2007-04-01","rating_score":"8.6","images_small":"http://lain.bgm.tv/pic/cover/s/4e/a0/770_EvrMq.jpg","rank":"21","collection_collect":"4913"},{"id":"3375","name":"涼宮ハルヒの消失","name_cn":"凉宫春日的消失","eps_count":"1","air_date":"2010-02-06","rating_score":"8.6","images_small":"http://lain.bgm.tv/pic/cover/s/9b/9b/3375_5905b.jpg","rank":"22","collection_collect":"8831"},{"id":"975","name":"ONE PIECE","name_cn":"海贼王","eps_count":"0","air_date":"1999-10-20","rating_score":"8.5","images_small":"http://lain.bgm.tv/pic/cover/s/92/97/975_YKuWd.jpg","rank":"23","collection_collect":"2126"},{"id":"10380","name":"Steins;Gate","name_cn":"命运石之门","eps_count":"25","air_date":"2011-04-06","rating_score":"8.5","images_small":"http://lain.bgm.tv/pic/cover/s/a9/79/10380_R6oVG.jpg","rank":"24","collection_collect":"11371"},{"id":"1962","name":"大闹天宫","name_cn":"大闹天宫","eps_count":"0","air_date":"0000-00-00","rating_score":"8.6","images_small":"http://lain.bgm.tv/pic/cover/s/95/f6/1962_Z1r59.jpg","rank":"25","collection_collect":"2640"},{"id":"311","name":"千と千尋の神隠し","name_cn":"千与千寻","eps_count":"1","air_date":"2001-07-20","rating_score":"8.5","images_small":"http://lain.bgm.tv/pic/cover/s/9d/fc/311_Ga38G.jpg","rank":"26","collection_collect":"8897"},{"id":"124341","name":"ARIA The AVVENIRE","name_cn":"水星领航员 The AVVENIRE","eps_count":"3","air_date":"2015-09-26","rating_score":"8.7","images_small":"http://lain.bgm.tv/pic/cover/s/10/a1/124341_5oSro.jpg","rank":"27","collection_collect":"516"},{"id":"106207","name":"蟲師 続章 第2クール","name_cn":"虫师 续章 第2期","eps_count":"10","air_date":"2014-10-18","rating_score":"8.6","images_small":"http://lain.bgm.tv/pic/cover/s/9c/c7/106207_z8288.jpg","rank":"28","collection_collect":"1711"},{"id":"848","name":"ハチミツとクローバー II","name_cn":"蜂蜜与四叶草II","eps_count":"12","air_date":"2006-06-29","rating_score":"8.5","images_small":"http://lain.bgm.tv/pic/cover/s/36/2e/848_VvbHu.jpg","rank":"29","collection_collect":"2508"},{"id":"847","name":"ハチミツとクローバー","name_cn":"蜂蜜与四叶草","eps_count":"24","air_date":"2005-04-14","rating_score":"8.5","images_small":"http://lain.bgm.tv/pic/cover/s/f4/55/847_EiZEV.jpg","rank":"30","collection_collect":"3294"},{"id":"840","name":"千年女優","name_cn":"千年女优","eps_count":"1","air_date":"2001-07-28","rating_score":"8.5","images_small":"http://lain.bgm.tv/pic/cover/s/fa/83/840_kL4XX.jpg","rank":"31","collection_collect":"3752"}]
     */

    private boolean status;
    private String message;
    private List<AnimeBean> Anime;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AnimeBean> getAnime() {
        return Anime;
    }

    public void setAnime(List<AnimeBean> Anime) {
        this.Anime = Anime;
    }

}