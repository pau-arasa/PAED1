import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Priority {

    //This function returns the 'amount' of red in an Importance string, as a value from 0 to 10
    public static float getImportance(Task task){
        String importanceStr = task.getImportance();
        float decimalRed = Integer.parseInt(importanceStr.substring(1, 3), 16) / 2.55f;
        float decimalGreen = Integer.parseInt(importanceStr.substring(3, 5), 16) / 2.55f;

        return 3 * (decimalRed - decimalGreen);
    }

    //This function returns the number of days left until the task is due, divided by 10 to reduce its relevance
    public static float getDaysLeft(Task task){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yy");
        LocalDate limitDate = LocalDate.parse(task.getLimit(), formatter);
        LocalDate currentDate = LocalDate.now();

        float daysLeft = ChronoUnit.DAYS.between(currentDate, limitDate) / 10.0f;
        return Math.max(0.0f, daysLeft);
    }


    public static float getPriority(Task task){
        float importance = getImportance(task);

        return ((importance * importance) + (1 - task.getProgress()/100.0f) * task.getTime()) / getDaysLeft(task);
    }
}
