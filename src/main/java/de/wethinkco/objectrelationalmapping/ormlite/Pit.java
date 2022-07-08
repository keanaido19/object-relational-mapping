package de.wethinkco.objectrelationalmapping.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pits")
public class Pit extends WorldObject {

    @DatabaseField(generatedId = true)
    private int pitID;

    public Pit() {}

    public int getPitID() {
        return pitID;
    }

    public void setPitID(int pitID) {
        this.pitID = pitID;
    }
}
