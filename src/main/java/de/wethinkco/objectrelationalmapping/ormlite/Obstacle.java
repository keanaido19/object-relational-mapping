package de.wethinkco.objectrelationalmapping.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "obstacles")
public class Obstacle extends WorldObject {

    @DatabaseField(generatedId = true)
    private int obstacleID;

    public Obstacle() {}

    public int getObstacleID() {
        return obstacleID;
    }

    public void setObstacleID(int obstacleID) {
        this.obstacleID = obstacleID;
    }
}
