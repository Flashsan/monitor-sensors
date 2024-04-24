package by.agsr.monitorsensors.dto.authorization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
//    @NotEmpty
//    @Email
    private String username;
//    @NotEmpty
//    @Size(min = 6)
    private String password;

}
