package com.jayklef.emsbackend.service;

import com.jayklef.emsbackend.dto.PostDto;

public interface PostService {

     public PostDto[] getAllPosts();

     PostDto createPost(PostDto postDto);

     PostDto updatePost(Long id, PostDto postDto);
}
