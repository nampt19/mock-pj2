package com.example.fresher02_project.controller;

import com.example.fresher02_project.domain.response.ProductAmountListResponse;
import com.example.fresher02_project.domain.response.TransactionWebChartResponse;
import com.example.fresher02_project.service.ProductService;
import com.example.fresher02_project.service.TransactionWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class RestDashboardController {
    @Autowired
    private TransactionWebService transactionWebService;

    @Autowired
    private ProductService productService;


    @CrossOrigin(origins = "*")
    @GetMapping("/getDataForChart")
    public ResponseEntity<TransactionWebChartResponse> getDataForChart(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(transactionWebService.getDataForChart(token));
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/productSoldTheMost")
    public ResponseEntity<ProductAmountListResponse> productSoldTheMost(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(productService.productSoldTheMost(token));
    }
}
