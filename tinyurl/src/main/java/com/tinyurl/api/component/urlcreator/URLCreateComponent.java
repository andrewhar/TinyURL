package com.tinyurl.api.component.urlcreator;
import com.tinyurl.api.model.URL;


public interface URLCreateComponent {
    public URL createURL();

    public URL saveURL(URL url);
}
