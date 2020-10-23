package com.example.fresher02_project.controller;

import com.example.fresher02_project.domain.response.*;
import com.example.fresher02_project.model.Product;
import com.example.fresher02_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class RestProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllProduct")
    public ResponseEntity<ProductListResponse> getAllProduct(@RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(productService.getAllProduct(token));

    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveProduct")
    public ResponseEntity<ProductResponse> saveProduct(@RequestHeader("Authorization") String token,@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(token,product));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<BaseResponse> deleteProduct(@RequestHeader("Authorization") String token,@PathVariable Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(token,id));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getProductByIdForEdit/{idProduct}")
    public ResponseEntity<BaseResponse> getCustomerByIdForEdit(@RequestHeader("Authorization") String token,@PathVariable int idProduct) {
        return ResponseEntity.ok(productService.getProductByIdForEdit(token,idProduct));
    }
}
