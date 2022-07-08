package de.wethinkco.objectrelationalmapping.ormlite;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public interface WorldDao extends Dao<World, Integer> {
    World getWorld(String worldName) throws SQLException;
}
