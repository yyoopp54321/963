package com.example.zt.common;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author: zlp
 * Date: 2020-03-12 16:12
 * Description:张立朋，写点注释吧!!
 */
@Service
public class GetDataByUrl {
    /**
     * 根据URL试用get方法取得返回的数据
     * @param url
     *        URL地址，参数直接挂在URL后面即可
     * @return
     */
    public String getGetDateByUrl(String url){
        String filePath = null;
        String fileName = null;
        String data = null;
        //构造HttpClient的实例
        HttpClient httpClient = new HttpClient();
        //创建GET方法的实例
        GetMethod getMethod = new GetMethod(url);
        //设置头信息：如果不设置User-Agent可能会报405，导致取不到数据
        getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        //使用系统提供的默认的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        try{
            //开始执行getMethod
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed:" + getMethod.getStatusLine());
            }
            //读取内容
            byte[] responseBody = getMethod.getResponseBody();
            //处理内容
            data = new String(responseBody,"gbk");
        }catch (HttpException e){
            //发生异常，可能是协议不对或者返回的内容有问题
            System.out.println("Please check your provided http address!");
            data = "";
            e.printStackTrace();
        }catch(IOException e){
            //发生网络异常
            data = "";
            e.printStackTrace();
        }finally{
            //释放连接
            getMethod.releaseConnection();
        }
        try {
            filePath = "src/main/java/com/zt/ebook/utils/bookFile";
            fileName = "demo.txt";// 文件名
            File dir = new File(filePath);
            // 一、检查放置文件的文件夹路径是否存在，不存在则创建
            if (!dir.exists()) {
                dir.mkdirs();// mkdirs创建多级目录
                FileWriter fw = new FileWriter(filePath+"\\" + fileName,true);
                // FileWriter 如果文件名 的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
                //写入内容
                fw.write(data);
                // 关闭写文件
                fw.close();
            }
        } catch (Exception e) {
            System.out.println("代码执行异常:"+e);
        }
        String fileNameDir = filePath+"/"+fileName;
        System.out.println(fileNameDir);
        return fileNameDir;
    }
}
