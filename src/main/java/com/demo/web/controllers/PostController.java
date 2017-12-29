package com.demo.web.controllers;

import com.demo.persistence.models.Post;
import com.demo.web.service.NotificationService;
import com.demo.web.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/posts/view/{id}")
    public String postView(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notificationService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("title", "Product view");
        model.addAttribute("post", post);
        return "posts/view";
    }
}
