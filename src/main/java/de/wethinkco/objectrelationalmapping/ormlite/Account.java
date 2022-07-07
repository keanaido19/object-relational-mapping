package de.wethinkco.objectrelationalmapping.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class Account {
    @DatabaseField(id = true)
    private String name;

    @DatabaseField(canBeNull = false, unique = true)
    private String password;

    Account() {}
}
