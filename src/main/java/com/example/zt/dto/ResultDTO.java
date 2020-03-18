package com.example.zt.dto;

import com.example.zt.error.CommonErrorCode;
import lombok.Data;

/**
 * Created by codedrinker on 2018/11/25.
 */
@Data
public class ResultDTO {
    private Integer status;
    private String token;
    private String message;
    private Integer userId;
    public static ResultDTO ok(String data ,Integer userId) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setStatus(200);
        resultDTO.setToken(data);
        resultDTO.setMessage("请求成功");
        resultDTO.setUserId(userId);
        return resultDTO;
    }

    public static ResultDTO fail(String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setStatus(400);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO fail(CommonErrorCode errorCode) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setStatus(errorCode.getCode());
        resultDTO.setMessage(errorCode.getMessage());
        return resultDTO;
    }
}
