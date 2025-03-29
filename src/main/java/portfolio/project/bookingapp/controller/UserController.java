package portfolio.project.bookingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.project.bookingapp.dto.userdtos.UserResponseDto;
import portfolio.project.bookingapp.dto.userdtos.UserRoleUpdateRequestDto;
import portfolio.project.bookingapp.dto.userdtos.UserRoleUpdateResponseDto;
import portfolio.project.bookingapp.dto.userdtos.UserUpdateRequestDto;
import portfolio.project.bookingapp.model.User;
import portfolio.project.bookingapp.service.impl.JwtAuthenticationService;

@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/users")
@Tag(name = "User", description = "Endpoints for user profile and role management")
public class UserController {
    private final JwtAuthenticationService jwtAuthenticationService;

    @Operation(summary = "Update user roles",
            description = "Allows an admin to update the roles assigned to a user")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/role")
    public UserRoleUpdateResponseDto updateUserRole(
            @PathVariable Long id,
            @Valid @RequestBody UserRoleUpdateRequestDto role) {
        return jwtAuthenticationService.updateUserRole(id, role);
    }

    @Operation(summary = "Get current user profile",
            description = "Retrieves the profile of the currently authenticated user")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/me")
    public UserResponseDto getCurrentUser(Authentication authentication) {
        return jwtAuthenticationService.getUserProfile(getUserId(authentication));
    }

    @Operation(summary = "Update current user profile",
            description = "Allows the currently authenticated user to update their profile details")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @PatchMapping("/me")
    public UserResponseDto updateProfilePatch(
            Authentication authentication,
            @Valid @RequestBody UserUpdateRequestDto request) {
        return jwtAuthenticationService.updateUserProfile(getUserId(authentication), request);
    }

    @Operation(summary = "Update current user profile",
            description = "Allows the currently authenticated user to update their profile details")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @PutMapping("/me")
    public UserResponseDto updateProfilePut(
            Authentication authentication,
            @Valid @RequestBody UserUpdateRequestDto request) {
        return jwtAuthenticationService.updateUserProfile(getUserId(authentication), request);
    }

    private Long getUserId(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user.getId();
    }
}
