package de.wethinkco.objectrelationalmapping;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.table.TableUtils;
import de.wethinkco.objectrelationalmapping.ormlite.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        final Connection dbConnection =
//                DriverManager.getConnection("jdbc:sqlite::memory");
//        final WorldDAI dao = QueryTool.getQuery(dbConnection, WorldDAI.class);
//
//        final WorldDO a = dao.getWorld(6);

        //      Screw the rules, we are  using ormlite https://www.baeldung.com/ormlite

        Logger.setGlobalLogLevel(Level.ERROR);

        JdbcPooledConnectionSource connectionSource
                = new JdbcPooledConnectionSource("jdbc:sqlite:test.sqlite");

        TableUtils.createTableIfNotExists(connectionSource, World.class);
        TableUtils.createTableIfNotExists(connectionSource, WorldData.class);
        TableUtils.createTableIfNotExists(connectionSource, Obstacle.class);
        TableUtils.createTableIfNotExists(connectionSource, Pit.class);
        TableUtils.createTableIfNotExists(connectionSource, Mine.class);

        WorldData worldData = new WorldData();
        worldData.setWidth(1);
        worldData.setHeight(1);
        worldData.setVisibility(1);
        worldData.setRepairTime(3);
        worldData.setReloadTime(3);
        worldData.setMineTime(3);
        worldData.setMaxShield(5);
        worldData.setMaxShots(5);

        Obstacle obstacle = new Obstacle();
        obstacle.setWidth(1);
        obstacle.setHeight(1);
        obstacle.setX(34);
        obstacle.setY(-2);

        WorldDao worldDao =
                DaoManager.createDao(connectionSource, World.class);
//
        World world = new World();
        world.setName("world5");
        world.setWorldData(worldData);

        worldDao.create(world);

        worldDao.refresh(world);

        world.getObstacles().add(obstacle);
        world.getObstacles().add(obstacle);
        world.getObstacles().add(obstacle);

        World newWorld = worldDao.getWorld("world1");

        System.out.println("done");
    }
}
