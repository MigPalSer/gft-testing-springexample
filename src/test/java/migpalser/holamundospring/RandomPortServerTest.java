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
class RandomPortServerTest {

    /*
    @Test
    void exampleTest(@Autowired WebTestClient webClient) {
        webClient
                .get().uri("/")
                .exchange()
                .expectStatus().isOk() //aqui se puede especificar un valor de retorno http
                .expectBody(String.class).isEqualTo("Bienvenido a este proyecto de prueba");
    }
    */

    @Test
    void exampleTest2(@Autowired TestRestTemplate restTemplate) {
        String s=restTemplate.getForObject( "/", String.class);
        assertThat(s)
		.isEqualTo("Bienvenido a este proyecto de prueba");
    }

    @Test
    void exampleTest3(@Autowired TestRestTemplate restTemplate) {
        String s=restTemplate.getForObject( "/hello?name=pepe", String.class);
        assertThat(s)
		.isEqualTo("Hello pepe!");
    }
    
    @Test
    void canAdd(@Autowired TestRestTemplate restTemplate) {
        String s=restTemplate.getForObject( "/add?x=1&y=2", String.class);
        assertThat(s)
		.isEqualTo("3");
    }
    
    @Test
    void canAddFractions(@Autowired TestRestTemplate restTemplate) {
        String s=restTemplate.getForObject( "/add?x=1.1&y=2.2", String.class);
        assertThat(s)
		.isEqualTo("3.3");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Paco", "Juan", "Ñu", "sHurPriMIkOh_69", "Ácido"})
    void displayName(String name, @Autowired TestRestTemplate restTemplate) {
    	String url="/hello?name="+name;
    	String result="Hello "+name+"!";
    	 String s=restTemplate.getForObject(url, String.class);
         assertThat(s)
 		.isEqualTo(result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sumtest.csv")
    void csvSumTest(double a, double b, double result, @Autowired TestRestTemplate restTemplate) {
    	String url="/add?a="+a+"&b="+b;
    	 String s=restTemplate.getForObject(url, String.class);
         assertThat(s)
 		.isEqualTo(result);
    }
}