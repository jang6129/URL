package com.doma.url.controller;

import com.doma.url.entity.URL;
import com.doma.url.service.UrlService;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("url")
public class UrlController {

    private UrlService urlService;

    @Autowired
    UrlController (UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<URL> urlList = urlService.findAll();
        model.addAttribute("urlList", urlList);

        return "/url/list";
    }

    @GetMapping("/submit")
    public String submit() {
        return "/url/form";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam("url") String url, Model model) {
        URL insertUrl = urlService.insertUrl(url);

        model.addAttribute("insertUrl", insertUrl);
        return "/url/result";
    }

    @GetMapping("/access")
    public String access(@RequestParam("url") String url) {
        if (url.length() != 6) return "/url/null";

        URL redirectUrl = null;
        try {
            redirectUrl = urlService.findUrlByUrlShorten(url);
        } catch (NullPointerException e) {
            return "/url/null";
        }

        return "redirect:https://" + redirectUrl.getUrlOriginal();
    }

}
