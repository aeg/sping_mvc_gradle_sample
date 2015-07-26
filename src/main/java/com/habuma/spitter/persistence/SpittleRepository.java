package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spittle;

import java.util.List;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 3:05
 */
public interface SpittleRepository {
    List<Spittle> getRecentSpittle();
    void saveSpittle(Spittle spittle);
}
