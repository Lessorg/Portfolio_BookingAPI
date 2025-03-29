package portfolio.project.bookingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import portfolio.project.bookingapp.config.MapperConfig;
import portfolio.project.bookingapp.dto.payment.CanceledPaymentResponseDto;
import portfolio.project.bookingapp.dto.payment.PaymentResponseDto;
import portfolio.project.bookingapp.model.payment.Payment;

@Mapper(config = MapperConfig.class)
public interface PaymentMapper {

    @Mapping(source = "booking.id", target = "bookingId")
    PaymentResponseDto toPaymentResponseDto(Payment payment);

    @Mapping(source = "payment.id", target = "id")
    @Mapping(source = "payment.status", target = "status")
    @Mapping(source = "payment.sessionUrl", target = "sessionUrl")
    @Mapping(source = "payment.amount", target = "amount")
    @Mapping(source = "payment.booking.id", target = "bookingId")
    @Mapping(source = "message", target = "message")
    CanceledPaymentResponseDto toCanceledPaymentResponseDto(Payment payment, String message);
}
