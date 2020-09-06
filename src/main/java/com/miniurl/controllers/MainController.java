/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniurl.controllers;

import com.miniurl.daos.UrlService;
import com.miniurl.models.Url;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @Autowired
    UrlService urlService;

    @RequestMapping("/")
    String homeHandler(Model model, HttpSession httpSession) {
        model.addAttribute("alertMessage", httpSession.getAttribute("alertMessage"));
        httpSession.removeAttribute("alertMessage");
        return "index";
    }

    @RequestMapping(path = "/short-url", method = RequestMethod.POST)
    String shortUrl(@RequestParam("url") String url, Model model, HttpSession httpSession) {
        String raw = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder redirectedUrl = new StringBuilder("");
        for (int i = 0; i < 4; i++) {
            Random r = new Random();
            int number = r.nextInt(raw.length()) - 1;
            redirectedUrl.append(raw.charAt(number));
        }

        Url urlObject = new Url(url, redirectedUrl.toString());
        boolean saved = this.urlService.saveUrl(urlObject);
        if (saved) {
            model.addAttribute("shorterUrl", "http://localhost:9494/MiniUrl/c/" + redirectedUrl);
        } else {
            model.addAttribute("shorterUrl", null);
        }

        return "index";
    }

    @RequestMapping("/c/{url}")
    RedirectView getUrl(@PathVariable("url") String url, HttpSession httpSession) {
        System.out.println(url);
        Url returnedUrl = this.urlService.getUrl(url);
        RedirectView redirectView = new RedirectView();

        if (returnedUrl != null) {
            httpSession.setAttribute("alertMessage", "false");
            redirectView.setUrl(returnedUrl.getUrl());
            return redirectView;
        } else {
            httpSession.setAttribute("alertMessage", "true");
            redirectView.setUrl("../");
            return redirectView;
        }
    }
}
