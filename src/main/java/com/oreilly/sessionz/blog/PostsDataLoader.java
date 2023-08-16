package com.oreilly.sessionz.blog;

import io.micrometer.observation.annotation.Observed;
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
    @Observed(name = "posts.loadPosts", contextualName = "load-posts", lowCardinalityKeyValues = {"userType", "userType2"})
    public void run(String... args) throws Exception {
        var loadPosts = false;
        if(loadPosts) {
            List<Post> posts = jsonPlaceholderService.loadPosts();
            posts.forEach(System.out::println);
        }
    }
}
