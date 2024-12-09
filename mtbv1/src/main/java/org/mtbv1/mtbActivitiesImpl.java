package org.mtbv1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class mtbActivitiesImpl implements mtbActivities {
    private static final Logger logger = LoggerFactory.getLogger(mtbActivitiesImpl.class);

    @Override
    public void searchMovie(String movieId, String showtime) {
        // Mock search logic
        logger.info("Searching for movie with ID '{}' at showtime '{}'.", movieId, showtime);
        // Simulating search success
        logger.info("Movies found for Movie ID '{}' at showtime '{}'.", movieId, showtime);
    }

    @Override
    public void selectSeat(String seatNumber) {
        // Mock seat selection logic
        logger.info("Checking availability for seat '{}'.", seatNumber);
        // Simulating seat reservation
        logger.info("Seat '{}' successfully reserved.", seatNumber);
    }

    @Override
    public boolean processPayment(String paymentDetails) {
        // Mock payment processing logic
        logger.info("Processing payment with details '{}'.", paymentDetails);
        // Simulating payment success
        logger.info("Payment processed successfully.");
        return true; // Return true for successful payment
    }

    @Override
    public void sendConfirmation(String userEmail) {
        // Mock notification sending logic
        logger.info("Sending confirmation email to '{}'.", userEmail);
        // Simulating notification sent
        logger.info("Confirmation email successfully sent to '{}'.", userEmail);
    }
}
