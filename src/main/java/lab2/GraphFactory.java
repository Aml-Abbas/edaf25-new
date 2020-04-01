package lab2;

import graph.Graph;
import graph.SimpleGraph;

public class GraphFactory {

  /** Returns a connected graph of at least 5 vertices. */
  public static Graph<Integer> buildConnected() {
    return new SimpleGraph(5, new int [] [] { {0, 1}, {1, 0}, {0, 2},{2, 0}, {3, 1}, {1, 3}, {4, 3}, {3, 4}, {2, 4},{4, 2}});
  }

  /** Returns a disconnected graph of at least 5 vertices. */
  public static Graph<Integer> buildDisconnected() {
    return new SimpleGraph(5, new int [] [] { {0, 1}, {1, 0}, {0, 2},{2, 0}, {2, 1}, {1, 2}, {4, 3}, {3, 4}});
  }
}
