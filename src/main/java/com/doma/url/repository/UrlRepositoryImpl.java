package com.doma.url.repository;

import com.doma.url.entity.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UrlRepositoryImpl implements UrlRepository {

    private ArrayList<URL> list;
    private long idCount;

    //TEST

    @Autowired
    UrlRepositoryImpl(ArrayList<URL> list) {
        this.list = list;
        this.idCount = 0;
    }

    @Override
    public void setUrlList() {
        URL url1 = URL.builder()
                .urlId(1)
                .urlOriginal("www.naver.com")
                .urlShorten("n")
                .build();
        URL url2 = URL.builder()
                .urlId(2)
                .urlOriginal("www.google.com")
                .urlShorten("g")
                .build();
        URL url3 = URL.builder()
                .urlId(3)
                .urlOriginal("www.daum.net")
                .urlShorten("d")
                .build();

        list.add(url1);
        list.add(url2);
        list.add(url3);
    }

    @Override
    public void emptyUrlList() {
        list.clear();
    }

    // API

    @Override
    public ArrayList<URL> findAll() {
        return list;
    }

    @Override
    public URL findUrlById(long urlId) {
        URL url = null;
        for (URL u : list) {
            if (u.getUrlId() == urlId) url = u;
        }

        return url;
    }

    @Override
    public URL findUrlByUrlShorten(String urlShorten) {
        URL url = null;
        for (URL u : list) {
            if (u.getUrlShorten().equals(urlShorten) ) url = u;
        }

        return url;
    }


    @Override
    public void insertUrl(URL url) {
        list.add(url);
    }

    @Override
    public void deleteUrlById(long urlId) {
        for (URL u : list) {
            if (u.getUrlId() == urlId) {
                list.remove(u);
                return;
            }
        }
    }

    @Override
    public void updateUrl(URL url) {
        for (URL u : list) {
            if (u.getUrlId() == url.getUrlId()) {
                list.remove(u);
                list.add(url);
                return;
            }
        }
    }

    @Override
    public long getIdCount() {
        return idCount;
    }

    @Override
    public void setIdCount(long idCount) {
        this.idCount = idCount;
    }

}
