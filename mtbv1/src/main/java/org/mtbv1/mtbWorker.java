package org.mtbv1;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class mtbWorker {

    public static void main(String[] args) {

        WorkflowServiceStubs serviceStub = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(serviceStub);

        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(TaskQueues.MTB_TASK_QUEUE);

        worker.registerWorkflowImplementationTypes(mtbWorkflowImpl.class);
        worker.registerActivitiesImplementations(new mtbActivitiesImpl());

        System.out.println("Worker is running and actively polling the Task Queue.");
        System.out.println("To quit, use ^C to interrupt.");


        factory.start();
    }
}
