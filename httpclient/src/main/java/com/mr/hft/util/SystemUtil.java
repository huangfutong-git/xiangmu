package com.mr.hft.util;

import com.mr.hft.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SystemUtil extends JpaRepository<BookEntity, Integer> , JpaSpecificationExecutor<BookEntity> {

    @Modifying(clearAutomatically = true)
    @Query(value="update book set name=?1,sex=?2 where id=?3",nativeQuery = true)
    void update(String name,Integer sex,Integer id);

    List<BookEntity> findByNameLikeOrSex(String s, Integer sex);
}
