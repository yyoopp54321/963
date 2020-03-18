package com.example.zt.service.impl;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.dao.CollectionDao;
import com.example.zt.pojo.Collection;
import com.example.zt.request.collectionRequest.AddCollectionRequest;
import com.example.zt.response.collectionResponse.FindCollectionResponse;
import com.example.zt.service.CollectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionDao collectionDao;
    @Override
    public SzpJsonResult addCollection(AddCollectionRequest request) {
        Collection collection = new Collection();
        collection.setbId(request.getBId());
        collection.setbImg(request.getBImg());
        collection.setbName(request.getBName());
        collection.setuId(request.getUId());
        Integer integer = collectionDao.addCollection(collection);
        if (integer==1){
            return SzpJsonResult.ok();
        }
        return SzpJsonResult.errorException("添加失败");
    }

    @Override
    public SzpJsonResult deleteCollection(Integer id) {
        Integer integer = collectionDao.deleteCollection(id);
        if (integer==1){
            return SzpJsonResult.ok();
        }
        return SzpJsonResult.errorException("删除失败");

    }

    @Override
    public SzpJsonResult deleteCollectionList(List<Integer> ids) {
        return SzpJsonResult.ok(collectionDao.deleteCollectionList(ids));
    }

    @Override
    public List<FindCollectionResponse> findCollectionByUserId(Integer uId) {
        List<Collection> list = collectionDao.findCollectionByUserId(uId);
        return showBookAll(list);
    }
    private List<FindCollectionResponse> showBookAll(List<Collection> List) {
        List<FindCollectionResponse> list = new ArrayList<>();
        for (Collection collection : List) {
            FindCollectionResponse findCollectionResponse = new FindCollectionResponse();
            BeanUtils.copyProperties(collection, findCollectionResponse);
            list.add(findCollectionResponse);
        }
        return list;
    }
}
