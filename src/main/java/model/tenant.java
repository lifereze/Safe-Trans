package model;

import org.sql2o.Connection;

import java.util.List;

public class tenant extends user {

    public static final String DATABASE_TYPE = "animal";

    public tenant(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }
    public static List<tenant> all(){
        try (Connection con = DB.sql2o.open()){
            String queryAnimals ="SELECT * FROM animals WHERE type='animal'";
            return con.createQuery(queryAnimals)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);

        }
    }
}

