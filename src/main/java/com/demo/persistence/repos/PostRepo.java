package com.demo.persistence.repos;

import com.demo.persistence.models.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @Query("Select p from Post p left join fetch p.author order by p.date desc")
    List<Post> findLatest5Post(Pageable pageable);
}
