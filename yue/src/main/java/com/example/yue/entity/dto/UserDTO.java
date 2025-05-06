package com.example.yue.entity.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
//import org.hibernate.validator.constraints.Length;

public class UserDTO {

//    @NotBlank(message="用户名不能为空") // 去除空格
//    @NotEmpty
    private String userName;
    @NotBlank(message="密码不能为空")
//    @Length(min=6,max=12,message="密码长度在6-12位之间")
    private String userPassword;
    @Email(message="邮箱格式错误")
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
