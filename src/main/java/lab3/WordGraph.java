package lab3;

import graph.Graph;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordGraph implements Graph<String> {
  private final Map<String, Set<String>> graph = new HashMap<>();

  public WordGraph(Path wordfile, WordCriteria criteria) throws IOException {
    try (
            Reader in = Files.newBufferedReader(wordfile);
            Scanner scan = new Scanner(in)) {
      while (scan.hasNext()) {
        String word = scan.nextLine();
        graph.put(word, new HashSet<String>());
      }
    }

    for (String str:graph.keySet()){
     for (String s: graph.keySet()){
       if(criteria.adjacent(str,s)){
         Set<String> newSet= graph.get(s);
         newSet.add(str);
         graph.put(s,newSet);
       }
     }
    }

  }

  @Override public int vertexCount() {
    return graph.size();
  }

  @Override public Collection<String> vertexSet() {
    Set<String> set= new HashSet<>();
    for(String s: graph.keySet()){
      set.add(s);
    }
    return set;
  }

  @Override public Collection<String> neighbours(String v) {
    return graph.getOrDefault(v, Collections.emptySet());
  }
}
