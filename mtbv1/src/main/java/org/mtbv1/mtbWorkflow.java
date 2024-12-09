package org.mtbv1;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface mtbWorkflow {
    @WorkflowMethod
    void bookTicket(String movieId, String showtime, String seatNumber, String userEmail);
}

