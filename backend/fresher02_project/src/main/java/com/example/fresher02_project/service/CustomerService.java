package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.response.BaseResponse;
import com.example.fresher02_project.domain.response.CustomerListResponse;
import com.example.fresher02_project.domain.response.CustomerResponse;
import com.example.fresher02_project.domain.response.UserRoleListResponse;
import com.example.fresher02_project.helper.Regex;
import com.example.fresher02_project.helper.TimeHelper;
import com.example.fresher02_project.model.Customer;
import com.example.fresher02_project.model.UserRole;
import com.example.fresher02_project.repository.CustomerRepository;
import com.example.fresher02_project.repository.HistoryCareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService extends CommonService {

    private final String thisPage = "customer.html";
    @Autowired
    CustomerRepository repository;
    @Autowired
    HistoryCareRepository historyCareRepository;

    @Autowired
    CustomerRepository customerRepository;

    public CustomerListResponse getAll(String token) {
        CustomerListResponse customerListResponse = new CustomerListResponse();

        if (checkToken(token, thisPage, "read")) {
            List<Customer> customerList = repository.findAll();
            if (customerList != null) {
                customerListResponse.setCode("200");
                customerListResponse.setMessage("success");
                customerListResponse.setCustomerList(customerList);
            } else {
                customerListResponse.setCode("201");
                customerListResponse.setMessage("error");
            }
        }
        return customerListResponse;
    }

    public CustomerResponse saveCustomer(String token, Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customer1 = repository.findByIdCustomer(customer.getIdCustomer());
       // System.out.println(customer.getIdCustomer());
        if (customer.getIdCustomer() == 0) {
            if (checkToken(token, thisPage, "add")) {
                if (!customer.getEmail().matches(Regex.EMAIL_REGEX)) {
                    customerResponse.setCode("201");
                    customerResponse.setMessage("Wrong format email !");
                } else if (!customer.getPhone().matches(Regex.PHONE_REGREX)) {
                    customerResponse.setCode("202");
                    customerResponse.setMessage("Wrong format phone !");
                } else if (repository.findByEmail(customer.getEmail()) != null) {
                    customerResponse.setCode("203");
                    customerResponse.setMessage("Email already exists !");
                } else if (repository.findByPhone(customer.getPhone()) != null) {
                    customerResponse.setCode("204");
                    customerResponse.setMessage("Phone already exists !");
                } else {
                    customerResponse.setCode("200");
                    customerResponse.setMessage("Insert Customer success");
                    customer.setCreateTime(new TimeHelper().getDateTimeNow());
                    customerResponse.setCustomer(customer);

                    repository.save(customer);
                }
            }
        } else {
            if (checkToken(token, thisPage, "edit")) {
                if (!customer.getPhone().matches(Regex.PHONE_REGREX)) {
                    customerResponse.setCode("202");
                    customerResponse.setMessage("Wrong format phone !");
                } else if (repository.findByPhone(customer.getPhone()) != null &&
                        !repository.findByPhone(customer.getPhone()).getPhone().equals(customer1.getPhone())) {
                    customerResponse.setCode("204");
                    customerResponse.setMessage("Phone already exists !");
                } else if (repository.findByEmail(customer.getEmail()) != null &&
                        !repository.findByEmail(customer.getEmail()).getEmail().equals(customer1.getEmail())) {
                    customerResponse.setCode("204");
                    customerResponse.setMessage("Email already exists !");
                }
                else if (customer1 == null) {
                    customerResponse.setCode("205");
                    customerResponse.setMessage("Customer not exists !");
                } else {
                    customerResponse.setCode("200");
                    customerResponse.setMessage("Edit Customer success");
                    customerResponse.setCustomer(customer1);
                    customer.setCreateByIdUser(customer1.getCreateByIdUser());
                    repository.save(customer);
                }
            }
        }
        return customerResponse;
    }

    public BaseResponse deleteCustomer(String token, Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "delete")) {
            Customer customer = repository.findByIdCustomer(id);
            if (customer != null) {
                repository.delete(customer);
                baseResponse.setCode("300");
                baseResponse.setMessage("Delete success !");
            } else {
                baseResponse.setCode("301");
                baseResponse.setMessage("User Not Exist !");
            }
        }
        return baseResponse;
    }

//    public CustomerListResponse getAllCustomerByIdUser(String userId) {
//        int id = Integer.parseInt(userId.substring(0, userId.length() - 1));
//        System.out.println(id);
//        List<Customer> customerList = customerRepository.findByCreateByIdUser(id);
//        CustomerListResponse customerListResponse = new CustomerListResponse();
//
//        if (customerList != null) {
//            customerListResponse.setCode("200");
//            customerListResponse.setMessage("success");
//            customerListResponse.setCustomerList(customerList);
//        } else {
//            customerListResponse.setCode("201");
//            customerListResponse.setMessage("error");
//        }
//        return customerListResponse;
//    }

    public int getTotalCustomerInCurrentMonth(String token) {
        Date date = new Date();
        List<Customer> customers = customerRepository.findAll();
        int totalCustomerInCurrentMonth = 0;
        if (checkBaseToken(token)) {
            try {
                for (Customer customer : customers) {
                    if ((customer.getCreateTime().getMonth() == date.getMonth()) && (customer.getCreateTime().getYear() == date.getYear())) {
                        totalCustomerInCurrentMonth++;
                    }
                }
            } catch (NullPointerException nullPe) {
                System.out.println(nullPe);
            }
        }
        return totalCustomerInCurrentMonth;
    }

    public BaseResponse getCustomerByIdForEdit(String token, int idCustomer) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "edit")) {
            if (customerRepository.findByIdCustomer(idCustomer) == null) {

                baseResponse.setCode("101");
                baseResponse.setMessage("Customer not Exist !");
            } else {
                baseResponse.setCode("102");
                baseResponse.setMessage("Success !");
            }
        }

        return baseResponse;
    }
}
