package com.example.springRestAPI.user;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo") // 컨트롤러 호출시 필터 사용해야 오류가 발생하지않음
public class User {

    private Integer id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요")
    private String name;

    @Past
    private Date joinDate;

    //    @JsonIgnore
    private String password;

    //    @JsonIgnore
    private String ssn;
}
