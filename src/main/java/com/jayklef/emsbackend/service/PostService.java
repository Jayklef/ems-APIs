package com.jayklef.emsbackend.service;

import com.jayklef.emsbackend.dto.PostDto;

public interface PostService {

     PostDto[] getAllPosts();

     PostDto getAllPostsByUserId(Long userId);

     PostDto createPost(PostDto postDto);

     PostDto updatePost(Long id, PostDto postDto);

     void deletePost(Long id);
}
