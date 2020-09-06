/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniurl.daos;

import com.miniurl.models.Url;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author princ
 */
@Repository
public class UrlDao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public boolean addUrl(Url url) {
        boolean saved = false;

        try {
            this.hibernateTemplate.save(url);
            saved = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    public Url getUrl(String url) {
        Url returnUrl = new Url();

        String query = "from Url where shortenUrl=:shortUrl";
        try {
            returnUrl = ((List<Url>) this.hibernateTemplate.findByNamedParam(query, "shortUrl", url)).get(0);
            
        } catch (Exception e) {
            returnUrl=null;
            e.printStackTrace();
        }
        return returnUrl;
    }
}
