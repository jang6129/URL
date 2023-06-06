package com.doma.url.service;

import com.doma.url.entity.URL;
import com.doma.url.repository.UrlRepository;
import com.doma.url.repository.UrlRepositoryImpl;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UrlServiceImpl implements UrlService {

    private UrlRepository urlRepository;

    @Autowired
    UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public ArrayList<URL> findAll() {
        return urlRepository.findAll();
    }

    @Override
    public URL findUrlById(long urlId) {
        return urlRepository.findUrlById(urlId);
    }

    @Override
    public URL findUrlByUrlShorten(String urlShorten) {
        URL url = urlRepository.findUrlByUrlShorten(urlShorten);
        URL requestedUrl = url;
        // 요청 횟수 저장
        requestedUrl.setRequestCount(requestedUrl.getRequestCount() + 1);
        urlRepository.updateUrl(requestedUrl);
        return url;
    }

    @Override
    public URL insertUrl(String url) {
        String result = "";

        while (true) {
            result = base56();
            if (isUnique(result)) break;
        }

        URL insertUrl = URL.builder()
                .urlId(idGenerator())
                .urlOriginal(url)
                .urlShorten(result)
                .requestCount(0)
                .build();

        urlRepository.insertUrl(insertUrl);

        return insertUrl;
    }

    @Override
    public void deleteUrlById(long urlId) {
        urlRepository.deleteUrlById(urlId);
    }

    @Override
    public void updateUrl(URL url) {
        urlRepository.updateUrl(url);
    }


    // method

    private boolean isUnique(String urlShorten) {
        List<URL> list = urlRepository.findAll();

        for(URL u : list) {
            if (u.getUrlShorten().equals(urlShorten)) return false;
        }

        return true;
    }

    private String base56() {
        char[] words = {'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String result = "";

        while (result.length() < 6) {
            result += words[(int) ((Math.random() * 100) % 56)];
        }

        return result;
    }

    private long idGenerator() {
        long curId = urlRepository.getIdCount();
        long nextId = curId + 1;
        urlRepository.setIdCount(nextId);

        return nextId;
    }

}
