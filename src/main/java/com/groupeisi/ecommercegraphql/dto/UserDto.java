package com.groupeisi.ecommercegraphql.dto;
import com.groupeisi.ecommercegraphql.entities.Role;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Setter @Getter
public class UserDto{
       private Long id;
       @NotEmpty(message = "Email est obligatoire")
       private String email;
       private  String nom;
       private String password;
       private Boolean actived;
       private Role roleDto;

}
