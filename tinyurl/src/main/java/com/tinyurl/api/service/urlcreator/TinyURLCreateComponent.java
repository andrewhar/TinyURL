package com.tinyurl.api.service.urlcreator;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.model.URL;

public interface TinyURLCreateComponent {

     TinyURL createTinyURL(URL url, OrgURL orgURL);

     public TinyURL saveTinyURL(TinyURL tinyURL);

}
