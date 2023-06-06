package com.doma.url.service;

import com.doma.url.entity.URL;

import java.util.ArrayList;
import java.util.List;

public interface UrlService {

    ArrayList<URL> findAll();

    URL findUrlById(long urlId);

    URL findUrlByUrlShorten(String urlShorten);

    URL insertUrl(String url);

    void deleteUrlById(long urlId);

    void updateUrl(URL url);

}
