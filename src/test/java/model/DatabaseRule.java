package model;

import model.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class DatabaseRule extends ExternalResource {
   // private static final model.DB DB =;

    @Override
    protected void before() throws Throwable {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test","moringa", "lifereze1998");
    }

    @Override
    protected void after() {
        try (Connection con = DB.sql2o.open()){
            String deleteUsers = "DELETE FROM users *;";
            con.createQuery(deleteUsers).executeUpdate();
        }
    }
}