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
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "landing.hbs");
        }, new HandlebarsTemplateEngine());
        get("/homepage", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/login", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("username", request.session().attribute("username"));

            return new ModelAndView(model, "login.hbs");
        }, new HandlebarsTemplateEngine());
        get("/landlord/info", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "landlord.hbs");
        }, new HandlebarsTemplateEngine());
        get("/tenant/info", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "tenant.hbs");
        }, new HandlebarsTemplateEngine());
        get("/tenancy/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "user-form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/user/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "createAccount.hbs");
        }, new HandlebarsTemplateEngine());
        get("/login", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "login.hbs");
        }, new HandlebarsTemplateEngine());
        get("/payment", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "paymentForm.hbs");
        }, new HandlebarsTemplateEngine());
        get("/about-us", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "history.hbs");
        }, new HandlebarsTemplateEngine());




        //buyer form
        // seller form
    }
}
