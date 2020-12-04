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
    public String showCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post postToSave){

        User user = userDao.getOne(1L);
        postToSave.setOwner(user);
        postDao.save(postToSave);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model){

        model.addAttribute("postToEdit", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost (
//            @RequestParam(name= "title") String title,
//            @RequestParam(name= "body") String body,
            @PathVariable long id,
            @ModelAttribute Post postToEdit
    ){
        User user = userDao.getOne(1L);
        postToEdit.setOwner(user);

        postDao.save(postToEdit);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(
            @PathVariable long id
    ){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    //Rick Rolled
    @GetMapping("/rick-roll")
    public String rickRoll() {
        // redirecting to an absolute url
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
    @GetMapping("/redirect-me")
    public String redirect() {
        // a relative (to the base domain) redirect, usually you will use this
        // version
        // Will redirect the users to `/about`
        return "redirect:/posts";
    }




}
