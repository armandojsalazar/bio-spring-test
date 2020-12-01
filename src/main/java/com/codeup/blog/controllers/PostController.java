package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repos.PostRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRespository postDao;

    public PostController(PostRespository postDao){
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String index(Model model){
//        ArrayList<Post> allPost = new ArrayList<Post>();
//        Post newPost1 = new Post("Codeup", "Is an awesome school!", 1);
//        Post newPost2 = new Post("UTSA", "Is okay I guess!", 2);
//        allPost.add(newPost1);
//        allPost.add(newPost2);
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String Post(@PathVariable long id, Model model){
        Post newPost = new Post("Codeup", "Is an awesome school!", id);
        model.addAttribute("post", newPost);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(){
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public String submitPost( @RequestParam(name= "title") String title,
                              @RequestParam(name= "body") String body){
        Post post = new Post(title, body);
        Post dbPost = postDao.save(post);
        return "posts/index";
    }



}
