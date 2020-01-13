package com.mr.hft.service.impl;

import com.mr.hft.entity.BookEntity;
import com.mr.hft.entity.UserEntity;
import com.mr.hft.service.BookService;
import com.mr.hft.util.SystemUtil;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private SystemUtil util;

    @Override
    public List<BookEntity> list() {
        return util.findAll();
    }

    @Override
    public void save(BookEntity entity) {
        util.save(entity);
    }

    @Override
    public void del(Integer id) {
        util.deleteById(id);
    }

    @Override
    public void update(BookEntity entity) {
        util.update(entity.getName(), entity.getSex(), entity.getId());

    }

    @Override
    public List<BookEntity> list1(String name, Integer sex) {
        return util.findAll();
    }

    @Override
    public List<BookEntity> findByNameLikeOrSex(BookEntity entity) {
       Example<BookEntity> example = Example.of(entity);
        return util.findByNameLikeOrSex("%" + example.getProbe().getName() + "%", example.getProbe().getSex());
    }

    @Override
    public void findByNameLikeOrSe(BookEntity entity, PageRequest request) {
        //Example.of(entity,request);
    }

    @Override
    public void findByRequest(PageRequest request) {
        util.findAll();
    }




}
