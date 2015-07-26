package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

import java.util.List;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 3:00
 */
public interface SpitterService {
    List<Spittle> getLast50Spittles();

    void addSpittle(Spittle spittle);
    void addSpitter(Spitter spitter);

}
