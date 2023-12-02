package com.worldwork.beworldwork.dto;

import com.worldwork.beworldwork.entities.Role;
import com.worldwork.beworldwork.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    public UserDTO(User user) {
        this.id = user.getUser_id();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.address = user.getAddress();
        this.phone = user.getPhone();
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String address;
    private String phone;
}
