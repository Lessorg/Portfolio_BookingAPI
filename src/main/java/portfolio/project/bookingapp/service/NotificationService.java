package portfolio.project.bookingapp.service;

import portfolio.project.bookingapp.model.payment.Payment;

public interface NotificationService {
    void sendNotification(String message);

    void sendPaymentSuccessNotification(Payment payment);

    void checkExpiredBookings();
}
