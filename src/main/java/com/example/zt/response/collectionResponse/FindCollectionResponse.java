package com.example.zt.response.collectionResponse;

import lombok.Data;

import javax.persistence.Column;

@Data
public class FindCollectionResponse {
    private Integer id;

    @Column(name = "b_id")
    private Integer bId;

    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "b_name")
    private String bName;

    @Column(name = "b_img")
    private String bImg;

}
