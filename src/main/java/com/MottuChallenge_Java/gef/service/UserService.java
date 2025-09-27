package com.MottuChallenge_Java.gef.service;

import com.MottuChallenge_Java.gef.model.Usuario;
import com.MottuChallenge_Java.gef.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario register(OAuth2User principal) {
        return userRepository.findByEmail(principal.getAttributes().get("email").toString())
                .orElseGet(() -> userRepository.save(new Usuario(principal)));
    }
}