package model;

import org.sql2o.Connection;

import java.util.List;

public class tenant extends user {


    public static final String DATABASE_TYPE = "tenant";

    public tenant(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }
    public static List<user> all(){
        try (Connection con = DB.sql2o.open()){
            String queryAnimals ="SELECT * FROM tenants WHERE type='tenant'";
            return con.createQuery(queryAnimals)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(user.class);

        }
    }


}

