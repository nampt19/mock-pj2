package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Integer> {
    Page findByIdPage(int pageId);
    Page findByUrl(String url);
}
