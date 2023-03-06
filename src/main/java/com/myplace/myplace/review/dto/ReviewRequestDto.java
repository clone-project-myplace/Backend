package com.myplace.myplace.review.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReviewRequestDto {

    private List<String> keywordList = new ArrayList<>();
    private MultipartFile reviewPhotoUrl;
    private String reviewContents;

}
