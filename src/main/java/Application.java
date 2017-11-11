import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application {
    @RequestMapping(value="/{factor}", method = RequestMethod.GET)
    String home(@PathVariable("factor") int factor){

        return "Hello World @ bike_mechanics " + factor;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
    }
}
