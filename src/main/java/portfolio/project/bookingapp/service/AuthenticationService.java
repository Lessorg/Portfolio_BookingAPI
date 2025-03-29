package portfolio.project.bookingapp.service;

import portfolio.project.bookingapp.dto.userdtos.UserLoginRequestDto;
import portfolio.project.bookingapp.dto.userdtos.UserLoginResponseDto;
import portfolio.project.bookingapp.dto.userdtos.UserRegistrationRequestDto;
import portfolio.project.bookingapp.dto.userdtos.UserResponseDto;
import portfolio.project.bookingapp.dto.userdtos.UserRoleUpdateRequestDto;
import portfolio.project.bookingapp.dto.userdtos.UserRoleUpdateResponseDto;
import portfolio.project.bookingapp.dto.userdtos.UserUpdateRequestDto;
import portfolio.project.bookingapp.exception.RegistrationException;
import portfolio.project.bookingapp.model.User;

public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto request);

    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;

    UserRoleUpdateResponseDto updateUserRole(Long id, UserRoleUpdateRequestDto request);

    UserResponseDto getUserProfile(Long userId);

    UserResponseDto updateUserProfile(Long userId, UserUpdateRequestDto request);

    User findUserById(Long id);

    User findUserByUsername(String username);
}
