package portfolio.project.bookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.project.bookingapp.model.accommodation.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
