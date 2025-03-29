package portfolio.project.bookingapp.dto.userdtos;

import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import portfolio.project.bookingapp.model.role.RoleName;

public record UserRoleUpdateRequestDto(
        @NotEmpty Set<RoleName> roles
) {}
