package com.tinyurl.api.repository;

import com.tinyurl.api.model.TinyURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TinyURLRepository extends JpaRepository<TinyURL, Integer> {
}
