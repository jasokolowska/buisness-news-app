package com.sokolowska.sageszadanie.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {

    private String status;
    private int totalResults;
    private List<SingleNewsDto> articles;
}
