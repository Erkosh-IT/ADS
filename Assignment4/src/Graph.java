import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, LinkedList<Edge>> adjList;

    public Graph() {
        vertices = new HashMap<>();
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.put(v.getId(), new LinkedList<>());
    }

    public void addEdge(int from, int to, double weight) {
        Vertex source = vertices.get(from);
        Vertex dest = vertices.get(to);
        if (source != null && dest != null) {
            adjList.get(from).add(new Edge(source, dest, weight));
            adjList.get(to).add(new Edge(dest, source, weight));
        }
    }

    public void printGraph() {
        for (int vId : adjList.keySet()) {
            System.out.print("Vertex " + vId + " connected to: ");
            for (Edge edge : adjList.get(vId)) {
                System.out.print(edge.getDestination().getId() + "[w:" + edge.getWeight() + "] ");
            }
            System.out.println();
        }
    }
    public void bfs(int start) {
        boolean isSmallGraph = vertices.size() <= 10;
        boolean[] visited = new boolean[1000];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        if (isSmallGraph) System.out.print("BFS Order: ");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (isSmallGraph) System.out.print(u + " ");
            for (Edge edge : adjList.get(u)) {
                int neighbor = edge.getDestination().getId();
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        if (isSmallGraph) System.out.println();
    }
    public void dfs(int start) {
        boolean isSmallGraph = vertices.size() <= 10;
        boolean[] visited = new boolean[1000];
        if (isSmallGraph) System.out.print("DFS Order: ");
        dfsHelper(start, visited, isSmallGraph);
        if (isSmallGraph) System.out.println();
    }
    private void dfsHelper(int v, boolean[] visited, boolean isSmallGraph) {
        visited[v] = true;
        if (isSmallGraph) System.out.print(v + " ");
        for (Edge edge : adjList.get(v)) {
            int neighbor = edge.getDestination().getId();
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, isSmallGraph);
            }
        }
    }

    public void dijkstra(int start) {
        if (!vertices.containsKey(start)) return;

        Map<Integer, Double> distances = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        for (Integer vId : vertices.keySet()) {
            distances.put(vId, Double.MAX_VALUE);
            visited.put(vId, false);
        }
        distances.put(start, 0.0);

        for (int i = 0; i < vertices.size(); i++) {

            int u = -1;
            double minDistance = Double.MAX_VALUE;

            for (Integer vId : vertices.keySet()) {
                if (!visited.get(vId) && distances.get(vId) < minDistance) {
                    minDistance = distances.get(vId);
                    u = vId;
                }
            }

            if (u == -1) break;

            visited.put(u, true);

            for (Edge edge : adjList.get(u)) {
                int neighbor = edge.getDestination().getId();
                double weight = edge.getWeight();

                if (!visited.get(neighbor) && distances.get(u) + weight < distances.get(neighbor)) {
                    distances.put(neighbor, distances.get(u) + weight);
                }
            }
        }

        System.out.println("\n--- Dijkstra's Shortest Paths from Vertex " + start + " ---");
        for (Integer vId : distances.keySet()) {
            String distStr = (distances.get(vId) == Double.MAX_VALUE) ? "Unreachable" : String.valueOf(distances.get(vId));
            System.out.println("Distance to Vertex " + vId + " : " + distStr);
        }
        System.out.println("-------------------------------------------------");
    }

    public int getVerticesCount() {
        return vertices.size();
    }
}