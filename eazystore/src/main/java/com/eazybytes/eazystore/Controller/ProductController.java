package com.eazybytes.eazystore.Controller;

import com.eazybytes.eazystore.dto.ProductDto;
import com.eazybytes.eazystore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:5000")
public class ProductController {
    /*private final ProductRepository productRepository;*/
    private final IProductService iProductService;
    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        /*List<Product> productList = productRepository.findAll();*/
        List<ProductDto> productList = iProductService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

}
