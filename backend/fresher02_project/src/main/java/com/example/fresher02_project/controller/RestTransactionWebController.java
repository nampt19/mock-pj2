package com.example.fresher02_project.controller;

import com.example.fresher02_project.domain.response.*;
import com.example.fresher02_project.model.Transaction;
import com.example.fresher02_project.service.TransactionWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class RestTransactionWebController {

    @Autowired
    TransactionWebService transactionWebService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllTransaction")
    public ResponseEntity<TransactionWebListResponse> getAllTransaction(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(transactionWebService.getAllTransaction(token));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveTransaction")
    public ResponseEntity<TransactionWebResponse> saveTransactionFromForm(@RequestHeader("Authorization") String token,@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionWebService.saveTransaction(token,transaction));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteTransaction/{idTransaction}")
    public ResponseEntity<BaseResponse> deleteTransaction(@RequestHeader("Authorization") String token,@PathVariable int idTransaction) {
        return ResponseEntity.ok(transactionWebService.deleteTransaction(token,idTransaction));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getTransactionByIdForEdit/{idTransaction}")
    public ResponseEntity<BaseResponse> getTransactionByIdForEdit(@RequestHeader("Authorization") String token,@PathVariable int idTransaction) {
        return ResponseEntity.ok(transactionWebService.getTransactionByIdForEdit(token,idTransaction));
    }


}
