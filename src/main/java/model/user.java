package model;
import org.sql2o.Connection;
import java.util.Objects;

public abstract class user<String> {

    public int id;
    public String name;
    public int user_id;
    public String location;
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

    public String getType(){
        return type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (model.user) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(type, user.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    public void save(){
        try (Connection con = DB.sql2o.open()){
            String sql = (String) "INSERT INTO users(name, user_id, location, type) VALUES(:name, :user_id, :location, :type)";
            this.id = (int) con.createQuery((java.lang.String) sql, true)
                    .addParameter("name",this.name)
                    .addParameter("user_id", this.user_id)
                    .addParameter("location", this.location)
                    .addParameter("type",this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
}