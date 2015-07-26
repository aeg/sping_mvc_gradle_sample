package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 12:51
 */
public class JdbcSpitterRepository extends SimpleJdbcDaoSupport implements SpitterRepository {
    private static final String SQL_INSERT_SPITTER = ""
            + "insert into spitter (username, password) valued (?, ?)";
    private static final String SQL_SELECT_SPITTER = "" +
            "select id, username, password from spitter";
    private static final String SQL_SELECT_SPITTER_BY_ID = SQL_SELECT_SPITTER + " where id=?";


    public Spitter getSpitterById(long id) {
        return getSimpleJdbcTemplate().queryForObject(SQL_SELECT_SPITTER_BY_ID, new ParameterizedRowMapper<Spitter>() {
            public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spitter spitter = new Spitter();
                spitter.setId(rs.getLong(1));
                spitter.setUsername(rs.getString(2));
                spitter.setPassword(rs.getString(3));
                return spitter;
            }
        }, id);
    }

    public void saveSpitter(Spitter spitter) {
        getSimpleJdbcTemplate().update(SQL_INSERT_SPITTER,
                new Object[] { spitter.getUsername(), spitter.getPassword()});
        spitter.setId(queryForIdentity());
    }

    private long queryForIdentity() {
        return getJdbcTemplate().queryForLong("call identity()");
    }

}
