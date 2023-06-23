package com.works.demo.restcontrollers;

import com.works.demo.models.News;

import com.works.demo.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/new")
public class NewsRestController {
    final NewsService newsService;

    @GetMapping("/news")
    public List<News> news() {
        return newsService.news();
    }


}
