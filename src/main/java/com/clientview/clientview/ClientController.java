package com.clientview.clientview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    @Autowired DatabaseService dbs;


    @GetMapping("/review")
    public String reviewForm(Model model) {
        model.addAttribute("feedbackData", new FeedbackData());
        return "review";
    }


    /*
    @PostMapping("/review")
    public String reviewSubmit(@ModelAttribute FeedbackData feedbackData, Model model) {
        model.addAttribute("feedbackData", feedbackData);
        return "result";
    }*/

    //@RequestParam("id")
    @GetMapping("/feedback")
    public String getById(@RequestParam("id") Long id, Model model) {
        FeedbackData feedbackData = dbs.getReviewById(id);
        model.addAttribute("feedbackData", feedbackData);
        return "result";
    }

    @PostMapping("/feedback/edit")
    public String editFeedback(@ModelAttribute FeedbackData feedbackData, Model model){
        dbs.editFeedback(feedbackData);
        return "review";
    }
}
