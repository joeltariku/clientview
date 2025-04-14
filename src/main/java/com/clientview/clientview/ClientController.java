package com.clientview.clientview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
    @Autowired DatabaseService dbs;

    /*
    @GetMapping("/review")
    public String reviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "review";
    }*/

    /*
    @PostMapping("/review")
    public String reviewSubmit(@ModelAttribute Review review, Model model) {
        model.addAttribute("review", review);
        return "result";
    }*/

    @GetMapping("/review/id")
    public String getById(@RequestParam("id") Long id, Model model) {
        Review review = dbs.getReviewById(id);
        model.addAttribute("review", review);
        return "result";
    }
    @GetMapping
    public void test(){
        dbs.testDB();
    }
}
