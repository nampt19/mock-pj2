package com.example.fresher02_project.controller;

import com.example.fresher02_project.domain.response.BaseResponse;
import com.example.fresher02_project.domain.response.CustomerListResponse;
import com.example.fresher02_project.domain.response.CustomerResponse;
import com.example.fresher02_project.model.Customer;
import com.example.fresher02_project.model.HistoryCare;
import com.example.fresher02_project.model.WorkReminder;
import com.example.fresher02_project.service.CustomerService;
import com.example.fresher02_project.service.HistoryCareService;
import com.example.fresher02_project.service.WorkReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class RestCustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private HistoryCareService historyCareService;
    @Autowired
    private WorkReminderService workReminderService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllCustomer")
    public ResponseEntity<CustomerListResponse> getAllCustomer(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.getAll(token));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getCustomerByIdForEdit/{idCustomer}")
    public ResponseEntity<BaseResponse> getCustomerByIdForEdit(@RequestHeader("Authorization") String token,@PathVariable int idCustomer) {
        return ResponseEntity.ok(customerService.getCustomerByIdForEdit(token,idCustomer));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerResponse> saveCustomer(@RequestHeader("Authorization") String token,@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(token,customer));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<BaseResponse> deleteCustomer(@RequestHeader("Authorization") String token,@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.deleteCustomer(token,id));
    }

//    chưa checkToken
    @CrossOrigin(origins = "*")
    @PostMapping("/getHistoryCareList")
    public ResponseEntity<BaseResponse> getAllHistoryCareList(@RequestHeader("Authorization") String token, @RequestBody String idCustomer) {

        return ResponseEntity.ok(historyCareService.getHistoryCareListByIdCustomer(token, idCustomer));
    }

    //    chưa checkToken
    @CrossOrigin(origins = "*")
    @PostMapping("/addNewHistoryCare")
    public ResponseEntity<BaseResponse> addNewHistoryCareList(@RequestHeader("Authorization") String token, @RequestBody HistoryCare historyCare) {
        return ResponseEntity.ok(historyCareService.addNewHistoryCare(token, historyCare));
    }

//    chưa checkToken
    @CrossOrigin(origins = "*")
    @PostMapping("/getWorkReminderList")
    public ResponseEntity<BaseResponse> getWorkReminderList(@RequestHeader("Authorization") String token, @RequestBody String idCustomer) {
        return ResponseEntity.ok(workReminderService.getWorkRemindersByIdCustomer(token, idCustomer));
    }

    //    chưa checkToken
    @CrossOrigin(origins = "*")
    @PostMapping("/addNewWorkReminder")
    public ResponseEntity<BaseResponse> addNewWorkReminder(@RequestHeader("Authorization") String token, @RequestBody WorkReminder workReminder) {
        return ResponseEntity.ok(workReminderService.addNewWorkReminder(token, workReminder));
    }

    //    chưa checkToken
    @CrossOrigin(origins = "*")
    @RequestMapping("/tickWorkReminder")
    public ResponseEntity<BaseResponse> tickWorkReminder(@RequestHeader("Authorization") String token, @RequestBody String idWorkReminder) {

        return ResponseEntity.ok(workReminderService.saveWorkRemindersByIdCustomer(token, idWorkReminder));
    }

    //    chưa checkToken
    @CrossOrigin(origins = "*")
    @RequestMapping("/deleteWorkReminder")
    public ResponseEntity<BaseResponse> deleteWorkReminder(@RequestHeader("Authorization") String token, @RequestBody String idWorkReminder) {

        return ResponseEntity.ok(workReminderService.deleteWorkReminder(token, idWorkReminder));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getTotalHistoryCareInCurrentMonth")
    public Integer GetTotalHistoryCareInCurrentMonth(@RequestHeader("Authorization") String token) {
        return historyCareService.getTotalHistoryCareInCurrentMonth(token);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getTotalCustomerInCurrentMonth")
    public Integer getTotalCustomerInCurrentMonth(@RequestHeader("Authorization") String token){
        return customerService.getTotalCustomerInCurrentMonth(token);
    }


}
