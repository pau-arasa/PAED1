import java.awt.*;
import java.util.ArrayList;

public class SortingUtils {

    public static void swap(ArrayList<Task> tasks, int i, int j) {
        Task temp = tasks.get(i);
        tasks.set(i, tasks.get(j));
        tasks.set(j, temp);
    }

    public static void selectionSort(ArrayList<Task> tasks) {
        int i=0, min=0, j=0;
        //int n = tasks.size();
        int n = 1000;

        for(i=0; i < n-1; i++) {
            min = i;
            for(j=i+1; j < n; j++) {
                if(tasks.get(j).getName().compareTo(tasks.get(min).getName()) < 0 ){
                    min = j;
                }
            }
            if (i != min){
                swap(tasks, i, min);
            }
        }
    }




    public static void insertionSort(ArrayList<Task> tasks) {
        int n;
        int i, j;
        //n = tasks.size();
        n = 1000;
        for (i = 1; i < n; i++) {
            j = i;
            while (j > 0 && tasks.get(j).getName().compareTo(tasks.get(j - 1).getName()) < 0) {
                swap(tasks, j, j - 1);
                j--;
            }

        }

    }


    public static void mergeSort(ArrayList<Task> tasks, int i, int j) {

        int half;

        if (i < j) {
            half = (i + j) / 2;
            mergeSort(tasks, i, half);
            mergeSort(tasks, half + 1, j);
            merge(tasks, i, half, j);

        }
    }

    public static void merge(ArrayList<Task> tasks, int i,int half, int j) {
        ArrayList<Task> aux = new ArrayList<>(tasks);
        int left;
        int right;
        int cursor;

        left = i;
        right = half;
        cursor = i;

        do {
            if (Priority.getPriority(tasks.get(left)) <= Priority.getPriority(tasks.get(right))) {
                aux.set(cursor, tasks.get(left));
                left++;
            }
            else {
                aux.set(cursor, tasks.get(right));
                right++;
            }
            cursor++;
        } while (left <= half && right <= j);

        do {
            aux.set(cursor, tasks.get(left));
            left++;
            cursor++;
        } while (left <= half);

        do {
            aux.set(cursor, tasks.get(right));
            right++;
            cursor++;
        } while (right <= j);

        cursor = i;

        do {
            aux.set(cursor, tasks.get(cursor));
            cursor++;
        } while (cursor <= j);
    }
    public static int partition(ArrayList<Task> tasks, int i, int j){
        int left = i, right = j;
        int half = (i+j)/2;
        float pivot = Priority.getPriority(tasks.get(i));

        while(true){
            while(Priority.getPriority(tasks.get(left)) < pivot){
                left++;
            }
            while(Priority.getPriority(tasks.get(right)) > pivot){
                right--;
            }
            if ( left >= right){
                return right;
            }
            swap(tasks, left, right);
            left++;
            right--;
        }
    }

    public static void quickSort(ArrayList<Task> tasks, int i, int j){
        if (i < j){
            int p = partition(tasks, i, j);
            quickSort(tasks, i, p);
            quickSort(tasks, p + 1, j);
        }
    }
}

