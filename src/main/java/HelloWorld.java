import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorld {
    @RequestMapping("/")
    String home(){
        return "Hello World @ bike_mechanics";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(HelloWorld.class, args);
    }
}
