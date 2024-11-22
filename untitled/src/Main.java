import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        int numberTasks;
        int i;
        char file;
        int option;
        Scanner scanner = new Scanner(System.in);
        String filePath = "";


        System.out.println("Select which file you want to use:\n\t[A]: ascending\t[D]: descending\t[R]: random");
        file = scanner.next().charAt(0);
        if (file == 'A') {
            filePath = "datasets/ascending.paed";   //ascending; ascendingSmall; descending; descendingSmall; random; randomSmall (FILES AVAILABLE
        }
        if (file == 'D') {
            filePath = "datasets/descending.paed";   //ascending; ascendingSmall; descending; descendingSmall; random; randomSmall (FILES AVAILABLE
        }
        if (file == 'R') {
            filePath = "datasets/random.paed";   //ascending; ascendingSmall; descending; descendingSmall; random; randomSmall (FILES AVAILABLE
        }


        try {
            System.out.println("Attempting to read file: " + filePath);
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            System.out.println("Lines read: " + lines.size());
            numberTasks = Integer.parseInt(lines.get(0).trim());
            System.out.println(numberTasks);

            // Read the lines after the number of task
            for (i = 1; i < lines.size(); i++) {


                String[] aux = lines.get(i).split(";");
                String name = aux[0].trim();
                String limit = aux[1].trim();
                int time = Integer.parseInt(aux[2].trim());
                int difficulty = Integer.parseInt(aux[3].trim());
                int priority = Integer.parseInt(aux[4].trim());
                String importance = aux[5].trim();
                String description = aux[6].trim();

                Task task = new Task(name, limit, time, difficulty, priority, importance, description);
                tasks.add(task);
            }

            /* Mostrar todas las tareas
            System.out.println("Tasks loaded from file:");
            for (Task task : tasks) {
                System.out.println(task);
            }*/
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        do {
            System.out.println("\n Available methods:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Merge Sort");
            System.out.println("4. Quick Sort");
            //System.out.println("3. Show tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Insertion Sort");
                    long startInsertion = System.nanoTime();
                    SortingUtils.insertionSort(tasks);
                    long endInsertion = System.nanoTime();
                    System.out.println("Time: " + ((endInsertion - startInsertion)/1000000) + "ms in " + file + " mode.");
                    break;

                case 2:
                    System.out.println("Selection Sort");
                    long startSelection = System.nanoTime();
                    SortingUtils.insertionSort(tasks);
                    long endSelection = System.nanoTime();
                    System.out.println("Time: " + ((endSelection - startSelection)/1000000) + "ms in " + file + " mode.");
                    break;
                case 3:
                    System.out.println("Merge Sort");
                    long startMerge = System.nanoTime();
                    SortingUtils.mergeSort(tasks, 0, 999);
                    long endMerge = System.nanoTime();
                    System.out.println("Time: " + ((endMerge - startMerge)/1000000) + "ms in " + file + " mode.");
                    break;
                case 4:
                    System.out.println("Quick Sort");
                    long startQuick = System.nanoTime();
                    SortingUtils.insertionSort(tasks);
                    long endQuick = System.nanoTime();
                    System.out.println("Time: " + ((endQuick - startQuick)/1000000) + "ms in " + file + " mode.");
                    break;
            }
        } while (option != 5);
    }
}