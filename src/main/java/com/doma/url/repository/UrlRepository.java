package com.doma.url.repository;

import com.doma.url.entity.URL;

import java.util.ArrayList;

public interface UrlRepository {
    // TEST
    void setUrlList();

    void emptyUrlList();

    // API
    ArrayList<URL> findAll();

    URL findUrlById(long urlId);

    URL findUrlByUrlShorten(String urlShorten);

    void insertUrl(URL url);

    void deleteUrlById(long urlId);

    void updateUrl(URL url);

    long getIdCount();

    void setIdCount(long idCount);
}
