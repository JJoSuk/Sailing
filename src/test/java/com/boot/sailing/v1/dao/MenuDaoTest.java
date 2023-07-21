package com.boot.sailing.v1.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuDaoTest {

    @Autowired
    MenuDao menuDao;

    @Test
    void doList() {
        List<Map<String, Object>> list = menuDao.doList();
        System.out.println(list);
    }
}