package de.wethinkco.objectrelationalmapping;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.List;

public interface WorldDAI extends BaseQuery {
    @Select("SELECT world_id, name FROM world WHERE world_id = ?{1}")
    WorldDO getWorld(int worldID);

    @Select("SELECT world_id, name FROM world WHERE name = ?{1}")
    WorldDO getWorld(String worldName);

    @Select("SELECT world_id, name FROM world")
    List<WorldDO> getAllWorlds();

    @Select("SELECT world_id FROM world WHERE name = ?{1}")
    int getWorldID(String worldName);

    @Update("INSERT INTO WORLD(name) VALUES(?{1})")
    void addWorld(String worldName);

    @Update("UPDATE world SET name = ?{2} WHERE world_id = ?{1}")
    void updateWorldName(int worldID, String worldName);

    @Update(
            "UPDATE world SET name = ?{1.worldName} WHERE world_id = ?{1" +
            ".primaryKey}"
    )
    void updateWorldName(WorldDO world);
}
