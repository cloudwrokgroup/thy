package com.demo.web.controllers;

import com.demo.persistence.models.Post;
import com.demo.web.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    PostService postService;

    @GetMapping(value = "/")
    public String indexRender(HttpServletRequest request, Model map) {
        map.addAttribute("title", "Thymeleaf Index");
        List<Post> last5Post = postService.findLatest5();
        map.addAttribute("last5Post", last5Post);
        List<Post> last3Post = last5Post.stream().limit(3).collect(Collectors.toList());
        map.addAttribute("last3Post", last3Post);
        Long[] arr = {1L, 2L, 3L};
        map.addAttribute("sel", arr);
        return "index";
    }
}
