package portfolio.project.bookingapp.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import portfolio.project.bookingapp.dto.payment.CanceledPaymentResponseDto;
import portfolio.project.bookingapp.dto.payment.PaymentRequestDto;
import portfolio.project.bookingapp.dto.payment.PaymentResponseDto;
import portfolio.project.bookingapp.model.User;

public interface PaymentService {
    Page<PaymentResponseDto> getPayments(User user, Long userId, Pageable pageable);

    PaymentResponseDto createPayment(@Valid PaymentRequestDto request, Long userId);

    PaymentResponseDto processSuccessfulPayment(String sessionId);

    CanceledPaymentResponseDto processCanceledPayment(String sessionId);

    PaymentResponseDto renewPaymentSession(Long paymentId);
}
