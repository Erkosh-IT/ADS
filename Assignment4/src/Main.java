public class Main {
    public static void main(String[] args) {
        Experiment experiment = new Experiment();
        experiment.runMultipleTests();
        System.out.println("=== BONUS TASK: DIJKSTRA'S ALGORITHM ===\n");
        Graph g = new Graph();
        for (int i = 0; i <= 4; i++) g.addVertex(new Vertex(i));

        g.addEdge(0, 1, 4.0);
        g.addEdge(0, 2, 1.0);
        g.addEdge(2, 1, 2.0);
        g.addEdge(1, 3, 1.0);
        g.addEdge(2, 3, 5.0);
        g.addEdge(3, 4, 3.0);

        g.printGraph();
        g.dijkstra(0);
    }
}
