package de.wethinkco.objectrelationalmapping.ormlite;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class WorldDaoImpl
        extends BaseDaoImpl<World, Integer>
        implements WorldDao
{
    public WorldDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, World.class);
    }

    @Override
    public World getWorld(String worldName) throws SQLException {
        return super.queryBuilder()
                .where()
                .eq("name", worldName)
                .queryForFirst();
    }
}
