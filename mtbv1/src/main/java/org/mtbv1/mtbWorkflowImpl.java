package org.mtbv1;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class mtbWorkflowImpl implements mtbWorkflow {

    // Activity Stub for invoking activity methods
    private final mtbActivities activities = Workflow.newActivityStub(
            mtbActivities.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofMinutes(1))
                    .build()
    );

    @Override
    public void bookTicket(String movieId, String showtime, String seatNumber, String userEmail) {
        // Step 1: Search for the movie and showtime
        activities.searchMovie(movieId, showtime);

        // Step 2: Select the seat
        activities.selectSeat(seatNumber);

        // Step 3: Process the payment
        boolean paymentSuccessful = activities.processPayment("MOCK_PAYMENT_DETAILS");
        if (!paymentSuccessful) {
            Workflow.getLogger(mtbWorkflowImpl.class).error("Payment failed!");
            throw new RuntimeException("Payment failed!");
        }

        // Step 4: Send a confirmation
        activities.sendConfirmation(userEmail);
    }
}

