package com.doma.url.repository;


import com.doma.url.entity.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UrlRepositoryTest {

    @Autowired
    UrlRepository urlRepository;

    @BeforeEach
    public void setUrlList() {
        urlRepository.setUrlList();
    }

    @Test
    public void findAllTest() {
        // given
        long listSize = 3;
        // when
        ArrayList<URL> list = urlRepository.findAll();
        // then
        assertEquals(listSize, list.size());
    }

    @Test
    public void findUrlByIdTest() {
        // given
        long urlId = 1;
        String urlShorten = "n";
        // when
        URL url = urlRepository.findUrlById(urlId);
        // then
        assertEquals(urlShorten, url.getUrlShorten());
    }

    @Test
    public void insertUrlTest() {
        // given
        URL url = URL.builder()
                .urlId(4)
                .urlOriginal("www.daum.net")
                .urlShorten("d")
                .build();
        // when
        urlRepository.insertUrl(url);
        // then
        assertEquals("d", urlRepository.findUrlById(url.getUrlId()).getUrlShorten());
    }

    @Test
    public void deleteUrlByIdTest() {
        // given
        long urlId = 1;
        // when
        urlRepository.deleteUrlById(1);
        // then
        assertEquals(2, urlRepository.findAll().size());
    }

    @Test
    public void updateUrlTest() {
        // given
        URL url = URL.builder()
                .urlId(2)
                .urlOriginal("www.github.com")
                .urlShorten("g")
                .build();
        // when
        urlRepository.updateUrl(url);
        // then
        assertEquals("www.github.com", urlRepository.findUrlById(2).getUrlOriginal());

    }

    @AfterEach
    public void emptyUrlList() {
        urlRepository.emptyUrlList();
    }

}
