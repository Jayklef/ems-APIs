package com.jayklef.emsbackend.service.Impl;

import com.jayklef.emsbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getAllPosts() {
        String allPosts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
        System.out.println(allPosts);

        return allPosts;
    }
}
