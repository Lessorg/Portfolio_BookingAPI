package portfolio.project.bookingapp.dto.userdtos;

import java.util.Set;
import portfolio.project.bookingapp.model.role.RoleName;

public record UserRoleUpdateResponseDto(Long userId, Set<RoleName> roles) {}
