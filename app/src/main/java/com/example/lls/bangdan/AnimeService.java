package com.example.lls.bangdan;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface AnimeService {
    @GET("animes")
    Observable<AnimeSubject> getTop30(@Query("page") int page);
}
