# Assignment 3: Sorting and Searching Algorithm Analysis System
**Student:** Yerkebulan Korganbek  
**Group:** IT - 2501
## Introduction
The goal of this project is to implement, measure, and compare the performance of various fundamental algorithms. This system analyzes two sorting algorithms (Basic and Advanced) and one searching algorithm to understand their efficiency in practice versus their theoretical Big-O complexity.

## Selected Algorithms

### 1. Bubble Sort (Basic Sorting)
Bubble Sort is a simple comparison-based algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated until the entire list is sorted.
- **Why it was chosen:** It is the most intuitive example of an $O(n^2)$ algorithm, making it a perfect baseline for performance comparison.

### 2. Quick Sort (Advanced Sorting)
Quick Sort is a highly efficient, divide-and-conquer algorithm. It works by selecting a 'pivot' element and partitioning the array into two sub-arrays: elements less than the pivot and elements greater than the pivot. These sub-arrays are then sorted recursively.
- **Why it was chosen:** It is one of the fastest sorting algorithms in practice for large datasets.

### 3. Binary Search (Searching)
Binary Search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item until you've narrowed down the possible locations to just one.
- **Why it was chosen:** It demonstrates the massive efficiency gain of logarithmic time complexity compared to linear searching.

---

## Algorithm Complexity Analysis

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity |
|-----------|-----------|--------------|------------|------------------|
| Bubble Sort | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ |
| Quick Sort | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | $O(\log n)$ |
| Binary Search| $O(1)$ | $O(\log n)$ | $O(\log n)$ | $O(1)$ |

---

## Performance Analysis

### Experimental Setup
- **Environment:** Java JDK 17 (or your version)
- **Timer:** `System.nanoTime()`
- **Data Sizes:** 100, 1000, and 5000 elements.
- **Data Types:** Randomly generated integers and pre-sorted arrays.

### Results Table

| Array Size | Bubble Sort (ns) | Quick Sort (ns) | Binary Search (ns) |
|------------|------------------|-----------------|--------------------|
| 100        |            288100 ns      |    47500 ns             |       3800 ns             |
| 1000       |       5163900 ns           |    390500 ns             |      2400 ns              |
| 5000       |      12934800 ns            |     403700 ns            |       2000 ns              |

### Screenshots
<img width="1203" height="316" alt="Result" src="https://github.com/user-attachments/assets/5bb6ba89-1fda-46a9-9650-d8d2b4626d97" />

---

## Comparative Analysis and Reflection

### 1. Which sorting algorithm performed better?
Based on the results, **Quick Sort** significantly outperformed Bubble Sort as the array size increased. While the difference was small for 100 elements, at 5000 elements, Quick Sort was orders of magnitude faster. This confirms the theoretical advantage of $O(n \log n)$ over $O(n^2)$.

### 2. Random vs. Sorted Data
Bubble Sort performed slightly better on already sorted data (especially if optimized with a flag), but its performance remained poor compared to Quick Sort. Quick Sort handled random data exceptionally well, though its performance can theoretically degrade on sorted data depending on the pivot selection strategy.

### 3. Search Efficiency
Binary Search proved to be nearly instantaneous even for the largest array size. This highlights why keeping data sorted is crucial for high-performance systems—it allows us to switch from $O(n)$ linear search to $O(\log n)$ binary search.

### 4. Personal Reflection
Through this assignment, I learned that theoretical complexity (Big-O) is a very accurate predictor of how an algorithm will behave as data grows. Implementing these algorithms from scratch helped me understand the importance of choosing the right data structures. The biggest challenge was ensuring the `Experiment` class correctly handled array copies so that the sorting process wouldn't be affected by previous runs.
