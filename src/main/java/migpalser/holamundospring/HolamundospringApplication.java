package migpalser.holamundospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HolamundospringApplication {

public static void main(String[] args) {
SpringApplication.run(HolamundospringApplication.class, args);
}

@GetMapping("/hello")
public String hello(@RequestParam(value = "name", defaultValue = "Guorl") String name) {
return String.format("Hello %s!", name);
}

@GetMapping("/")
public String root() {
return "Bienvenido a este proyecto de prueba";
}

}