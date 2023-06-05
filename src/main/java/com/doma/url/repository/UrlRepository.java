package com.doma.url.repository;

import com.doma.url.entity.URL;

import java.util.ArrayList;

public interface UrlRepository {

    void findAll();
    void insertUrl();
    void deleteUrlById();


}
