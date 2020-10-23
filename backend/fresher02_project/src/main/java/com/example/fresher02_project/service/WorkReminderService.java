package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.response.BaseResponse;
import com.example.fresher02_project.domain.response.WorkReminderListResponse;
import com.example.fresher02_project.domain.response.WorkReminderResponse;
import com.example.fresher02_project.model.WorkReminder;
import com.example.fresher02_project.repository.CustomerRepository;
import com.example.fresher02_project.repository.UserRepository;
import com.example.fresher02_project.repository.WorkReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkReminderService extends CommonService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WorkReminderRepository workReminderRepository;
    @Autowired
    UserRepository userRepository;

    public BaseResponse getWorkRemindersByIdCustomer(String token, String id) {
        token = token.replace("Bearer ", "");
        int idCustomer = Integer.parseInt(id.substring(0, id.length() - 1));
        WorkReminderListResponse workReminderListResponse = new WorkReminderListResponse();
        List<WorkReminder> workReminders = workReminderRepository.findByIdCustomer(idCustomer);
        if (customerRepository.findByIdCustomer(idCustomer) == null) {
            workReminderListResponse.setCode("201");
            workReminderListResponse.setMessage("Người dùng không tồn tại!");
        } else {
            workReminderListResponse.setCode("200");
            workReminderListResponse.setMessage("ok");
            workReminderListResponse.setWorkReminderList(workReminders);
            workReminderListResponse.setUser(userRepository.findByToken(token));
        }
        return workReminderListResponse;
    }

    public BaseResponse saveWorkRemindersByIdCustomer(String token, String id) {
        token = token.replace("Bearer ", "");
        int idWorkReminder = Integer.parseInt(id.substring(0, id.length() - 1));
        BaseResponse baseResponse = new BaseResponse();
        WorkReminder workReminder = workReminderRepository.findByIdReminder(idWorkReminder);
        if (!userRepository.findByToken(token).getUsername().equals(workReminder.getUserName())) {
            baseResponse.setCode("301");
            baseResponse.setMessage("Bạn không có quyền đánh dấu hoàn thành work reminder này !");
            return baseResponse;
        } else {
            if (workReminder == null) {
                baseResponse.setCode("404");
                baseResponse.setMessage("Không tìm thấy work reminder!");
                return baseResponse;
            } else {
                workReminder.setDone(1);
                workReminderRepository.save(workReminder);
                baseResponse.setCode("1912");
                baseResponse.setMessage("Work Reminder lưu thành công!");
                return baseResponse;
            }
        }
    }

    public BaseResponse addNewWorkReminder(String token, WorkReminder workReminder) {
        token = token.replace("Bearer ", "");
        WorkReminderResponse workReminderResponse = new WorkReminderResponse();
        workReminderRepository.save(workReminder);
        workReminderResponse.setCode("200");
        workReminderResponse.setMessage("Added successfully!");
        workReminderResponse.setWorkReminder(workReminder);
        workReminderResponse.setUser(userRepository.findByToken(token));
        return workReminderResponse;
    }

    public BaseResponse deleteWorkReminder(String token, String id) {
        token = token.replace("Bearer ", "");
        int idReminder = Integer.parseInt(id.substring(0, id.length() - 1));
        WorkReminderResponse workReminderResponse = new WorkReminderResponse();
        WorkReminder workReminder = workReminderRepository.findByIdReminder(idReminder);
        if (!userRepository.findByToken(token).getUsername().equals(workReminder.getUserName())) {
            workReminderResponse.setCode("501");
            workReminderResponse.setMessage("Bạn không có quyền xóa work reminder của người dùng này");
            return workReminderResponse;
        } else {
            if (workReminder == null) {
                workReminderResponse.setCode("201");
                workReminderResponse.setMessage("WorkReminder đã bị xóa từ trước, kiểm tra lại!");
                return workReminderResponse;
            } else {
                workReminderRepository.delete(workReminder);
                workReminderResponse.setCode("200");
                workReminderResponse.setMessage("Xóa thành công workReminder !");
                return workReminderResponse;
            }
        }
    }

}
