package com.example.ogumap.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CategoryService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<String> getCategory1List() {
        return List.of("フード", "ショッピング", "温泉", "ハザードマップ", "スポンサー企業");
    }

    public Map<String, List<String>> getCategory2Map() {
        return Map.of(
                "フード", List.of("カフェ", "ラーメン", "お酒", "スイーツ", "お弁当"),
                "ショッピング", List.of("スーパー", "本"),
                "温泉", List.of(),
                "ハザードマップ", List.of("避難場所", "電話ボックスの場所"),
                "スポンサー企業", List.of()
        );
    }

    public String getCategory2Json() {
        try {
            return objectMapper.writeValueAsString(getCategory2Map());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}"; // エラー時は空のJSONオブジェクトを返す
        }
    }
}