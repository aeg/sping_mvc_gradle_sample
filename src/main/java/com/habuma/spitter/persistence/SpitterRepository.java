package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 2:37
 */
public interface SpitterRepository {
    void saveSpitter(Spitter spitter);
    Spitter getSpitterById(long id);
}
