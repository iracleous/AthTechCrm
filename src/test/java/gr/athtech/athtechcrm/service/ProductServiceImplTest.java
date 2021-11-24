package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.dto.CustomerDto;
import gr.athtech.athtechcrm.front.ApiResponse;
import gr.athtech.athtechcrm.model.Product;
import gr.athtech.athtechcrm.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductServiceImplTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService = new ProductServiceImpl(productRepository);


    private Product product;


    @Test
    void testNonCreatingAProductPotatoes() {
        product = new Product();
        product.setName("potatoes");

        assertSame(null, productService.create(product));
    }

}

