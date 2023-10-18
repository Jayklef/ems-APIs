package com.jayklef.emsbackend.service.Impl;

import com.jayklef.emsbackend.dto.PostDto;
import com.jayklef.emsbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
}
