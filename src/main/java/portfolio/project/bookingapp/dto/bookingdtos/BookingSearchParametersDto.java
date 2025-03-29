package portfolio.project.bookingapp.dto.bookingdtos;

import portfolio.project.bookingapp.model.booking.BookingStatus;

public record BookingSearchParametersDto(
        Long userId,
        BookingStatus status
) {
}
