package com.oreilly.sessionz.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostsDataLoader implements CommandLineRunner {

    private final JsonPlaceholderService jsonPlaceholderService;

    public PostsDataLoader(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = jsonPlaceholderService.loadPosts();
        posts.forEach(System.out::println);
    }
}
