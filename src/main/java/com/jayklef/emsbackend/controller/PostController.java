package com.jayklef.emsbackend.controller;

import com.jayklef.emsbackend.dto.PostDto;
import com.jayklef.emsbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public PostDto[] getAllPosts(){
        PostDto[] response = postService.getAllPosts();
        return response;
    }

    @PostMapping("/post")
    public PostDto createPost(@RequestBody PostDto postDto){
        PostDto newPost = postService.createPost(postDto);
        return newPost;
    }
}
