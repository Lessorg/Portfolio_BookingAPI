package portfolio.project.bookingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.project.bookingapp.dto.userdtos.UserLoginRequestDto;
import portfolio.project.bookingapp.dto.userdtos.UserLoginResponseDto;
import portfolio.project.bookingapp.dto.userdtos.UserRegistrationRequestDto;
import portfolio.project.bookingapp.dto.userdtos.UserResponseDto;
import portfolio.project.bookingapp.service.impl.JwtAuthenticationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Endpoints for user registration and authentication")
public class AuthenticationController {
    private final JwtAuthenticationService jwtAuthenticationService;

    @Operation(summary = "Register a new user",
            description = "Creates a new user account with the provided registration details")
    @PostMapping("/register")
    public UserResponseDto register(@Valid @RequestBody UserRegistrationRequestDto request) {
        return jwtAuthenticationService.register(request);
    }

    @Operation(summary = "User login",
            description = "Authenticates the user and returns a JWT token")
    @PostMapping("/login")
    public UserLoginResponseDto login(@Valid @RequestBody UserLoginRequestDto request) {
        return jwtAuthenticationService.authenticate(request);
    }
}
