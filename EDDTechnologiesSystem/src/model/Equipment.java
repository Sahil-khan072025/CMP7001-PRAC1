package model;

public class Equipment {
    private String equipmentId;
    private String customerId;
    private String name;
    private String type;
    private String issueDescription;

    public Equipment(String equipmentId, String customerId, String name, String type, String issueDescription) {
        this.equipmentId = equipmentId;
        this.customerId = customerId;
        this.name = name;
        this.type = type;
        this.issueDescription = issueDescription;
    }

    // ==== Getters ====

    public String getEquipmentId() {
        return equipmentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    @Override
    public String toString() {
        return "Equipment ID: " + equipmentId +
               ", Name: " + name +
               ", Type: " + type +
               ", Issue: " + issueDescription +
               ", Customer ID: " + customerId;
    }
}
