package com.tinyurl.api.repository;

import com.tinyurl.api.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface URLRepository extends JpaRepository<URL, Integer> {

	//List<URL> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

}
