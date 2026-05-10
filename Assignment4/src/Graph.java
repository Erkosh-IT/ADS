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

    public void addEdge(int from, int to) {
        Vertex source = vertices.get(from);
        Vertex dest = vertices.get(to);

        if (source != null && dest != null) {
            adjList.get(from).add(new Edge(source, dest));
            adjList.get(to).add(new Edge(dest, source));
        }
    }

    public void printGraph() {
        for (int vId : adjList.keySet()) {
            System.out.print("AdjList[" + vId + "]: ");
            for (Edge edge : adjList.get(vId)) {
                System.out.print(edge.getDestination().getId() + " ");
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
}