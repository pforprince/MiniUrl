/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniurl.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urlId;
    @Column(length = 2000)
    private String url;
    private String shortenUrl;

    @Override
    public String toString() {
        return "Url{" + "urlId=" + urlId + ", url=" + url + ", shortenUrl=" + shortenUrl + '}';
    }

    public Url() {
    }

    public Url(String url, String shortenUrl) {
        this.url = url;
        this.shortenUrl = shortenUrl;
    }

    public Url(int urlId, String url, String shortenUrl) {
        this.urlId = urlId;
        this.url = url;
        this.shortenUrl = shortenUrl;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

}
