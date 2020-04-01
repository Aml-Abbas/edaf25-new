package lab2;

import graph.Graph;
import graph.SimpleGraph;

import java.util.*;

public class Lab2 {

  /**
   * Generic depth first search in a graph, starting from the vertex u.
   *
   * @param g the graph to search in
   * @param u the start vertex
   * @param visited set of visited vertices (should be empty for a full search)
   * @param <T> the vertex type
   */
  private static <T> void dfs(Graph<T> g, T u, Set<T> visited) {
    visited.add(u);
    for (T v : g.neighbours(u)) {
      if (!visited.contains(v)) {
        dfs(g, v, visited);
      }
    }
  }

  //An undirected graph is called a connected graph if there is a path from every vertex to
  //every other vertex.
  public static boolean isConnected(Graph<Integer> g) {
    Set<Integer> visited= new HashSet<>();
    dfs(g,0,visited);
    return visited.size()>=g.vertexCount();
  }

  public static int nbrOfComponents(Graph<Integer> g) {
    int sum=0;
    Set<Integer> visited= new HashSet<>();
    for (Integer i: g.vertexSet()){
      if (!visited.contains(i)){
        sum++;
      }
      dfs(g,i,visited);
    }
    return sum;
  }

  public static boolean pathExists(Graph<Integer> g, int u, int v) {
    Set<Integer> visited= new HashSet<>();
    visited.add(u);
    for (Integer i:g.neighbours(u)){
      dfs(g,i,visited);
    }
    return visited.contains(v);
  }


  public static List<Integer> findPath(Graph<Integer> g, int u, int v) {
    List<Integer> list= new ArrayList<>();
    if (findPath(g,u,v,list)){
      list.add(0,u);
    }
    return list;
  }

  public static boolean findPath(Graph<Integer> g, int u, int v, List<Integer> list) {

    if (u==v){
      return true;
    }
    if (g.neighbours(u).contains(v)){
      list.add(v);
      return true;
    }
    for (Integer i: g.neighbours(u)){
      list.add(i);
      if (findPath(g,i,v,list)){
        return true;
      }
      list.remove(i);
    }
    return false;

  }

  public static void main(String[] args) {

    Graph<Integer> g = new SimpleGraph(5, new int[][] {
            {0, 1}, {1, 0},
            {1, 2}, {2, 1},
            {2, 3}, {3, 2},
            {3, 4}, {4, 3},
    });

    // System.out.println("one: "+pathExists(g,4,0));

    List<Integer> list= findPath(g, 4, 0);

    Graph<Integer> gl = new SimpleGraph(5, new int[][]{
            {0, 1}, {1, 0},
            {0, 2}, {2, 0},
            {1, 2}, {2, 1},
            {3, 4}, {4, 3},
    });
    //  System.out.println(pathExists(gl, 0, 3));
    // System.out.println(pathExists(gl, 1, 3));
    //   System.out.println(pathExists(gl, 2, 3));
    //  System.out.println(pathExists(gl, 4, 0));
    // System.out.println(pathExists(gl, 4, 1));
    //System.out.println(pathExists(gl, 4, 2));
    System.out.println(pathExists(gl, 0, 1));
    System.out.println(pathExists(gl, 2, 0));


    System.out.print("listan: "+list);
  }
}

