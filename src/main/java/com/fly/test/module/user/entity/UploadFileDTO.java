package com.fly.test.module.user.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 张攀钦
 * @date 2019-12-17-13:54
 * @description
 */
@Data
public class UploadFileDTO {

    private MultipartFile  file;

    private String type;
}
