package ir.meisammohamadi.springdatetest.service;

import ir.meisammohamadi.springdatetest.doa.ProductRepository;
import ir.meisammohamadi.springdatetest.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public void insertAll(Iterable<Product> products) {
        productRepository.saveAll(products);
    }


    public List<Product> selectByName() {

        String partOfName = "iphone";
        Long minimumId = 2l;

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

//        متد createQuery از CriteriaBuilder یک شیء CriteriaQuery جدید ایجاد می‌کند.
//        پارامتر Product.class تعیین می‌کند که نوع نتیجه‌ای که query برمی‌گرداند از نوع Product خواهد بود. به عبارت دیگر، این query برای انتخاب اشیاء Product طراحی شده است.
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

        // حط زیر entity ای که قرار است data از  table آنانتخاب شود را مشخص میکند
        Root<Product> root = criteriaQuery.from(Product.class);

        //با استفاده از predicate های زیر دو تا شرط تعریف میکنم که در where  می خواهم استفاده کنم
        Predicate condition1 = criteriaBuilder.greaterThan(root.get("id"), minimumId);
        Predicate condition2 = criteriaBuilder.like(root.get("name"), "%" + partOfName + "%");

        // اینجا دستور select ساخته میشه
        criteriaQuery.select(root).where(criteriaBuilder.and(condition1, condition2));

        // خط زیر هم criteria query ساخته شده را اجرا میند و نتیجه را برمیگرداند
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
