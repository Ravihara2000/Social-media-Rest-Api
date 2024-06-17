package com.SocialMedia.social_media_backend.repository;

import com.SocialMedia.social_media_backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PostRepo extends JpaRepository<Post,Long> {
}
