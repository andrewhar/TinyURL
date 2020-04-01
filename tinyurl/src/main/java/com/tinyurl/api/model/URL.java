package com.tinyurl.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "url")
@Table(name = "url")
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urlId = 1;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(mappedBy = "url")
    private OrgURL orgURL;

    @OneToOne(mappedBy = "url")
    private TinyURL tinyURL;

    public OrgURL getOrgURL() {
        return orgURL;
    }

    public void setOrgURL(OrgURL orgURL) {
        this.orgURL = orgURL;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
