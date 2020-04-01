package com.tinyurl.api.model;

import javax.persistence.*;

@Entity
@Table(name = "tiny_url")
public class TinyURL {
    @Id
    private int urlId;
    @Column(name = "tiny_url")
    private String tinyURL;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "url_id", referencedColumnName = "url_id")
    private URL url;

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getTinyURL() {
        return tinyURL;
    }

    public void setTinyURL(String tinyURL) {
        this.tinyURL = tinyURL;
    }


}
