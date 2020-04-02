package com.tinyurl.api.component.urlcreator;

import com.tinyurl.api.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.tinyurl.api.model.URL;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class URLCreateImpl implements URLCreateComponent {

    @Autowired
    private URLRepository urlRepository;

    @Autowired
    public URLCreateImpl(){
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

    public void setUrlRepository(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }
}
