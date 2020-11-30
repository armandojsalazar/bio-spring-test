package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model model){
        ArrayList<Post> allPost = new ArrayList<Post>();
        Post newPost1 = new Post("Codeup", "Is an awesome school!", 1, "Mando");
        Post newPost2 = new Post("UTSA", "Is okay I guess!", 2, "Sally");
        allPost.add(newPost1);
        allPost.add(newPost2);
        model.addAttribute("posts", allPost);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String Post(@PathVariable long id, Model model){
        Post newPost = new Post("Codeup", "Is an awesome school!", id, "Bob");
        model.addAttribute("post", newPost);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm(){
        return "view the form from creating a post;";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost(){
        return "create a new post";
    }

}
