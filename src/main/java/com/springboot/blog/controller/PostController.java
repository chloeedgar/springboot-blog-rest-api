package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // uses @Controller & @ResponseBody annotations. @ResponseBody to convert response (java obj) to JSON
@RequestMapping("/api/posts")
public class PostController {  // sometimes named PostRes (resource)

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post

    @PostMapping  // same as @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    // ResponseEntity represents a whole HTTP response - HTTP status, body, header
    // use it to configure complete HTTP response and send back to client
    // use @RequestBody to convert JSON into a Java Obj

}
