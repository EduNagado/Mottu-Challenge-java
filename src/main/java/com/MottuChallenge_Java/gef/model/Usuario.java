package com.MottuChallenge_Java.gef.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.oauth2.core.user.OAuth2User;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Column(unique = true)
    private String email;

    private String avatarUrl;

    // Construtor padrão necessário para JPA
    protected Usuario() {}

    // Construtor a partir do OAuth2User
    public Usuario(OAuth2User principal) {
        this.name = principal.getAttributes().get("name").toString();
        this.email = principal.getAttributes().get("email").toString();
        this.avatarUrl = principal.getAttributes().getOrDefault("avatar_url", "").toString();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}