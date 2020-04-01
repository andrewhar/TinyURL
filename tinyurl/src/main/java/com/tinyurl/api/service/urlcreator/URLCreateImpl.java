package com.tinyurl.api.service.urlcreator;

import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.tinyurl.api.model.URL;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class URLCreateImpl implements URLCreateComponent {

    private URLRepository urlRepository;

    @Autowired
    public URLCreateImpl(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public URL createURL() {
        URL url = new URL();
        LocalDateTime time = LocalDateTime.now();
        url.setCreatedDate(time);
        return url;
    }

    public URL saveURL(URL url) {
        System.out.println("[URLCreateImpl] saveURL");
        URL res = urlRepository.save(url);
        return res;
    }

}
