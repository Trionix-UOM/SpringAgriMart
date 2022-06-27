package com.trionix.agrimartorder.dto;

import lombok.Data;
import org.checkerframework.common.value.qual.MinLen;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data

public class SignupDto {
        @NotEmpty
        private String fullName;
        @NotEmpty
        @MinLen(8)
        private String password;
        private String phoneNo;
        @Email
        private String email;
        private String address;
        private String gender;
}
