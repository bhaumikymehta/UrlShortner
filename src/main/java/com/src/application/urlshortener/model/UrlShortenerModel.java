package com.src.application.urlshortener.model;


import javax.persistence.*;

@Entity
@Table(name = "urlShortener")
public class UrlShortenerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="short_url")
    private String shortURL;

    @Column(name="original_url")
    private String originalURL;

    public UrlShortenerModel(String small,String big){
        shortURL=small;
        originalURL=big;
    }

   public UrlShortenerModel(){

    }

    public String getShortURL() {
        return shortURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    @Override
    public String toString() {
        return "UrlShortenerModel{" +
                "id=" + id +
                ", shortURL='" + shortURL + '\'' +
                ", originalURL='" + originalURL + '\'' +
                '}';
    }
}
