package com.sokolowska.sageszadanie;

import com.sokolowska.sageszadanie.client.NewsAPIClient;
import com.sokolowska.sageszadanie.domain.NewsDto;
import com.sokolowska.sageszadanie.io.NewsWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SagesZadanieApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SagesZadanieApplication.class, args);

        NewsAPIClient newsAPIClient = context.getBean("newsAPIClient", NewsAPIClient.class);
        NewsDto news = newsAPIClient.getNews();
        NewsWriter writer = new NewsWriter();
        writer.saveNews(news);

    }

}
