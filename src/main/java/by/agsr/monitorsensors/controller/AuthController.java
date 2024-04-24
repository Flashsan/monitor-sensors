package by.agsr.monitorsensors.controller;

import by.agsr.monitorsensors.config.security.jwt.JwtUtils;
import by.agsr.monitorsensors.dto.authorization.LoginRequest;
import by.agsr.monitorsensors.repository.RoleRepository;
import by.agsr.monitorsensors.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static by.agsr.monitorsensors.controller.util.RestApiPaths.AUTH_API;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH_API)
public class AuthController {

//    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

//        SecurityContextHolder.getContext().setAuthentication(authentication);

//        UserDetailServiceImpl userDetails = (UserDetailImp) authentication.getPrincipal();
//
//        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//
//        List<String> roles = userDetail.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .body(new UserInfoResponse(userDetails.getId(),
//                        userDetails.getUsername(),
//                        userDetails.getEmail(),
//                        roles));

        return null;
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
//        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
//                .body(new MessageResponse("You've been signed out!"));
//                .body(new MessageResponse("You've been signed out!"));
    return null;
    }
}
