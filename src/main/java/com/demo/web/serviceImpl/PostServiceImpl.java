package com.demo.web.serviceImpl;

import com.demo.persistence.models.Post;
import com.demo.persistence.models.Users;
import com.demo.persistence.repos.PostRepo;
import com.demo.web.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    /*private List<Post> posts = new ArrayList<Post>() {{
        add(new Post(1L, "First Post", "<p>Line #1.</p><p>Line #2</p>", null));
        add(new Post(2L, "Second Post",
                "Second post content:<ul><li>line 1</li><li>line 2</li></p>",
                new Users(10L, "pesho10", "Peter Ivanov")));
        add(new Post(3L, "Post #3", "<p>The post number 3 nice</p>",
                new Users(10L, "merry", null)));
        add(new Post(4L, "Forth Post", "<p>Not interesting post</p>", null));
        add(new Post(5L, "Post Number 5", "<p>Just posting</p>", null));
        add(new Post(6L, "Sixth Post", "<p>Another interesting post</p>", null));
    }};*/

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public List<Post> findLatest5() {
       /* return this.posts.stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .limit(5)
                .collect(Collectors.toList());*/
        return postRepo.findLatest5Post(new PageRequest(0, 5));
    }

    @Override
    public Post findById(Long id) {
        if (id <= 0) {
            throw new RuntimeException("Post not found");
        }
       /* return this.posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);*/
        return postRepo.findOne(id);
    }

    @Override
    public Post create(Post post) {
        if (post.getTitle() == null) {
            throw new RuntimeException("Post not found");
        }
        /*post.setId(this.posts.stream().mapToLong(p -> p.getId()).max().getAsLong() + 1);
        this.posts.add(post);
        return post;*/
        return postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        if (post.getTitle() == null) {
            throw new RuntimeException("Post not found" + post.getId());
        }
        /*for (int i = 0; i < posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), post.getId())) {
                this.posts.set(i, post);
                return post;
            }
        }
        throw new RuntimeException("Post not found" + post.getId());*/
        return postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
       /* for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), id)) {
                this.posts.remove(i);
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found: " + id);*/
        if (id <= 0) {
            throw new RuntimeException("Post not found: " + id);
        }
        postRepo.delete(id);
    }
}
