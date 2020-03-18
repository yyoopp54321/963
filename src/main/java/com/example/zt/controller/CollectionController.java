package com.example.zt.controller;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.pojo.User;
import com.example.zt.request.collectionRequest.AddCollectionRequest;
import com.example.zt.response.collectionResponse.FindCollectionResponse;
import com.example.zt.service.CollectionService;

import com.example.zt.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @PostMapping(value = "add/collection")
    public SzpJsonResult addCollection(@RequestBody AddCollectionRequest request){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return collectionService.addCollection(request);
    }
    @DeleteMapping(value = "delete/collection")
    public SzpJsonResult deleteCollection(@RequestParam Integer id){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return collectionService.deleteCollection(id);
    }
    @DeleteMapping(value = "delete/collection/List")
    public SzpJsonResult deleteCollectionList(@RequestParam List<Integer> ids){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return collectionService.deleteCollectionList(ids);
    }
    @GetMapping(value = "find/collection")
    public List<FindCollectionResponse> findCollectionByUserId(@RequestParam Integer uId){

        return collectionService.findCollectionByUserId(uId);
    }
}
