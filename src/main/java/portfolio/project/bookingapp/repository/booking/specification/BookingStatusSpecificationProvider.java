package portfolio.project.bookingapp.repository.booking.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import portfolio.project.bookingapp.model.booking.Booking;
import portfolio.project.bookingapp.repository.booking.SpecificationProvider;

@Component
public class BookingStatusSpecificationProvider implements SpecificationProvider<Booking> {
    private static final String STATUS_COLUMN_NAME = "status";

    @Override
    public String getKey() {
        return STATUS_COLUMN_NAME;
    }

    @Override
    public Specification<Booking> getSpecification(String[] params) {
        return (root, query, cb) -> root.get(STATUS_COLUMN_NAME)
                .in((Object[]) params);
    }
}
