package com.groupeisi.ecommercegraphql.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class UserDto{
       private Long id;
       @Email(message = "Email est  invalide")
       @NotEmpty(message = "Email est requis!!!")

       private String email;

       private String password;
       private Boolean actived;
       private RoleDto roleDto;

}
