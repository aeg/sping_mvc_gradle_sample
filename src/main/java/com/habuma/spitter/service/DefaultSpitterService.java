package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.persistence.SpitterRepository;
import com.habuma.spitter.persistence.SpittleRepository;

import java.util.List;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 3:02
 */
public class DefaultSpitterService implements SpitterService{
    public void addSpittle(Spittle spittle) {
        spittle.save();
    }

    public List<Spittle> getLast50Spittles() {
        List<Spittle> recentSpittles = _spittleRepository.getRecentSpittle();
        return recentSpittles.subList(0, Math.min(49, recentSpittles.size()));
    }

    public void addSpitter(Spitter spitter) {
        spitter.save();
    }

    // injected
    private SpittleRepository _spittleRepository;
    public void setSpittleRepository(SpittleRepository spittleRepository) {
        _spittleRepository = spittleRepository;
    }
}
