package com.tinyurl.api.repository;


import com.tinyurl.api.model.OrgURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface OrgURLRepository extends JpaRepository<OrgURL, Integer> {

    Optional<OrgURL> findByOrgURL(String orgURL);

//    @Transactional
//    void deleteByOrgURL(String orgURL);


}
