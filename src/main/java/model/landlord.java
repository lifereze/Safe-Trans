package model;


import org.sql2o.Connection;

import java.util.List;

public class landlord extends user {

    public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";

    //discriminator
    public static final String DATABASE_TYPE = "landlord";

    private String age;
    private String health;

    public landlord(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public static List<landlord> all(){
        try (Connection con = DB.sql2o.open()){
            String queryEndangered = "SELECT * FROM users WHERE type='landlord'";
            return con.createQuery(queryEndangered)
                    .executeAndFetch(landlord.class);
        }
    }




}
