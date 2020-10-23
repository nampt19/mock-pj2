package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.response.BaseResponse;
import com.example.fresher02_project.domain.response.HistoryCareListResponse;
import com.example.fresher02_project.domain.response.HistoryCareResponse;
import com.example.fresher02_project.model.Customer;
import com.example.fresher02_project.model.HistoryCare;
import com.example.fresher02_project.model.Product;
import com.example.fresher02_project.repository.CustomerRepository;
import com.example.fresher02_project.repository.HistoryCareRepository;
import com.example.fresher02_project.repository.ProductRepository;
import com.example.fresher02_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryCareService extends CommonService{
    private final String thisPage = "mycustomerhistorycare.html";
    @Autowired
    HistoryCareRepository historyCareRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;
    public BaseResponse getHistoryCareListByIdCustomer(String token, String id) {
        token = token.replace("Bearer ", "");
        HistoryCareListResponse historyCareListResponse = new HistoryCareListResponse();
            Customer customer;
            int idCustomer = Integer.parseInt(id.substring(0, id.length() - 1));
            customer = customerRepository.findByIdCustomer(idCustomer);

            List<HistoryCare> historyCares = historyCareRepository.findByIdCustomer(idCustomer);

            if (customer == null) {
                historyCareListResponse.setCode("201");
                historyCareListResponse.setMessage("Khách hàng này không tồn tại!");
            } else {
                historyCareListResponse.setCode("200");
                historyCareListResponse.setMessage("ok");
                historyCareListResponse.setHistoryCares(historyCares);
                historyCareListResponse.setCustomer(customer);
                historyCareListResponse.setUser(userRepository.findByToken(token));
            }
        return historyCareListResponse;
        }

    public boolean isHistoryCareValid(HistoryCare historyCare){
        boolean isValid = true;
        if(historyCare.getStartTime().compareTo(historyCare.getEndTime())>0){
            isValid=false;
        }
        return isValid;
    }
    public BaseResponse addNewHistoryCare(String token, HistoryCare historyCare){
        token = token.replace("Bearer ", "");
        HistoryCareResponse historyCareResponse= new HistoryCareResponse();
        if (checkToken(token, thisPage, "add")) {
            if (isHistoryCareValid(historyCare)) {
                historyCareRepository.save(historyCare);
                historyCareResponse.setCode("200");
                historyCareResponse.setMessage("Phiên chăm sóc khách hàng thêm mới thành công!");
                historyCareResponse.setHistoryCare(historyCare);
                historyCareResponse.setUser(userRepository.findByToken(token));

            } else {
                historyCareResponse.setCode("201");
                historyCareResponse.setMessage("Kiểm tra 'thời gian bắt đầu và thời gian kết thúc', thêm mới phiên thất bại!");

            }
        }
        else {
            historyCareResponse.setMessage("Không có quyền thêm !");
        }
        return historyCareResponse;
    }
    public int getTotalHistoryCareInCurrentMonth(String token){
        int totalHistoryCareInCurrentMonth=0;
        if(checkBaseToken(token)){
        Date date = new Date();
        int currentMonth= date.getMonth();
        List<HistoryCare> historyCares = historyCareRepository.findAll();
        for (HistoryCare historyCare:historyCares) {
            if(historyCare.getStartTime().getMonth()==currentMonth &&(historyCare.getStartTime().getYear()==date.getYear())){
                totalHistoryCareInCurrentMonth++;
            }
        }}
        return totalHistoryCareInCurrentMonth;
    }


}
