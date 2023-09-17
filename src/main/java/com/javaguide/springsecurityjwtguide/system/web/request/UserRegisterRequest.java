package com.javaguide.springsecurityjwtguide.system.web.request;

import com.javaguide.springsecurityjwtguide.system.entity.User;
import com.javaguide.springsecurityjwtguide.system.validator.FullName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @FullName
    @NotBlank
    private String fullName;

    public User toUser() {
        return User.builder().fullName(this.getFullName())
                .userName(this.getUserName())
                .enabled(true).build();
    }
}
