import java.util.Random;

public class Experiment {

    private long lastBfsTime;
    private long lastDfsTime;

    public void runTraversals(Graph g) {
        long start = System.nanoTime();
        g.bfs(0);
        long end = System.nanoTime();
        lastBfsTime = end - start;

        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        lastDfsTime = end - start;

        printResults();
    }

    public void printResults() {
        System.out.println("Execution Times:");
        System.out.println("- BFS: " + lastBfsTime + " ns");
        System.out.println("- DFS: " + lastDfsTime + " ns");
        System.out.println("------------------------------------");
    }

    public void runMultipleTests() {
        System.out.println("=== 1. SMALL GRAPH (10 Vertices) ===");
        Graph smallGraph = generateRandomGraph(10, 15);
        smallGraph.printGraph();
        runTraversals(smallGraph);

        System.out.println("\n=== 2. MEDIUM GRAPH (30 Vertices) ===");
        Graph mediumGraph = generateRandomGraph(30, 60);
        runTraversals(mediumGraph);

        System.out.println("\n=== 3. LARGE GRAPH (100 Vertices) ===");
        Graph largeGraph = generateRandomGraph(100, 300);
        runTraversals(largeGraph);
    }

    private Graph generateRandomGraph(int verticesCount, int edgesCount) {
        Graph g = new Graph();
        for (int i = 0; i < verticesCount; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        int addedEdges = 0;
        while (addedEdges < edgesCount) {
            int u = rand.nextInt(verticesCount);
            int v = rand.nextInt(verticesCount);
            if (u != v) {
                g.addEdge(u, v);
                addedEdges++;
            }
        }
        return g;
    }
}