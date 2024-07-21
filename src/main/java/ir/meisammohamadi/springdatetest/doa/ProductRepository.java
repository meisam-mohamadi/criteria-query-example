package ir.meisammohamadi.springdatetest.doa;

import ir.meisammohamadi.springdatetest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
