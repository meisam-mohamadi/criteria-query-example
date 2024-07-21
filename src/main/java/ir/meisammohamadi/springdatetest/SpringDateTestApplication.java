package ir.meisammohamadi.springdatetest;

import ir.meisammohamadi.springdatetest.domain.Product;
import ir.meisammohamadi.springdatetest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDateTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDateTestApplication.class, args);
    }

    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        List<Product> newProducts = List.of(

                Product.builder().name("iphone 10").price(1000).build(),
                Product.builder().name("iphone 11").price(2000).build(),
                Product.builder().name("iphone 12").price(3000).build(),
                Product.builder().name("iphone 13").price(4000).build(),
                Product.builder().name("iphone 14").price(5000).build()
        );
        productService.insertAll(newProducts);
    }
}
