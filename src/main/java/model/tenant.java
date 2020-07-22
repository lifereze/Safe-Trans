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
    public void  saveAge(String age){
        String sql ="UPDATE users SET age=:age WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("age", age)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
    public void saveHealth(String health){
        String sql ="UPDATE users SET health=:health WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("health", health)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
}

