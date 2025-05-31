package utils;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    private static final String CUSTOMER_FILE = "data/customers.csv";
    private static final String TECHNICIAN_FILE = "data/technicians.csv";
    private static final String ADMIN_FILE = "data/admins.csv";
    private static final String EQUIPMENT_FILE = "data/equipment.csv";
    private static final String JOB_FILE = "data/jobs.csv";
    private static final String SUPPLIER_FILE = "data/suppliers.csv";
    private static final String NOTIFICATION_FILE = "data/notifications.csv";

    // ==============================
    // INITIALIZE EMPTY CSV FILES
    // ==============================
    public static void initializeCSVFiles() {
        createFileIfNotExists(CUSTOMER_FILE);
        createFileIfNotExists(TECHNICIAN_FILE);
        createFileIfNotExists(ADMIN_FILE);
        createFileIfNotExists(EQUIPMENT_FILE);
        createFileIfNotExists(JOB_FILE);
        createFileIfNotExists(SUPPLIER_FILE);
        createFileIfNotExists(NOTIFICATION_FILE);
    }

    private static void createFileIfNotExists(String path) {
        try {
            File file = new File(path);
            file.getParentFile().mkdirs();
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating file: " + path);
        }
    }

    // ==============================
    // CUSTOMERS
    // ==============================
    public static List<Customer> loadCustomersFromCSV() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 5) {
                    customers.add(new Customer(t[0], t[1], t[2], t[3], Boolean.parseBoolean(t[4])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading customers: " + e.getMessage());
        }
        return customers;
    }

    public static void saveCustomerToCSV(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_FILE, true))) {
            writer.write(String.join(",", customer.getUserId(), customer.getName(), customer.getEmail(), customer.getPhoneNumber(), String.valueOf(customer.isRegistered())));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving customer: " + e.getMessage());
        }
    }

    // ==============================
    // TECHNICIANS
    // ==============================
    public static List<Technician> loadTechniciansFromCSV() {
        List<Technician> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TECHNICIAN_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 5) {
                    list.add(new Technician(t[0], t[1], t[2], t[3], t[4]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading technicians: " + e.getMessage());
        }
        return list;
    }

    public static void saveTechnicianToCSV(Technician t) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TECHNICIAN_FILE, true))) {
            writer.write(String.join(",", t.getUserId(), t.getName(), t.getEmail(), t.getPhoneNumber(), t.getSpecialization()));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving technician: " + e.getMessage());
        }
    }

    // ==============================
    // ADMINS
    // ==============================
    public static List<Admin> loadAdminsFromCSV() {
        List<Admin> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 4) {
                    list.add(new Admin(t[0], t[1], t[2], t[3]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading admins: " + e.getMessage());
        }
        return list;
    }

    public static void saveAdminToCSV(Admin a) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ADMIN_FILE, true))) {
            writer.write(String.join(",", a.getUserId(), a.getName(), a.getEmail(), a.getPhoneNumber()));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving admin: " + e.getMessage());
        }
    }

    // ==============================
    // EQUIPMENT
    // ==============================
    public static List<Equipment> loadEquipmentFromCSV() {
        List<Equipment> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(EQUIPMENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 5) {
                    list.add(new Equipment(t[0], t[1], t[2], t[3], t[4]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading equipment: " + e.getMessage());
        }
        return list;
    }

    public static void saveEquipmentToCSV(Equipment e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EQUIPMENT_FILE, true))) {
            writer.write(String.join(",", e.getEquipmentId(), e.getCustomerId(), e.getName(), e.getType(), e.getIssueDescription()));
            writer.newLine();
        } catch (IOException ex) {
            System.err.println("Error saving equipment: " + ex.getMessage());
        }
    }

    // ==============================
    // REPAIR JOBS
    // ==============================
    public static List<RepairJob> loadJobsFromCSV() {
        List<RepairJob> jobs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(JOB_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 5) {
                    RepairJob job = new RepairJob(t[0], t[1], t[2]);
                    job.setStatus(t[3]);
                    job.setTotalCost(Double.parseDouble(t[4]));
                    jobs.add(job);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading jobs: " + e.getMessage());
        }
        return jobs;
    }

    public static void saveJobToCSV(RepairJob job) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOB_FILE, true))) {
            writer.write(String.join(",", job.getJobId(), job.getEquipmentId(), job.getTechnicianId(), job.getStatus(), String.valueOf(job.getTotalCost())));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving job: " + e.getMessage());
        }
    }

    public static void updateJobInCSV(RepairJob updatedJob) {
        List<RepairJob> jobs = loadJobsFromCSV();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOB_FILE, false))) {
            for (RepairJob job : jobs) {
                if (job.getJobId().equals(updatedJob.getJobId())) {
                    job = updatedJob;
                }
                writer.write(String.join(",", job.getJobId(), job.getEquipmentId(), job.getTechnicianId(), job.getStatus(), String.valueOf(job.getTotalCost())));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error updating job: " + e.getMessage());
        }
    }

    // ==============================
    // SUPPLIERS
    // ==============================
    public static List<Supplier> loadSuppliersFromCSV() {
        List<Supplier> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SUPPLIER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 5) {
                    list.add(new Supplier(t[0], t[1], t[2], t[3], t[4]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading suppliers: " + e.getMessage());
        }
        return list;
    }

    public static void saveSupplierToCSV(Supplier s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SUPPLIER_FILE, true))) {
            writer.write(String.join(",", s.getSupplierId(), s.getName(), s.getLocation(), s.getEmail(), s.getPhone()));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving supplier: " + e.getMessage());
        }
    }

    // ==============================
    // NOTIFICATIONS
    // ==============================
    public static void saveNotificationToCSV(Notification n) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTIFICATION_FILE, true))) {
            writer.write(String.join(",", n.getNotificationId(), n.getRecipientId(), n.getMessage(), n.getTimestamp().toString(), String.valueOf(n.isRead())));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving notification: " + e.getMessage());
        }
    }
}
