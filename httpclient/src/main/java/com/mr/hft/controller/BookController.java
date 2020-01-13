package com.mr.hft.controller;

import com.mr.hft.entity.BookEntity;
import com.mr.hft.entity.UserEntity;
import com.mr.hft.service.BookService;

import com.mr.hft.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="book")
public class BookController {

    @Autowired
    private SystemUtil util;

    @Autowired
    private BookService service;

    @GetMapping
    public List<BookEntity> list(){
        return service.list();
    }

    @PostMapping
    public void save(@RequestBody BookEntity entity){
        service.save(entity);
    }

    @DeleteMapping
    public void del(Integer id){
        service.del(id);
    }

    @PutMapping
    public void update(@RequestBody BookEntity entity){
        service.update(entity);
    }

    @GetMapping(value="mh")
    public List<BookEntity> list1(@RequestBody BookEntity entity){
        PageRequest request = PageRequest.of(1, 5, Sort.by("id").descending());
        service.findByNameLikeOrSe(entity,request);
        service.findByRequest(request);
        return service.findByNameLikeOrSex(entity);
    }

    @GetMapping("listorder")
    public List<BookEntity> testFindByPage() {

        //page从0开始
        PageRequest pageParam = PageRequest.of(0, 3, Sort.by("id").ascending());
        Page<BookEntity> userListByPage = util.findAll(pageParam);
        //总数据条数
        long totalElements = userListByPage.getTotalElements();
        //总页数
        int totalPages = userListByPage.getTotalPages();
        //分页查询结果
        List<BookEntity> content = userListByPage.getContent();

        return content;
    }




}
