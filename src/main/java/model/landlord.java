package model;


import org.sql2o.Connection;

import java.util.List;

public class landlord extends user {


    //discriminator
    public static final String DATABASE_TYPE = "landlord";

    private String house_type;

    public landlord(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }

    public String getApartment_name() {
        return apartment_name;
    }

    public String getHouse_type() {
        return house_type;
    }

    public static List<landlord> all(){
        try (Connection con = DB.sql2o.open()){
            String queryEndangered = "SELECT * FROM users WHERE type='landlord'";
            return con.createQuery(queryEndangered)
                    .executeAndFetch(landlord.class);
        }
    }

    public void saveHouse_Type(String health){
        String sql ="UPDATE users SET house_type=:house_type WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("house_type", house_type)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }


}
