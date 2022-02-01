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
class MultTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/multtest.csv")
    void csvMultTest(String a, String b, String result, @Autowired TestRestTemplate restTemplate) {
    	String url="/mult?x="+a+"&y="+b;
    	 String s=restTemplate.getForObject(url, String.class);
         assertThat(s)
 		.isEqualTo(result);
    }
}