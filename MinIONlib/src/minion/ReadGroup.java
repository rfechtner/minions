package minion;

import java.util.*;

public class ReadGroup extends LinkedList<ChainedRead> {
  
  private final String readName;
  
  public ReadGroup(String readName) {
    this.readName = readName;
  }
  
  public ReadGroup(List<String> parseLines) {
    this.readName = parseLines.remove(0).substring(1);
    
    List<String> chainedRead = new LinkedList<>();
    while(!parseLines.isEmpty()) {
      String nextLine = parseLines.remove(0);
      
      if(nextLine.length() == 0) {
        break;
      } else if(nextLine.startsWith("@")) {
        chainedRead.add("");
        add(new ChainedRead(chainedRead));
        chainedRead.clear();
      }
      
      chainedRead.add(nextLine);
    }
  }
  
  @Override
  public final boolean add(ChainedRead cr) {
    if(cr.getReadID().equals(readName)) {
      return super.add(cr);
    }
    return false;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("#").append(readName).append("\n");
    forEach(cr -> sb.append(cr.toString()));
    return sb.append("\n").toString();
  }
}
