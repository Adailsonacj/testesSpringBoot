package hello;

import bd.database;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name),
                "banco!");
    }

    @RequestMapping("/aaa")
    public Greeting greeting1(@RequestParam(value = "name", defaultValue = "World") String name) {
        String banco = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("DB connected");
            Connection c = DriverManager.getConnection(database.HOST + database.DB_NAME, database.USERNAME, database.PASSWORD);
            banco = "DB connected!";
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name),
                banco);
    }

    @RequestMapping("/addPessoa")
    public String addPessoa(@RequestParam(value = "name", defaultValue = "World") String name) {

        return "Funalo adicionado";
    }
}
