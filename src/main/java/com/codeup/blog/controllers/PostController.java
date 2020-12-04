package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repos.PostRepository;
import com.codeup.blog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
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
        Post userPost = postDao.getOne(id);
        model.addAttribute("post", userPost);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(){
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public String submitPost(
            @RequestParam(name= "title") String title,
            @RequestParam(name= "body") String body
            ){

        User user = userDao.getOne(1L);
        Post post = new Post(title, body, user);
        Post dbPost = postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model){

        model.addAttribute("postToEdit", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost (
            @RequestParam(name= "title") String title,
            @RequestParam(name= "body") String body,
            @PathVariable long id
    ){
        User user = userDao.getOne(1L);
        Post post = new Post(title, body, id, user);

        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(
            @PathVariable long id
    ){
        postDao.deleteById(id);
        return "redirect:/posts";
    }





}
