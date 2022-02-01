package migpalser.holamundospring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class HelloTest {


    @Test
    void basicNameTest(@Autowired TestRestTemplate restTemplate) {
        String s=restTemplate.getForObject( "/hello?name=pepe", String.class);
        assertThat(s)
		.isEqualTo("Hello pepe!");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Paco", "Juan", "Ñu", "sHurPriMIkOh_69", "Ácido"})
    void parameterizedDisplayName(String name, @Autowired TestRestTemplate restTemplate) {
    	String url="/hello?name="+name;
    	String result="Hello "+name+"!";
    	 String s=restTemplate.getForObject(url, String.class);
         assertThat(s)
 		.isEqualTo(result);
    }

}