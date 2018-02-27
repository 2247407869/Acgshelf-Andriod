package com.example.lls.bangdan;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

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

}