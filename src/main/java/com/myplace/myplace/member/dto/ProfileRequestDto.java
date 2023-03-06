package com.myplace.myplace.member.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProfileRequestDto {
    MultipartFile imgUrl;
}
