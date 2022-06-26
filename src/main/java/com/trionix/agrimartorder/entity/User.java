package com.trionix.agrimartorder.entity;

import com.trionix.agrimartorder.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // Same as firebase user id
    @Id
    private String id;
    private String fullName;
    private String email;
    private Role role;
    private String phoneNo;
    private String address;
    private String gender;


}
