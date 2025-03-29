package portfolio.project.bookingapp.dto.accommodationdtos;

import java.math.BigDecimal;
import java.util.List;
import portfolio.project.bookingapp.model.accommodation.AccommodationType;

public record AccommodationResponseDto(
        Long id,
        AccommodationType type,
        String location,
        String size,
        List<String> amenities,
        BigDecimal dailyRate,
        Integer availability
) {
}
