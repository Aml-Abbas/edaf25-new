package lab1;

import graph.Graph;
import graph.SimpleGraph;

public class Lab1 {
  /**
   * Returns the number of vertices in the graph g.
   */
  public static int vertexCount(Graph<Integer> g) {
    return g.vertexCount();
  }

  /**
   * Returns the number of edges in the graph g.
   */
  public static int edgeCount(Graph<Integer> g) {
    int sum=0;
    for(Integer i: g.vertexSet()) {
      sum += g.neighbours(i).size();
    }
    return sum;
  }

  /**
   * Returns true if there is an edge from vertex u to vertex v.
   * Returns false if u and v are not connected or if there is only an edge from v to u.
   *
   * @param g a graph containing u and v
   * @param u index of the first vertex in g
   * @param v index of the second vertex in g
   */
  public static boolean edgeBetween(Graph<Integer> g, int u, int v) {
    return g.neighbours(u).contains(v);
  }

  /**
   * Returns a simple graph with at least 6 vertices and at least 10 edges.
   */
  public static Graph<Integer> buildGraph() {
    return new SimpleGraph(10, new int [] [] { {0, 3}, {0, 1}, {3, 1},{2, 3}, {2, 1}, {5, 1}, {0, 7}, {0, 9}, {3, 9},{4, 8}, {3, 4}, {6, 8} });

  }
}
