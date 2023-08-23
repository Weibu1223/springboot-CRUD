package com.example.test.Services;

import com.example.test.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {
    List<User> getallUser();
    User getuserbyId(Integer id);
    int addUser(User user);
    User getuserbyname(String name);
    String  upDatePassword(String name, String password, String newpsw);
    int  deleteUser(Integer id);
}
