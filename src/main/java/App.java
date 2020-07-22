import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        port(port);

        staticFileLocation("/public");

     //start session
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("username", request.session().attribute("username"));

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/user-form/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "user-createAccount.hbs");
        }, new HandlebarsTemplateEngine());




        //buyer form
        // seller form
    }
}
