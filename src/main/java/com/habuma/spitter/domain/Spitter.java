package com.habuma.spitter.domain;

import com.habuma.spitter.persistence.SpitterRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 2:33
 */
@Configurable("spitter")
@Data
public class Spitter {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SpitterRepository getSpitterRepository() {
        return spitterRepository;
    }


    public void save() {
        spitterRepository.saveSpitter(this);
    }

    // injected
    private SpitterRepository spitterRepository;
    public void setSpitterRepository(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

}
