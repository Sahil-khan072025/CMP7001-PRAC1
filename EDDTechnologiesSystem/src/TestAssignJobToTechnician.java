import model.RepairJob;
import utils.CSVUtil;

public class TestAssignJobToTechnician {
    public static void main(String[] args) {
        // Create a dummy job with assumed equipment and technician IDs
        RepairJob job = new RepairJob("J999", "E001", "T001");

        try {
            CSVUtil.saveJobToCSV(job);
            System.out.println("✅ TestAssignJobToTechnician: Passed");
        } catch (Exception e) {
            System.out.println("❌ TestAssignJobToTechnician: Failed");
            e.printStackTrace();
        }
    }
}
