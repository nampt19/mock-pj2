package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.request.ConfigPasswordRequest;
import com.example.fresher02_project.domain.response.*;
import com.example.fresher02_project.helper.JwtTokenUtil;
import com.example.fresher02_project.helper.Regex;
import com.example.fresher02_project.helper.TimeHelper;
import com.example.fresher02_project.model.*;
import com.example.fresher02_project.repository.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService extends CommonService {

    private final String thisPage = "users.html";
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RolePageActionRepository rolePageActionRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    HistoryCareRepository historyCareRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ProductRepository productRepository;

    public Boolean test(String token) {
        return checkToken(token, "transaction.html", "read");
    }

    public PasswordResponse findPassWordByIdUser(String token, Integer id) {
        PasswordResponse passwordResponse = new PasswordResponse();
        User user = userRepository.findByIdUser(id);
        if (user != null) {
            passwordResponse.setCode("200");
            passwordResponse.setMessage("Find User success !");
            passwordResponse.setPassword(user.getPassword());
        } else {
            passwordResponse.setCode("201");
            passwordResponse.setMessage("User not Exist !");
        }
        return passwordResponse;
    }

    public UserListResponse getAllExceptAdmin(String token) {
        UserListResponse userListResponse = new UserListResponse();
        if (checkToken(token, thisPage, "read")) {
            // lấy ra danh sách user là admin
            List<UserRole> userRoleList = userRoleRepository.findByIdRole(1);

            List<User> userList = userRepository.findAll();
            // xóa tất cả các admin ra khỏi list
            for (int i = 0; i < userRoleList.size(); i++) {
                userList.remove(userRepository.findByIdUser(userRoleList.get(i).getIdUser()));
            }
            if (userList != null) {
                userListResponse.setCode("200");
                userListResponse.setMessage("success");
                userListResponse.setUserList(userList);
            } else {
                userListResponse.setCode("201");
                userListResponse.setMessage("List null !");
            }
        }
        return userListResponse;
    }

    public UserListResponse getAllUser(String token) {
        UserListResponse userListResponse = new UserListResponse();
        if (checkToken(token, thisPage, "read")) {
            List<User> userList = userRepository.findAll();
            if (userList != null) {
                userListResponse.setCode("200");
                userListResponse.setMessage("success");
                userListResponse.setUserList(userList);
            } else {
                userListResponse.setCode("201");
                userListResponse.setMessage("List null !");
            }
        }
        return userListResponse;
    }

    public UserListResponse getAllUserInMyGroup(String token, String userId) {
        UserListResponse userListResponse = new UserListResponse();

        if (checkToken(token, "group.html", "read")) {
            int id = Integer.parseInt(userId.substring(0, userId.length() - 1));

            User user = userRepository.findByIdUser(id);
            List<User> userList = userRepository.findByIdGroup(user.getIdGroup());

            for (int i = 0; i < userList.size(); i++) {
                userList.remove(user);
            }
            if (userList != null) {
                userListResponse.setCode("200");
                userListResponse.setMessage("success");
                userListResponse.setUserList(userList);
            } else {
                userListResponse.setCode("201");
                userListResponse.setMessage("List null !");
            }
        }
        return userListResponse;
    }

    public UserResponse saveUser(String token, User user) {
        UserResponse userResponse = new UserResponse();
        User user1 = userRepository.findByIdUser(user.getIdUser());
        if (user1 == null) {
            if (checkToken(token, thisPage, "add") || checkToken(token, "group.html", "add")) {
                if (!user.getEmail().matches(Regex.EMAIL_REGEX)) {
                    userResponse.setCode("201");
                    userResponse.setMessage("Wrong format email !");
                } else if (!user.getPhone().matches(Regex.PHONE_REGREX)) {
                    userResponse.setCode("202");
                    userResponse.setMessage("Wrong format phone !");
                } else if (userRepository.findByEmail(user.getEmail()) != null) {
                    userResponse.setCode("203");
                    userResponse.setMessage("Email already exists !");
                } else if (userRepository.findByPhone(user.getPhone()) != null) {
                    userResponse.setCode("204");
                    userResponse.setMessage("Phone already exists !");
                } else {
                    userResponse.setCode("200");
                    userResponse.setMessage("Insert User success");
                    userResponse.setUser(user);
                    // mã hóa mật khẩu và lưu lại !
                    String email = user.getEmail();
                    String password = encrypt(user.getPassword(), email);
                    user.setPassword(password);
                    user.setCreateTime(new TimeHelper().getDateTimeNow());
                    String secret = RandomStringUtils.randomNumeric(5);
                    String userName = (new Regex().removeAccent(user.getName())).toLowerCase();
                    while (userRepository.findByUsername(userName.replace(" ", "") + secret) != null) {
                        secret = RandomStringUtils.randomNumeric(5);
                    }
                    user.setUsername(userName.replace(" ", "") + secret);
                    userRepository.save(user);
                }
            }
        } else {
            if (checkToken(token, thisPage, "edit") || checkToken(token, "group.html", "edit")) {
                if (!user.getPhone().matches(Regex.PHONE_REGREX)) {
                    userResponse.setCode("202");
                    userResponse.setMessage("Wrong format phone !");
                } else if (userRepository.findByPhone(user.getPhone()) != null &&
                        !userRepository.findByPhone(user.getPhone()).getPhone().equals(user1.getPhone())) {
                    userResponse.setCode("204-2");
                    userResponse.setMessage("Phone already exists !");
                } else {
                    userResponse.setCode("200-2");
                    userResponse.setMessage("Edit User success");
                    userResponse.setUser(user1);
                    // mã hóa mật khẩu và lưu lại !
                    user.setPassword(user1.getPassword());
                    user.setEmail(user1.getEmail());
                    user.setCreateByIdAdmin(user1.getCreateByIdAdmin());
                    user.setUsername(user1.getUsername());
                    userRepository.save(user);
                }
            }
        }
        return userResponse;
    }

    public BaseResponse deleteUser(String token, Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "delete")) {
            User user = userRepository.findByIdUser(id);
            List<UserRole> userRoleList = userRoleRepository.findByIdUser(id);
            if (user == null) {

                baseResponse.setCode("301");
                baseResponse.setMessage("User Not Exist !");

            } else if (userRoleList.isEmpty()) {
                userRepository.delete(user);
                baseResponse.setCode("300");
                baseResponse.setMessage("Delete success !");
            } else {
                userRoleRepository.deleteAll(userRoleList);
                userRepository.delete(user);
                baseResponse.setCode("300");
                baseResponse.setMessage("Delete success !");
            }
        }
        return baseResponse;
    }

    public List<User> encryptPassword() {
        for (User user : userRepository.findAll()) {
            String oldPassword = user.getPassword();
            String newPassword = encrypt(oldPassword, user.getEmail());
            user.setPassword(newPassword);
            userRepository.save(user);
        }
        return userRepository.findAll();
    }

    public List<User> decryptPassword() {
        for (User user : userRepository.findAll()) {
            String oldPassword = user.getPassword();
            String newPassword = decrypt(oldPassword, user.getEmail());
            user.setPassword(newPassword);
            userRepository.save(user);
        }
        return userRepository.findAll();
    }


    public UserResponse checkLogin(User user) {
        UserResponse userResponse = new UserResponse();
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String email = user.getEmail();
        String password = encrypt(user.getPassword(), email);
        if (userRepository.findByEmail(email) == null) {
            userResponse.setCode("001");
            userResponse.setMessage("Sai tài khoản !");
        } else if (!userRepository.findByEmail(email).getPassword().equals(password)) {
            userResponse.setCode("002");
            userResponse.setMessage("Sai mật khẩu !");
        } else if (userRepository.findByEmail(email).getStatus().equals("Không hoạt động")) {
            userResponse.setCode("003");
            userResponse.setMessage("Tài khoản đã bị khóa !");
        } else {
            User userToken = userRepository.findByEmail(email);
            userToken.setToken(jwtTokenUtil.generateToken(user));
            userRepository.save(userToken);
            userResponse = findUserInfo(userToken.getIdUser());
            userResponse.setCode("000");
            userResponse.setMessage("Success !");
            userResponse.setToken(jwtTokenUtil.generateToken(user));
        }
        return userResponse;

    }


    public UserResponse changePassword(String token, ConfigPasswordRequest changePassword) {
        UserResponse userResponse = new UserResponse();
        if (checkBaseToken(token)) {

            token = token.replace("Bearer ", "");
            User user = userRepository.findByToken(token);
            String password = encrypt(changePassword.getOldPassword(), user.getEmail());

            if (!user.getPassword().equals(password)) {
                userResponse.setCode("003");
                userResponse.setMessage("Wrong password !");
            } else {
                user.setPassword(encrypt(changePassword.getNewPassword(), user.getEmail()));
                userRepository.save(user);
                userResponse.setCode("000");
                userResponse.setMessage("Success !");
                userResponse.setUser(user);
            }
        }
        return userResponse;
    }

    public UserResponse logOut(String token) {
//        System.out.println(token);
        token = token.replace("Bearer ", "");
//        System.out.println(token);
        UserResponse userResponse = new UserResponse();
        User user = userRepository.findByToken(token);
//        System.out.println(token);

        if (user == null) {
            userResponse.setCode("004");
            userResponse.setMessage("Your account was remove or not active !");
        } else {
            user.setToken("");
            userRepository.save(user);
            userResponse.setCode("000");
            userResponse.setMessage("Success !");
        }
        return userResponse;
    }

    public UserResponse resetPassword(String token, String id) {
        UserResponse userResponse = new UserResponse();
        if (checkToken(token, thisPage, "read")) {
            int agentId = Integer.parseInt(id.substring(0, id.length() - 1));
            User user = userRepository.findByIdUser(agentId);
            String password = encrypt((user.getUsername() + user.getEmail()), user.getEmail());
            user.setPassword(password);
            userRepository.save(user);
            userResponse.setCode("000");
            userResponse.setMessage("Success !");
            userResponse.setUser(user);
        }
        return userResponse;
    }


    public UserResponse findUserInfo(int userId) {
        UserResponse userResponse = new UserResponse();
        User user = userRepository.findByIdUser(userId);
        userResponse.setUser(user);

        List<UserRole> roleList = userRoleRepository.findByIdUser(userId);
        List<RolePageAction> rolePageActionList = new ArrayList<>();
        List<PageAction> pageActionList = new ArrayList<>();

        for (UserRole userRole : roleList) {
            int roleId = userRole.getIdRole();
            rolePageActionList.addAll(rolePageActionRepository.findByIdRole(roleId));
        }

        for (RolePageAction rolePageAction : rolePageActionList) {
            int pageId = rolePageAction.getIdPage();
            Page page = pageRepository.findByIdPage(pageId);
            int actionId = rolePageAction.getIdAction();
            Action action = actionRepository.findByIdAction(actionId);

            boolean found = false;
            for (PageAction pageAction : pageActionList) {
                if (pageAction.getPage().getIdPage() == page.getIdPage()) {
                    pageAction.getActionList().add(action);
                    found = true;
                    break;
                }
            }
            if (!found) {
                PageAction pageAction = new PageAction();
                pageAction.setPage(page);
                List<Action> actionList = new ArrayList<>();
                actionList.add(action);
                pageAction.setActionList(actionList);
                pageActionList.add(pageAction);
            }
        }
        userResponse.setPageActionList(pageActionList);

        return userResponse;
    }

    public String encrypt(String strToEncrypt, String myKey) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String myKey) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public BaseResponse getUserProfile(String token) {
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        if ( checkBaseToken(token)) {
            User user = userRepository.findByToken(token);
            Group group = groupRepository.findByIdGroup(user.getIdGroup());
            if (user == null) {
                userProfileResponse.setCode("201");
                userProfileResponse.setMessage("No user could be found!");
            } else if (group == null) {
                userProfileResponse.setCode("202");
                userProfileResponse.setMessage("No user's group could be found!");
            } else {
                userProfileResponse.setCode("200");
                userProfileResponse.setMessage(" Get user profile  successfully!");
                userProfileResponse.setGroup(group);
                userProfileResponse.setUser(user);
            }
        }
        return userProfileResponse;
    }

    public BaseResponse editUserProfile(String token, User user) {
        UserResponse userResponse = new UserResponse();
        if (checkToken(token, "profile.html", "edit")) {
            User userUpdate = userRepository.findByToken(user.getToken());
            userUpdate.setName(user.getName());
            userUpdate.setAddress(user.getAddress());
            userUpdate.setPhone(user.getPhone());
            if (userUpdate != null) {
                userResponse.setCode("200");
                userRepository.save(userUpdate);
                userResponse.setMessage("update successful!");
            } else {
                userResponse.setCode("201");
                userResponse.setMessage("User couldn't be found! have not login yet");
            }
        }
        return userResponse;
    }

    public PersonalRevenueListResponse getUsersWithMostRevenue(String token) {

        PersonalRevenueListResponse personalRevenueListResponse = new PersonalRevenueListResponse();
        if (checkBaseToken(token)) {
            List<Transaction> transactionList;
            List<PersonalRevenue> personalRevenues = new ArrayList<>();
            List<User> userList = userRepository.findAll();
            transactionList = transactionRepository.findAllByStatus("Đã thanh toán");
            for (User user : userList) {
                long money = 0;
                PersonalRevenue personalRevenue = new PersonalRevenue();
                for (Transaction transaction : transactionList) {
                    if (user.getIdUser() == transaction.getIdUser() && (isLastMonth(transaction.getTransactionTime()))) {
                        Product product = productRepository.findByIdProduct(transaction.getIdProduct());
                        money += product.getPrice();
                    }
                }
                personalRevenue.setUser(user);
                personalRevenue.setRevenue(money);
                personalRevenues.add(personalRevenue);
            }
            personalRevenueListResponse.setCode("200");
            personalRevenueListResponse.setMessage("get user with most revenue successfully!");
            personalRevenueListResponse.setPersonalRevenueList(sortPersonalRevenueList(personalRevenues));
        }
        return personalRevenueListResponse;
    }

    public List<PersonalRevenue> sortPersonalRevenueList(List<PersonalRevenue> personalRevenues) {
        ArrayList<Long> revenues = new ArrayList<>();
        for (PersonalRevenue p : personalRevenues) {
            if (!revenues.contains(p.getRevenue())) {
                revenues.add(p.getRevenue());
            }
        }
        Collections.sort(revenues);
        List<PersonalRevenue> sortedPersonalRevenueList = new ArrayList<>();
        for (int i = revenues.size() - 1; i >= 0; i--) {
            for (PersonalRevenue p : personalRevenues) {
                if ((revenues.get(i) == p.getRevenue()) && (revenues.get(i) > 0)) {
                    sortedPersonalRevenueList.add(p);
                 //   System.out.println(p.getUser().getName() + ": " + p.getRevenue());
                }
            }
        }
        return sortedPersonalRevenueList;
    }

    public boolean isLastMonth(Date date) {
        Date currentDate = new Date();
        if ((date.getMonth() == (currentDate.getMonth() - 1)) && (date.getYear() == currentDate.getYear())) {
            return true;
        } else {
            return false;
        }
    }

    public BaseResponse checkTokenWeb(String token) {
        BaseResponse baseResponse = new BaseResponse();
        token = token.replace("Bearer ", "");
        User user = userRepository.findByToken(token);
      //  System.out.println(token);
        if(user == null){
            baseResponse.setCode("999");
            baseResponse.setMessage("replace login");
        }else {
            baseResponse.setCode("200");
            baseResponse.setMessage("success !");
        }

        return  baseResponse;
    }
}
