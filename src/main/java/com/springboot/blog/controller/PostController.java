package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // get all posts api
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // get post by id api
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // update post api
    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    // delete post rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }

}
