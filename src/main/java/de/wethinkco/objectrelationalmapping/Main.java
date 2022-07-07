package de.wethinkco.objectrelationalmapping;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;
import de.wethinkco.objectrelationalmapping.ormlite.Account;
import de.wethinkco.objectrelationalmapping.ormlite.World;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {
        final Connection dbConnection =
                DriverManager.getConnection("jdbc:sqlite::memory");
//        final WorldDAI dao = QueryTool.getQuery(dbConnection, WorldDAI.class);
//
//        final WorldDO a = dao.getWorld(6);
        JdbcPooledConnectionSource connectionSource
                = new JdbcPooledConnectionSource("jdbc:sqlite:test.sqlite");

        TableUtils.createTableIfNotExists(connectionSource, World.class);

        Dao<World, Integer> worldDao =
                DaoManager.createDao(connectionSource, World.class);

        World world = new World();
        world.setName("world1");
//      Screw the rules, we are  using ormlite https://www.baeldung.com/ormlite
        worldDao.create(world);
    }
}
