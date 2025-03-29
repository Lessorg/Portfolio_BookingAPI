package portfolio.project.bookingapp.repository.booking.specification;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import portfolio.project.bookingapp.model.booking.Booking;
import portfolio.project.bookingapp.repository.booking.SpecificationProvider;
import portfolio.project.bookingapp.repository.booking.SpecificationProviderManager;

@RequiredArgsConstructor
@Component
public class BookingSpecificationProviderManager implements SpecificationProviderManager<Booking> {
    private final List<SpecificationProvider<Booking>> bookingSpecificationProviders;

    @Override
    public SpecificationProvider<Booking> getSpecificationProvider(String key) {
        return bookingSpecificationProviders.stream()
                .filter(provider -> provider.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No specification provider found for key: "
                        + key));
    }
}
