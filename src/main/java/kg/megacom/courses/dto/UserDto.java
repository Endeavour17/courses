package kg.megacom.courses.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class UserDto {
    private Long id;
    private String fio;
    private String login;
    private String password;
    private RoleDto role;
}
