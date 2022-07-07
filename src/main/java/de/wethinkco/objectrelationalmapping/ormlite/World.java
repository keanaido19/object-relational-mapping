package de.wethinkco.objectrelationalmapping.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "world")
public class World {
    @DatabaseField(generatedId = true)
    private int worldID;

    @DatabaseField(canBeNull = false, unique = true)
    private String name;

    public World() {}

    public int getWorldID() {
        return worldID;
    }

    public void setWorldID(int worldID) {
        this.worldID = worldID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
