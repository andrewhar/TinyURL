package com.tinyurl.api.service.urlcreator;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.restcontrollers.dto.URLRequest;


public interface URLCreateComponent {
    public URL createURL();

    public URL saveURL(URL url);
}
