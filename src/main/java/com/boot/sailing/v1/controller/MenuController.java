package com.boot.sailing.v1.controller;

import com.boot.sailing.v1.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/v1")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/menu")
    public String doMenu(Model model) {

        // Data 만들기, list, Map
        List<Map<String, Object>> list = menuService.doList();

        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", "== MenuController ==");

        return "/v1/menu/menu";
    }

    @GetMapping("/menu_ins")
    public String doInsert() {
        return "/v1/menu/menu_ins";
    }

    @PostMapping("/menu_ins")
    public String doInsertPost(@RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice) {
        menuService.doInsert(strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") String strNo) {
        int i = menuService.doDelete(strNo);
        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_up")
    public String doUpdate(Model model,
                           @RequestParam("no") String strNo) {
        Map<String, Object> map = menuService.doListOne(strNo);
        model.addAttribute("map", map);
        return "/v1/menu/menu_up";
    }

    @PostMapping("/menu_up")
    public String doUpdatePost(@RequestParam("no") String strNo,
                               @RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice) {
        menuService.doUpdate(strNo, strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }

    // 조회하기
    @PostMapping("/menu_search")
    public String doSearch (@RequestParam("start_date") String strStartDate,
                            @RequestParam("end_date") String strEndDate,
                            @RequestParam(value = "coffee", defaultValue = "ALL") String strCoffee,
                            @RequestParam("kind") String strKind, Model model) {
        System.out.println("strCoffee = " + strCoffee);
        List<Map<String, Object>> list = menuService.doSearch(strStartDate, strEndDate, strCoffee, strKind);
        model.addAttribute("list", list);

        return "/v1/menu/menu";
    }
}
