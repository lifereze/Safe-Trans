package model;
import org.sql2o.Connection;
import java.util.Objects;

public abstract class user<String> {

    public int id;
    public String name;
    public int user_id;
    public String location;
    public String apartment;
    public String type;



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return user_id;
    }

    public String getLocation(){
        return location;
    }

    public String getApartment(){
        return apartment;
    }
    public String getType(){
        return type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(type, user.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    public void save(){
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO users(name, type) VALUES(:name,:type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name",this.name)
                    .addParameter("type",this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
}