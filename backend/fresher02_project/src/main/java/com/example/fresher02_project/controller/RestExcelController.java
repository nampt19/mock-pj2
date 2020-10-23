package com.example.fresher02_project.controller;

import com.example.fresher02_project.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@CrossOrigin("http://localhost:8080")
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/excel")
public class RestExcelController {

    @Autowired
    ExcelService fileService;

    //    chưa checkToken
    @GetMapping("/download/customers/{token}")
    public ResponseEntity<Resource> getFileCustomers(@PathVariable String token) {
        System.out.println(token);
        String filename = "Customer.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadCustomer(token));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    //    chưa checkToken
    @GetMapping("/download/users/{token}")
    public ResponseEntity<Resource> getFileUsers(@PathVariable String token) {
        String filename = "User.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadUser(token));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    //    chưa checkToken
    @GetMapping("/download/historycares/{token}")
    public ResponseEntity<Resource> getFileHistoryCares(@PathVariable String token) {
        String filename = "HistoryCare.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadHistoryCare(token));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    //    chưa checkToken
    @GetMapping("/download/transections/{token}")
    public ResponseEntity<Resource> getFileTransections(@PathVariable String token) {
        String filename = "Transection.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadTransection(token));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    //    chưa checkToken
    @GetMapping("/download/products/{token}")
    public ResponseEntity<Resource> getFileProducts(@PathVariable String token) {
        String filename = "Product.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadProduct(token));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}