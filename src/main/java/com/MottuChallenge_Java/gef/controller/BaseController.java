package com.MottuChallenge_Java.gef.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;

public abstract class BaseController {


    protected void addUserToModel(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal != null) {
            model.addAttribute("name", principal.getAttribute("name"));
            model.addAttribute("email", principal.getAttribute("email"));

            String avatar = principal.getAttribute("avatar_url"); // GitHub
            if (avatar == null) {
                avatar = principal.getAttribute("picture"); // Google
            }
            model.addAttribute("avatar", avatar);
        }
    }
}
