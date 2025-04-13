package com.clientview.clientview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @GetMapping("/review")
    public String reviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "review";
    }

    @PostMapping("/review")
    public String reviewSubmit(@ModelAttribute Review review, Model model) {
        model.addAttribute("review", review);
        return "result";
    }
}
