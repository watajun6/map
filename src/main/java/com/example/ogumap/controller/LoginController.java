package com.example.ogumap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login/company")
    public String companyLogin() {
        return "login_company";
    }

    @GetMapping("/login/shop")
    public String shopLogin() {
        return "login_shop";
    }

    @GetMapping("/company/home")
    public String companyHome() {
        return "company_home";
    }

    @GetMapping("/shop/home")
    public String shopHome() {
        return "shop_home";
    }
}