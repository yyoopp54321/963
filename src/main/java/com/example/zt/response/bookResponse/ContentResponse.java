package com.example.zt.response.bookResponse;

import lombok.Data;

/**
 * Author: zlp
 * Date: 2020-03-08 14:32
 * Description:张立朋，写点注释吧!!
 */
@Data
public class ContentResponse {

    private long id;

    private String name;
    //txt所带章节
    private String chapter;
    private String content;
    //新生成章节
    private long number;

    public ContentResponse() {
    }
}
