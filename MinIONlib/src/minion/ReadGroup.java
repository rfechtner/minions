package minion;

import java.util.*;

public class ReadGroup extends LinkedList<ChainedRead> {
  
  private final String readName;
  
  public ReadGroup(String readName) {
    this.readName = readName;
  }
  
  @Override
  public boolean add(ChainedRead cr) {
    if(cr.getReadID().equals(readName)) {
      return super.add(cr);
    }
    return false;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("#").append(readName).append("\n");
    forEach(cr -> sb.append(cr.toString()));
    return sb.toString();
  }
}
