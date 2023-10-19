package com.jayklef.emsbackend.service.Impl;

import com.jayklef.emsbackend.dto.PostDto;
import com.jayklef.emsbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService {

    @Value("${external.api.url}")
    private String ApiBaseUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PostDto[] getAllPosts() {
        PostDto[] allPosts = restTemplate.getForObject(ApiBaseUrl+"/posts", PostDto[].class);
        System.out.println(allPosts);

        return allPosts;
    }

    @Override
    public PostDto createPost(PostDto postDto){

        PostDto post = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PostDto> httpEntity = new HttpEntity<>(postDto, headers);

        ResponseEntity<PostDto> newPost = restTemplate.postForEntity(ApiBaseUrl+"/posts", httpEntity,
                PostDto.class);

        if (newPost.getStatusCode() == HttpStatus.CREATED){
            post = newPost.getBody();
        }
    return post;
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        PostDto post = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PostDto> httpEntity = new HttpEntity<>(postDto, headers);

        ResponseEntity<PostDto> updatedPost = restTemplate.exchange(ApiBaseUrl+"/posts/{id}",
                HttpMethod.PUT, httpEntity, PostDto.class);
        if (updatedPost.getStatusCode() == HttpStatus.OK){
            post = updatedPost.getBody();
        }
        return post;
    }
}
