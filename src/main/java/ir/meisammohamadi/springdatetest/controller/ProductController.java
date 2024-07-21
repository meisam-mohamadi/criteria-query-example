package ir.meisammohamadi.springdatetest.controller;

import ir.meisammohamadi.springdatetest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity selectByName()
    {
        return  new ResponseEntity(productService.selectByName() , HttpStatus.OK);
    }
}
