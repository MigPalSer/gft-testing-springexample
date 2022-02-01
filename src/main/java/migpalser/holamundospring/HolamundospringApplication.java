package migpalser.holamundospring;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HolamundospringApplication {

	@Generated(value="org.springframework.boot")
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

	@GetMapping("/add")
	public String add(@RequestParam(value = "x", defaultValue = "0") String x,
			@RequestParam(value = "y", defaultValue = "0") String y) {
		double dx = Double.parseDouble(x);
		BigDecimal bx=BigDecimal.valueOf(dx);
		double dy = Double.parseDouble(y);
		BigDecimal by=BigDecimal.valueOf(dy);
		
		String result=FormatUtils.fmtBigDecimal(bx.add(by));
		
		return result;
	}

	@GetMapping("/sust")
	public String sust(@RequestParam(value = "x", defaultValue = "0") String x,
			@RequestParam(value = "y", defaultValue = "0") String y) {
		double dx = Double.parseDouble(x);
		BigDecimal bx=BigDecimal.valueOf(dx);
		double dy = Double.parseDouble(y);
		BigDecimal by=BigDecimal.valueOf(dy);
		
		String result=FormatUtils.fmtBigDecimal(bx.subtract(by));
		
		return result;
	}
	
	@GetMapping("/mult")
	public String mult(@RequestParam(value = "x", defaultValue = "0") String x,
			@RequestParam(value = "y", defaultValue = "0") String y) {
		double dx = Double.parseDouble(x);
		BigDecimal bx=BigDecimal.valueOf(dx);
		double dy = Double.parseDouble(y);
		BigDecimal by=BigDecimal.valueOf(dy);
		
		String result=FormatUtils.fmtBigDecimal(bx.multiply(by));
		
		return result;
	}
	
	@GetMapping("/div")
	public String div(@RequestParam(value = "x", defaultValue = "0") String x,
			@RequestParam(value = "y", defaultValue = "0") String y) {
		double dx = Double.parseDouble(x);
		BigDecimal bx=BigDecimal.valueOf(dx);
		double dy = Double.parseDouble(y);
		BigDecimal by=BigDecimal.valueOf(dy);
		
		if(dy==0.0) {
			return "error";
		}else {
			String result=FormatUtils.fmtBigDecimal(bx.divide(by));
			
			return result;
		}
		
		
	}
	
}