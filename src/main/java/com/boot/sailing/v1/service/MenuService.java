package com.boot.sailing.v1.service;

import com.boot.sailing.v1.dao.MenuDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class MenuService {

    @Autowired
    MenuDao menuDao;

    public MenuService() {
        log.info("======== MenuService, 생성자 ==========");
    }

    public int doInsert(String strCoffee, String strKind, String strPrice) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("strCoffee", strCoffee);
        parameters.put("strKind", strKind);
        parameters.put("strPrice", strPrice);
        return menuDao.doInsert(parameters);
    }

    // database 에 정보를 끌고와서 뷰에 출력
    public List<Map<String, Object>> doList() {
        List<Map<String, Object>> list = menuDao.doList();
        log.info(list);
        return list;
    }

    public int doDelete(String strNo) {
        int i = menuDao.doDelete(strNo);
        return i;
    }

    // One row 조회
    public Map<String, Object> doListOne(String strNo) {
        Map<String, Object> map = menuDao.doListOne(strNo);
        return map;
    }

    // Update
    public int doUpdate(String strNo, String strCoffee, String strKind, String strPrice) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("strNo", strNo);
        parameters.put("strCoffee", strCoffee);
        parameters.put("strKind", strKind);
        parameters.put("strPrice", strPrice);
        return menuDao.doUpdate(parameters);
    }

    public List<Map<String, Object>> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind) {
        List<Map<String, Object>> list = menuDao.doSearch(strStartDate, strEndDate, strCoffee, strKind);
        return list;
    }
}
