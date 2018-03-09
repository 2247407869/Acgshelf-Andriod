package com.example.lls.bangdan;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by LLS on 2018/3/4.
 */

public class BgmSub {
    /**
     * id : 12
     * url : http://bgm.tv/subject/12
     * type : 2
     * name : ちょびっツ
     * name_cn : 人形电脑天使心
     * summary : 在不久的将来,电子技术飞速发展,电脑成为人们生活中不可缺少的一部分.主角的名字是本须和秀树,是个19岁的少年,由于考试失败,来到东京上补习班,过着贫穷潦倒的生活……
     到达东京的第一天,他很幸运的在垃圾堆捡到一个人型电脑,一直以来秀树都非常渴望拥有个人电脑.当他抱着她带返公寓后,却不知如何开机,在意想不到的地方找到开关并开启后,故事就此展开
     本须和秀树捡到了人型计算机〔唧〕。虽然不晓得她到底是不是〔Chobits〕，但她的身上似乎藏有极大的秘密。看到秀树为了钱而烦恼，唧出去找打工，没想到却找到了危险的工作！为了让秀树开心，唧开始到色情小屋打工。但她在遭到过度激烈的强迫要求之后失控。让周遭计算机因此而强制停摆。
     另一方面，秀树发现好友新保与补习班的清水老师有着不可告人的关系……
     * eps : 27
     * eps_count : 27
     * air_date : 2002-04-02
     * air_weekday : 2
     * rating : {"total":2295,"count":{"10":131,"9":285,"8":886,"7":661,"6":267,"5":46,"4":6,"3":4,"2":3,"1":6},"score":7.6}
     * rank : 575
     * images : {"large":"http://lain.bgm.tv/pic/cover/l/c2/0a/12_24O6L.jpg","common":"http://lain.bgm.tv/pic/cover/c/c2/0a/12_24O6L.jpg","medium":"http://lain.bgm.tv/pic/cover/m/c2/0a/12_24O6L.jpg","small":"http://lain.bgm.tv/pic/cover/s/c2/0a/12_24O6L.jpg","grid":"http://lain.bgm.tv/pic/cover/g/c2/0a/12_24O6L.jpg"}
     * collection : {"wish":611,"collect":3019,"doing":103,"on_hold":285,"dropped":86}
     */

    private int id;
    private String url;
    private int type;
    private String name;
    private String name_cn;
    private String summary;
    private int eps;
    private int eps_count;
    private String air_date;
    private int air_weekday;
    private RatingBean rating;
    private int rank;
    private ImagesBean images;
    private CollectionBean collection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getEps() {
        return eps;
    }

    public void setEps(int eps) {
        this.eps = eps;
    }

    public int getEps_count() {
        return eps_count;
    }

    public void setEps_count(int eps_count) {
        this.eps_count = eps_count;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public int getAir_weekday() {
        return air_weekday;
    }

    public void setAir_weekday(int air_weekday) {
        this.air_weekday = air_weekday;
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public CollectionBean getCollection() {
        return collection;
    }

    public void setCollection(CollectionBean collection) {
        this.collection = collection;
    }

    public static class RatingBean {
        /**
         * total : 2295
         * count : {"10":131,"9":285,"8":886,"7":661,"6":267,"5":46,"4":6,"3":4,"2":3,"1":6}
         * score : 7.6
         */

        private int total;
        private CountBean count;
        private double score;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public CountBean getCount() {
            return count;
        }

        public void setCount(CountBean count) {
            this.count = count;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public static class CountBean {
            /**
             * 10 : 131
             * 9 : 285
             * 8 : 886
             * 7 : 661
             * 6 : 267
             * 5 : 46
             * 4 : 6
             * 3 : 4
             * 2 : 3
             * 1 : 6
             */
            @JSONField(name="10")
            private int _$10;
            @JSONField(name="9")
            private int _$9;
            @JSONField(name="8")
            private int _$8;
            @JSONField(name="7")
            private int _$7;
            @JSONField(name="6")
            private int _$6;
            @JSONField(name="5")
            private int _$5;
            @JSONField(name="4")
            private int _$4;
            @JSONField(name="3")
            private int _$3;
            @JSONField(name="2")
            private int _$2;
            @JSONField(name="1")
            private int _$1;

            public int get_$10() {
                return _$10;
            }

            public void set_$10(int _$10) {
                this._$10 = _$10;
            }

            public int get_$9() {
                return _$9;
            }

            public void set_$9(int _$9) {
                this._$9 = _$9;
            }

            public int get_$8() {
                return _$8;
            }

            public void set_$8(int _$8) {
                this._$8 = _$8;
            }

            public int get_$7() {
                return _$7;
            }

            public void set_$7(int _$7) {
                this._$7 = _$7;
            }

            public int get_$6() {
                return _$6;
            }

            public void set_$6(int _$6) {
                this._$6 = _$6;
            }

            public int get_$5() {
                return _$5;
            }

            public void set_$5(int _$5) {
                this._$5 = _$5;
            }

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$3() {
                return _$3;
            }

            public void set_$3(int _$3) {
                this._$3 = _$3;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }

            public int get_$1() {
                return _$1;
            }

            public void set_$1(int _$1) {
                this._$1 = _$1;
            }
        }
    }

    public static class ImagesBean {
        /**
         * large : http://lain.bgm.tv/pic/cover/l/c2/0a/12_24O6L.jpg
         * common : http://lain.bgm.tv/pic/cover/c/c2/0a/12_24O6L.jpg
         * medium : http://lain.bgm.tv/pic/cover/m/c2/0a/12_24O6L.jpg
         * small : http://lain.bgm.tv/pic/cover/s/c2/0a/12_24O6L.jpg
         * grid : http://lain.bgm.tv/pic/cover/g/c2/0a/12_24O6L.jpg
         */

        private String large;
        private String common;
        private String medium;
        private String small;
        private String grid;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getGrid() {
            return grid;
        }

        public void setGrid(String grid) {
            this.grid = grid;
        }
    }

    public static class CollectionBean {
        /**
         * wish : 611
         * collect : 3019
         * doing : 103
         * on_hold : 285
         * dropped : 86
         */

        private int wish;
        private int collect;
        private int doing;
        private int on_hold;
        private int dropped;

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }

        public int getCollect() {
            return collect;
        }

        public void setCollect(int collect) {
            this.collect = collect;
        }

        public int getDoing() {
            return doing;
        }

        public void setDoing(int doing) {
            this.doing = doing;
        }

        public int getOn_hold() {
            return on_hold;
        }

        public void setOn_hold(int on_hold) {
            this.on_hold = on_hold;
        }

        public int getDropped() {
            return dropped;
        }

        public void setDropped(int dropped) {
            this.dropped = dropped;
        }
    }
}
