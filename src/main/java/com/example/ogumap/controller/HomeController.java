package com.example.ogumap.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ogumap.service.CategoryService;
import com.example.ogumap.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	private final CategoryService categoryService;
    private final PostService postService;

    public HomeController(CategoryService categoryService, PostService postService) {
        this.categoryService = categoryService;
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model) {
    	// カテゴリ1リストを設定
        List<String> category1List = List.of("フード", "ショッピング", "温泉", "ハザードマップ", "スポンサー企業");
        model.addAttribute("category1List", category1List);

        // カテゴリ2のマッピングデータをJSON形式で渡す
        Map<String, List<String>> category2Map = Map.of(
            "フード", List.of("カフェ", "ラーメン", "スイーツ"),
            "ショッピング", List.of("スーパー", "薬局"),
            "温泉", List.of(),
            "ハザードマップ", List.of("避難場所", "電話ボックスの場所"),
            "スポンサー企業", List.of()
        );

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String category2Json = objectMapper.writeValueAsString(category2Map);
            model.addAttribute("category2Json", category2Json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "home";
    }
}