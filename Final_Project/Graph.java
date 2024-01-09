import java.util.*;
import java.util.Scanner;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.imageio.ImageIO;

/**
 * The graph class represents our adjacency matrix
 */
public class Graph {
    private static final int UNDEFINED = -1;
    private int vertices[][];
    
    public Graph(int numVertices) {
        vertices = new int[numVertices][numVertices];
    }

    /**
     * Adds vertices to the graph in a bidirectional way, with the weight of the edge
     */
    public void makeEdge(int vertex1, int vertex2, int time) {
        vertices[vertex1][vertex2] = time;
        vertices[vertex2][vertex1] = time;
    }

    /**
     * Removes vertices of the graph in a bidirectional way
     */
    public void removeEdge(int vertex1, int vertex2) {
        vertices[vertex1][vertex2] = 0;
        vertices[vertex2][vertex1] = 0;
    }

    /**
     * Returns the edge cost
     */
    public int getCost(int vertex1, int vertex2) {
        return vertices[vertex1][vertex2];
    }

    /**
     * Returns all vertices connected to the vertex passed by parameter
     */
    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();

        // We perform a for on the line that represents the vertex, and add the vertices whose index is greater than 0
        for (int i = 0; i < vertices[vertex].length; i++)
            if (vertices[vertex][i] > 0) {
                neighbors.add(i);
            }

        return neighbors;
    }

    /**
     * Implementation of the Dijkstra algorithm
     */
    public List<Integer> path(int from, int to) {

        // Create lists of travel costs so far
        int cost[] = new int[vertices.length];

        // Create list with vertices predecessors to the visitor today
        int prev[] = new int[vertices.length];

        // Create lists with unvisited vertices,
        Set<Integer> unvisited = new HashSet<>();

        // Initializes the cost of the initial vertex with 0
        cost[from] = 0;

        for (int v = 0; v < vertices.length; v++) {
            if (v != from) {
                // Initializes the cost of the other initial vertices with a very high value
                cost[v] = Integer.MAX_VALUE;
            }

            // Defines all values ​​as undefined
            prev[v] = UNDEFINED;
            
            // Adds all vertices to the unvisited listv
            unvisited.add(v);
        }

        //Search
        while (!unvisited.isEmpty()) {

            // Obtains the lowest cost unvisited vertex
            int near = closest(cost, unvisited);

            // We removed the vertex from the unvisited list
            unvisited.remove(near);

            // For each neighbor we calculate the total cost of traveling to it
            for (Integer neighbor : getNeighbors(near)) {

                // We add the cost of the node so far plus the cost of the edge connecting the two vertices
                int totalCost = cost[near] + getCost(near, neighbor);

                // If the total cost is less than the current cost to
                if (totalCost < cost[neighbor]) {

                    // Update the cost
                    cost[neighbor] = totalCost;

                    // We mark the predecessor vertex
                    prev[neighbor] = near;
                }
            }

            // Verification if the processed vertex is the destination
            if (near == to) {
                return makePathList(prev, near);
            }
        }

        //No path found
        return Collections.emptyList();
    }

    // Obtains the lowest cost unvisited vertex
    private int closest(int[] dist, Set<Integer> unvisited) {
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Integer i : unvisited) {
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Get path to the target vertex
    private List<Integer> makePathList(int[] prev, int u) {
        List<Integer> path = new ArrayList<>();
        path.add(u);
        while (prev[u] != UNDEFINED) {
            path.add(prev[u]);
            u = prev[u];
        }
        Collections.reverse(path);
        return path;

    }

}