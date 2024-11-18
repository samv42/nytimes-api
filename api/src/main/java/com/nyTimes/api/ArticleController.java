package com.nyTimes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleList", articleService.getMostPopular());
        return "index";
    }

    @GetMapping("/search")
    public String getSearchPage(Model model) {
        String query = "";
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/search-results")
    public String getSearchResults(@RequestParam("query") String query, Model model) {
        List<Doc> results = articleService.getSearchResults(query);
        model.addAttribute("results", results);
        return "search-results";
    }
}
