package com.mr.hft.controller;

import com.mr.hft.entity.UserEntity;
import com.mr.hft.http.HttpResult;
import com.mr.hft.util.HttplientUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping(value="api")
public class UserController {

    @GetMapping
    public void test() {
        UserEntity entity = new UserEntity();
        entity.setGoodId("0c6e89d0-dde9-4d7b-b404-a1a6ce09af10");
        Map<String, String> params = null;

        try {
            params = BeanUtils.describe(entity);//将javebean转为map类型的
            //通过迭代器遍历map集合并将值为null的数据删除(删除map集合数据的时候不能使用forEach 也不使用Map.EntrySet)
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                if (StringUtils.isEmpty(next.getValue())){
                    iterator.remove();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        HttpResult httpResult = HttplientUtil.sendGet("http://169.254.154.36:8080/good", params, new Header[0], new Cookie[0], "UTF-8");
        //处理响应结果
        try {
            HttplientUtil.handleHttpResult(httpResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
