package com.habuma.spitter.domain;

import com.habuma.spitter.persistence.SpittleRepository;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Date;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 2:21
 */
@Configurable("spittle")
@Data
public class Spittle {
    private Long id;
    private Spitter spitter;
    private String text;
    private Date when;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }


    public Spittle() {
        spitter =  new Spitter();
        spitter.setId((long)1);
    }

    public void save() {
        _spittleRepository.saveSpittle(this);
    }

    // injected
    private SpittleRepository _spittleRepository;
    public void setSpittleRepository(SpittleRepository spittleRepository) {
        _spittleRepository = spittleRepository;
    }


}
