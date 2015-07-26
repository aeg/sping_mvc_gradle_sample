package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;

import com.habuma.spitter.domain.Spittle;
import org.apache.log4j.Logger;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class JdbcSpittleRepository extends SimpleJdbcDaoSupport
implements SpittleRepository {

    private static final Logger LOGGER = Logger.getLogger(JdbcSpittleRepository.class);

    private static final String SQL_INSERT_SPITITLE = "" +
            "insert into spittle (spitter_id, spittleText, postedTime) values(?, ?, ?)";
    private static final String SQL_SELECT_SPITTLE =
            "select id, spitter_id, spittleText, postedTime from spittle";

    private static final String SQL_SELECT_RECENT_SPITITLE =
            SQL_SELECT_SPITTLE + " where postedTime > ? order by postedTime desc";

    public void saveSpittle(Spittle spittle) {
        LOGGER.debug("JDBC Template: " + getSimpleJdbcTemplate());

        getSimpleJdbcTemplate().update(SQL_INSERT_SPITITLE, new Object[] {
                spittle.getSpitter().getId(),
                spittle.getText(),
                new Date()
        });

    }

    public List<Spittle> getRecentSpittle() {
        DateTime dt = new DateTime().minusDays(1);

        return getSimpleJdbcTemplate().query(SQL_SELECT_RECENT_SPITITLE,
                new ParameterizedRowMapper<Spittle>() {

                    public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Spittle spittle = new Spittle();

                        spittle.setId(rs.getLong(1));
                        spittle.setSpitter(_spitterRepository.getSpitterById(rs.getLong(2)));
                        spittle.setText(rs.getString(3));
                        spittle.setWhen(rs.getDate(4));

                        return spittle;
                    }
                }, dt.toDate());
    }

    private SpitterRepository _spitterRepository;
    public void setSpitterRepository(SpitterRepository spitterRepository) {
        _spitterRepository = spitterRepository;
    }
}

