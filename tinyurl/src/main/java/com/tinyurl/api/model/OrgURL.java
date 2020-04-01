package com.tinyurl.api.model;
import javax.persistence.*;
import java.awt.print.Book;

@Entity(name = "org_url")
@Table(name = "org_url")
public class OrgURL {

    @Id
    private Integer urlId;

    @Column(name="org_url")
    private String orgURL;


    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "url_id", referencedColumnName = "url_id")
    private URL url;

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getOrgURL() {
        return orgURL;
    }

    public void setOrgURL(String orgURL) {
        this.orgURL = orgURL;
    }


    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "OrgURL{" +
                "urlId=" + urlId +
                ", orgURL='" + orgURL + '\'' +
                '}';
    }
}
