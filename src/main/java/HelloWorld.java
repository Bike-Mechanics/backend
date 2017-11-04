import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class HelloWorld {
    @RequestMapping("/")
    String home(){
        List<String> myStuffToPrint = new ArrayList<String>();
        int counter = 0;
        while(counter < 10){
            counter++;
            myStuffToPrint.add("A bike part with id <"+ counter+">\n<br>");
        }
        return "Hello World @ bike_mechanics\n<br>" + myStuffToPrint.toString();
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(HelloWorld.class, args);
    }
}
