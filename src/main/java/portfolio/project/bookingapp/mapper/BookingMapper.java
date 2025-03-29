package portfolio.project.bookingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import portfolio.project.bookingapp.config.MapperConfig;
import portfolio.project.bookingapp.dto.bookingdtos.BookingRequestDto;
import portfolio.project.bookingapp.dto.bookingdtos.BookingResponseDto;
import portfolio.project.bookingapp.model.User;
import portfolio.project.bookingapp.model.accommodation.Accommodation;
import portfolio.project.bookingapp.model.booking.Booking;
import portfolio.project.bookingapp.model.booking.BookingStatus;

@Mapper(config = MapperConfig.class)
public interface BookingMapper {
    @Mapping(source = "accommodation.id", target = "accommodationId")
    @Mapping(source = "user.id", target = "userId")
    BookingResponseDto toBookingResponseDto(Booking booking);

    @Mapping(target = "id", ignore = true)
    Booking toBookingEntity(BookingRequestDto request,
                            User user,
                            Accommodation accommodation,
                            BookingStatus status);

    @Mapping(source = "request.checkInDate", target = "checkInDate")
    @Mapping(source = "request.checkOutDate", target = "checkOutDate")
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateBookingEntity(@MappingTarget Booking booking, BookingRequestDto request);
}
