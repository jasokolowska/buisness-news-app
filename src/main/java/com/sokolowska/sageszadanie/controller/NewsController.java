package com.sokolowska.sageszadanie.controller;

import com.sokolowska.sageszadanie.client.NewsAPIClient;
import com.sokolowska.sageszadanie.domain.NewsDto;
import com.sokolowska.sageszadanie.domain.SingleNewsDto;
import com.sokolowska.sageszadanie.io.NewsWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsAPIClient newsAPIClient;
    @Autowired
    private NewsWriter writer;

    @GetMapping("getNews")
    public void getNews() {
        NewsDto news = newsAPIClient.getNews();

        writer.saveNews(news);
        news.getArticles().forEach(newsDto -> {
            System.out.println("title: " + newsDto.getTitle()
                    + "| description: " + newsDto.getDescription()
                    + "| author: " + newsDto.getAuthor());
        });
    }
}
