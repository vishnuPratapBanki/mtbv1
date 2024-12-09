package org.mtbv1;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface mtbActivities {
    @ActivityMethod
    void searchMovie(String movieId, String showtime);
    @ActivityMethod
    void selectSeat(String seatNumber);
    @ActivityMethod
    boolean processPayment(String paymentDetails);
    @ActivityMethod
    void sendConfirmation(String userEmail);
}
