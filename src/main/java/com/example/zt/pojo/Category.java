package com.example.zt.pojo;

import javax.persistence.*;

@Table(name = "t_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cate_name")
    private String cateName;

    @Column(name = "cate_desc")
    private String cateDesc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return cate_name
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName
     */
    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    /**
     * @return cate_desc
     */
    public String getCateDesc() {
        return cateDesc;
    }

    /**
     * @param cateDesc
     */
    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc == null ? null : cateDesc.trim();
    }
}