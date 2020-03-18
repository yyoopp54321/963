package com.example.zt.service;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.request.collectionRequest.AddCollectionRequest;
import com.example.zt.response.collectionResponse.FindCollectionResponse;

import java.util.List;

public interface CollectionService {
    SzpJsonResult addCollection(AddCollectionRequest request);
    SzpJsonResult deleteCollection(Integer id);
    SzpJsonResult deleteCollectionList(List<Integer> ids);
    List<FindCollectionResponse> findCollectionByUserId(Integer uId);
}
