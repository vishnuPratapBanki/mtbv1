package org.mtbv1;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import java.util.UUID;

public class mtbApp {

    public static void main(String[] args) {
        WorkflowServiceStubs serviceStub = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(serviceStub);


        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(TaskQueues.MTB_TASK_QUEUE)
                .setWorkflowId("mtb-workflow")
                .build();


        mtbWorkflow workflow = client.newWorkflowStub(mtbWorkflow.class, options);
        WorkflowExecution we = WorkflowClient.start(workflow::bookTicket, "MOVIE123", "7:00 PM", "A5", "user@example.com");

        System.out.printf("Workflow started successfully!");
    }
}
