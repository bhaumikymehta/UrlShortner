package com.src.application.urlshortener.repository;

import com.src.application.urlshortener.model.UrlShortenerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends JpaRepository<UrlShortenerModel, Long> {

    UrlShortenerModel findByShortURL(String shortenedURL);

}
