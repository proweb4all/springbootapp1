package ru.proweb4all.springbootapp1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.proweb4all.springbootapp1.models.Post;
import ru.proweb4all.springbootapp1.repo.PostRepository;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("title", "Блог");
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        model.addAttribute("title", "Добавление статьи");
        return "blog-add";
    }
    @PostMapping("/blog/add")
    public String blogAddPost(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model) {
        Post post = new Post(title, anons, fullText);
        postRepository.save(post);
        return "redirect:/blog";
    }
}
