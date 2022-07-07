package de.wethinkco.objectrelationalmapping;

import net.lemnik.eodsql.ResultColumn;

public class WorldDO {
    private int id;
    private String name;

    public WorldDO() {}

    public int getPrimaryKey() {
        return id;
    }

    @ResultColumn("world_id")
    public void setPrimaryKey(int key) {
        this.id = key;
    }

    public String getWorldName() {
        return name;
    }

    @ResultColumn("name")
    public void setWorldName(String worldName) {
        this.name = worldName;
    }
}
