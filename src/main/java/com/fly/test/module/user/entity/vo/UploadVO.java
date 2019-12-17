package com.fly.test.module.user.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张攀钦
 * @date 2019-12-17-13:56
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadVO {

    private String content;

    private String type;
}
