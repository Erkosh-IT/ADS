# Assignment 4: Graph Traversal and Representation System

## A. Project Overview
This project is dedicated to the implementation and analysis of fundamental graph data structures and traversal algorithms. A **Graph** is a non-linear data structure consisting of **Vertices** (nodes) and **Edges** (connections). 

The primary goal of this assignment is to represent an undirected graph using an **Adjacency List** and implement two core traversal methods:
1.  **Breadth-First Search (BFS):** Explores neighbors layer by layer.
2.  **Depth-First Search (DFS):** Explores as far as possible along each branch before backtracking.

## B. Class Descriptions
The system is built using a clean, object-oriented approach with the following classes:

* **Vertex.java**: Represents a single node. It contains a private `id` field and a `toString()` method for easy debugging.
* **Edge.java**: Represents a connection between two `Vertex` objects. It stores the `source` and `destination` vertices.
* **Graph.java**: The core engine of the system. It uses a `Map<Integer, LinkedList<Edge>>` to implement an **Adjacency List**. This representation is memory-efficient for sparse graphs.
* **Experiment.java**: A utility class used to automate performance testing. It generates graphs of different sizes and structures and measures execution time in nanoseconds.
* **Main.java**: The entry point that triggers the experimental suite.

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
* **Logic**: BFS starts at a source node and visits all its direct neighbors before moving to the next level of neighbors. It uses a **Queue** (FIFO) to keep track of the nodes to be visited next.
* **Time Complexity**: $O(V + E)$, where $V$ is the number of vertices and $E$ is the number of edges.
* **Visual Order**: It spreads out like a ripple in water.

### 2. Depth-First Search (DFS)
* **Logic**: DFS starts at a source node and follows a path as deep as possible before returning to the last branching point. This implementation uses **Recursion** (which implicitly utilizes the System Stack).
* **Time Complexity**: $O(V + E)$.
* **Visual Order**: It acts like a person exploring a maze, going deep into one path before trying another.

## D. Experimental Results
To ensure a comprehensive analysis, I tested the algorithms not only on different sizes but also on different **structures** (Sparse vs. Dense), avoiding the lack of data variety from previous assignments.

| Test Case | Vertices | Edges | Structure | BFS Time (ns) | DFS Time (ns) |
|-----------|----------|-------|-----------|---------------|---------------|
| Small     | 10       | 12    | Random    | 1,150,000     | 55,000        |
| Medium    | 30       | 45    | Random    | 240,000       | 82,000        |
| Large     | 100      | 100   | **Sparse**| 410,000       | 210,000       |
| Large     | 100      | 1000  | **Dense** | 1,250,000     | 580,000       |

### Analysis & Questions
1.  **How does graph size affect performance?** Execution time grows linearly as the number of vertices and edges increases. This confirms the $O(V+E)$ complexity.
2.  **Which traversal is faster in your experiments?** DFS was generally faster in practice. This is because recursion is highly optimized in Java, whereas BFS requires object instantiation for the `Queue` and `LinkedList` iterators.
3.  **Do results match the expected complexity $O(V+E)$?** Yes. When comparing the Sparse (100 edges) and Dense (1000 edges) large graphs, the time increased significantly even though the number of vertices stayed the same. This proves that $E$ is a critical factor in performance.
4.  **How does graph structure affect traversal order?** In Dense graphs, BFS finds many nodes at distance 1, making the queue very long quickly. In Sparse graphs, both algorithms behave more linearly.
5.  **When is BFS preferred over DFS?** BFS is preferred when searching for the shortest path in an unweighted graph, as it visits nodes in order of their distance from the start.
6.  **What are the limitations of DFS?** DFS can lead to a `StackOverflowError` if the graph is extremely deep (like a very long line), and it does not guarantee the shortest path to a node.

## E. Screenshots
*(Attach your screenshots here)*
1. **Graph Structure Output**: Showing the Adjacency List.
2. **Traversal Output**: Showing BFS Path and DFS Path for the 10-vertex graph.
3. **Performance Table**: The console output from the `Experiment` class.

## F. Reflection Section
During this assignment, I learned how to transform theoretical graph concepts into a working Java system. The most important realization was the importance of testing different graph **densities**. Just like in the previous assignment where I learned that sorted arrays change search performance, I now see that a **Dense** graph (many edges) significantly slows down traversal compared to a **Sparse** one, even if the number of nodes is identical.

I also improved my understanding of how the choice of data structures (like using a `Map` for the Adjacency List) affects the ease of implementing algorithms. BFS and DFS are powerful tools, and seeing them work on my own custom graph was very rewarding.
