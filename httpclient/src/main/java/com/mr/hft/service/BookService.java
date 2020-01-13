package com.mr.hft.service;

import com.mr.hft.entity.BookEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {
    List<BookEntity> list();

    void save(BookEntity entity);

    void del(Integer id);

    void update(BookEntity entity);

    List<BookEntity> list1(String name, Integer sex);

    List<BookEntity> findByNameLikeOrSex(BookEntity entity);

    void findByNameLikeOrSe(BookEntity entity, PageRequest request);

    void findByRequest(PageRequest request);
}
