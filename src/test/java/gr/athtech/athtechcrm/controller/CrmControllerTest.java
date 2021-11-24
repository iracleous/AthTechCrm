package gr.athtech.athtechcrm.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;





import gr.athtech.athtechcrm.dto.CustomerDto;
import gr.athtech.athtechcrm.front.ApiResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrmControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/ping",
                String.class)).contains("The API is working");
    }

    @Test
    @DisplayName("Test for the number of customers")
    public void customerShouldBeTwo() throws Exception {

        ApiResponse<List<CustomerDto>> response = this.restTemplate
                .getForObject("http://localhost:" + port + "/customer", ApiResponse.class);

        List<CustomerDto> customers =response.getData();

        assertNotNull(customers);
        assertEquals(2, customers.size(),"Not expected number of customers");
        assertTrue(customers.size()>1, "Should exist more than one customer");

    }

}

