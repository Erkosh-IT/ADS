import java.util.Arrays;
public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();
    public long measureSortTime(int[] arr, String type) {
        int[] tempArray = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();
        if (type.equalsIgnoreCase("Basic")) {
            sorter.basicSort(tempArray);
        } else if (type.equalsIgnoreCase("Advanced")) {
            sorter.advancedSort(tempArray);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        searcher.search(arr, target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public void run() {
        int[] sizes = {100, 1000, 5000};
        for (int size : sizes) {
            System.out.println("--- Array Size: " + size + " ---");
            int[] data = sorter.generateRandomArray(size);
            int[] sortedData = Arrays.copyOf(data, data.length);
            Arrays.sort(sortedData);
            long t1 = measureSortTime(data, "Basic");
            long t2 = measureSortTime(data, "Advanced");
            System.out.println("Bubble Sort Time: " + t1 + " ns");
            System.out.println("Quick Sort Time: " + t2 + " ns");
            int target = sortedData[size / 2];
            long t3 = measureSearchTime(sortedData, target);
            System.out.println("Binary Search Time: " + t3 + " ns");
            System.out.println();
        }
    }
}