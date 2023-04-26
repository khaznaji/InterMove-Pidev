package com.example.intermove.Controllers.User;



import com.example.intermove.Entities.User.Role;
import com.example.intermove.Entities.User.User;
import com.example.intermove.Entities.User.roletype;
import com.example.intermove.Repositories.User.IRoleRepository;
import com.example.intermove.Repositories.User.UserRepository;
import com.example.intermove.Security.AuthenticationRequest;
import com.example.intermove.Security.AuthenticationResponse;
import com.example.intermove.Security.RegisterRequest;
import com.example.intermove.Services.UserService.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@Qualifier("authenticationController")
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        User user = new User();
        user.setCin(request.getCin());
        user.setAddress(request.getAddress());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setPhone(request.getPhone());
        user.setProfilepicture(request.getProfilepicture());
        Set<Role> strRoles = request.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role patient = roleRepository.findByroletype(roletype.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(patient);
            user.setRoles(roles);
        }


            userRepository.save(user);
        return ResponseEntity.ok("authenticationService.register(request)");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
