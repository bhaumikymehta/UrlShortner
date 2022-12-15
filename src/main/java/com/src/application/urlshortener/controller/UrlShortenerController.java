package com.src.application.urlshortener.controller;

import com.src.application.urlshortener.model.Response;
import com.src.application.urlshortener.service.UrlShortenerService;
import com.src.application.urlshortener.model.UrlShortenerModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@EnableSwagger2
public class UrlShortenerController {
    @Autowired
    UrlShortenerService urlShortenerService;
    @GetMapping("/url/")
    public String getUrl(@RequestParam String shortenedUrl) {
        log.info("Request URL:{}", shortenedUrl);
        if(urlShortenerService.validateURL(shortenedUrl)) {
            return urlShortenerService.retrieveActualURL(shortenedUrl);
        }

        return "The shortened url passed :" + shortenedUrl;
    }

    @PostMapping("/shortenURL/")
    public Object createUrl(@RequestBody String url) {
        if(urlShortenerService.validateURL(url)){
            String shortenedURL=urlShortenerService.shortenURL(url);
            return new Response(url,shortenedURL);
        }
        else{
            return  urlShortenerService.buildErrorResponseObject(url);
        }

    }


    @GetMapping("/stats/")
    //todo add total count and timestamp too
    //can run a timer to clean up all at 24 hrs using Timer task
    public Object getAllURL() {

      return urlShortenerService.getAll();

    }

    @GetMapping("/downloadAll/")
    public void getCSV() throws IOException {

        List<UrlShortenerModel> allURL = (List<UrlShortenerModel>) getAllURL();

        FileWriter writer = new FileWriter("output.txt");
        for(UrlShortenerModel str: allURL) {
            writer.write(str.toString() + System.lineSeparator());
        }
        writer.close();
}

}