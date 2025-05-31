package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionLogger {

    private static final String LOG_FILE = "data/error_log.txt";

    public static void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write("[" + LocalDateTime.now() + "] " + e.getClass().getSimpleName() + ": " + e.getMessage());
            writer.newLine();
            for (StackTraceElement element : e.getStackTrace()) {
                writer.write("\tat " + element.toString());
                writer.newLine();
            }
            writer.newLine();
        } catch (IOException ioException) {
            System.err.println("Unable to log exception: " + ioException.getMessage());
        }
    }
}
