package lab3;

import graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lab3 {
  public static <T> int distance(Graph<T> g, T source, T dest) {
    List<T> visited= new ArrayList<>();
    int distance = 0;
    visited.add(source);
    Set<T> currentLevel= new HashSet<>();
    currentLevel.add(source);
    while (!currentLevel.isEmpty()){
      Set<T> nextLevel= new HashSet<>();
      for (T t: currentLevel){
        if (t.equals(dest)){
          return distance;
        }
        for (T granne: g.neighbours(t)){
          if (!visited.contains(granne)){
            visited.add(granne);
            nextLevel.add(granne);
          }
        }
      }
      distance++;
      currentLevel= nextLevel;
    }
    return -1;
  }
}
