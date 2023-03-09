package com.myplace.myplace.review.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReviewRequestDto {

    private List<String> reviewKeywordList;
    private MultipartFile reviewPhotoUrl;
    private String reviewContents;

}
