/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniurl.daos;

import com.miniurl.models.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author princ
 */
@Service
public class UrlService {

    @Autowired
    UrlDao urlDao;

    public boolean saveUrl(Url url) {
        return this.urlDao.addUrl(url);
    }

    public Url getUrl(String url) {
        System.out.println("service url "+ url);
        return this.urlDao.getUrl(url);
    }

}
