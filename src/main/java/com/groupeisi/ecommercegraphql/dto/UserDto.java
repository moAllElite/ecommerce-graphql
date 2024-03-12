package com.groupeisi.ecommercegraphql.dto;
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

       @NotEmpty(message = "Email est obligatoire")
       private String email;
       private String password;
       private Boolean actived;
       private RoleDto roleDto;

}
