package migpalser.holamundospring;

import org.junit.jupiter.api.Test;
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
    

}