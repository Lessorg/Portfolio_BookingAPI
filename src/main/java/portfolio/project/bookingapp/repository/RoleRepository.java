package portfolio.project.bookingapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.project.bookingapp.model.role.Role;
import portfolio.project.bookingapp.model.role.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
