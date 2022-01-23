package com.sokolowska.sageszadanie.client;

import com.sokolowska.sageszadanie.domain.NewsDto;
import com.sokolowska.sageszadanie.domain.SingleNewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NewsAPIClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${newsapi.endpoint}")
    private String newsApiEndpoint;
    @Value("${newsapi.key}")
    private String API_KEY;

    public NewsDto getNews() {
        URI url = UriComponentsBuilder.fromHttpUrl(newsApiEndpoint)
                .queryParam("category", "business")
                .queryParam("country", "pl")
                .queryParam("apiKey", API_KEY)
                .build().encode().toUri();
        System.out.println("********** URl: " + url);


        NewsDto newsResponse = restTemplate.getForObject(url, NewsDto.class);

        return newsResponse;
    }
}
