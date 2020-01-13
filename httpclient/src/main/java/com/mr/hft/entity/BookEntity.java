package com.mr.hft.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//import javax.persistence.*;
@Entity
@Table(name="book")
//此注解一定要加,否则使用repository内置的根据Id查询数据的方法会报错
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class BookEntity {
    @Id
    @GenericGenerator(name="id",strategy = "native")
    @GeneratedValue(generator = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="sex")
    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
