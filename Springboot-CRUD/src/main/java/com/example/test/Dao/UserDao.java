package com.example.test.Dao;

import com.example.test.bean.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface UserDao {
    @Select("select * from  users")
    public List<User>getallUser();

    @Select("select * from  users  where  id= #{id}")
    public User getuserbyId(Integer id);

    @Insert("insert into users (name,password, age ,sex) values (#{name},#{password},#{age},#{sex})")
    int addUser(User user);

    @Select("select * from  users  where  name= #{name}")
    public User getuserbyname(String name);

    @Update("update  users set password =#{password}  where  name= #{name}")
    public  int  upDatePassword(@Param("name") String name,
                                @Param("password") String password);
    @Delete("delete from users WHERE id = #{id}")
    int  deleteUser(@Param("id")Integer id);
}
