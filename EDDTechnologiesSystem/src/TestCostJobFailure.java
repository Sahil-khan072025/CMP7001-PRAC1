import model.RepairJob;
import utils.CSVUtil;

import java.util.List;

public class TestCostJobFailure {
    public static void main(String[] args) {
        String fakeJobId = "INVALID_JOB";
        List<RepairJob> jobs = CSVUtil.loadJobsFromCSV();

        boolean exists = jobs.stream().anyMatch(j -> j.getJobId().equalsIgnoreCase(fakeJobId));

        if (!exists) {
            System.out.println("✅ TestCostJobFailure: Passed (Job not found as expected)");
        } else {
            System.out.println("❌ TestCostJobFailure: Failed (Job should not exist)");
        }
    }
}
