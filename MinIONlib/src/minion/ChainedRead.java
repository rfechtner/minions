package minion;

import java.util.*;

public class ChainedRead
{

  private final String chr;
  private final String readID;
  private final String seq;
  private final List<SeedChain> chains;

  public ChainedRead(String chr, String readID, String seq, List<SeedChain> chains)
  {
    this.chr = chr;
    this.readID = readID;
    this.seq = seq;
    this.chains = chains;
  }

  public ChainedRead(List<String> parseLines)
  {
    this.readID = parseLines.remove(0).substring(1);
    this.seq = parseLines.remove(0);
    this.chr = parseLines.remove(0).substring(1);

    this.chains = new LinkedList<>();
    while(!parseLines.isEmpty() && parseLines.get(0).length() > 0)
    {
      this.chains.add(new SeedChain(Integer.parseInt(parseLines.remove(0).substring(1)), Integer.parseInt(parseLines.remove(0).substring(1)),
                                    Integer.parseInt(parseLines.remove(0).substring(1)), Integer.parseInt(parseLines.remove(0).substring(1))));
    }
  }

  public String getChr()
  {
    return chr;
  }

  public String getReadID()
  {
    return readID;
  }

  public String getSeq()
  {
    return seq;
  }

  public List<SeedChain> getChains()
  {
    return chains;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder("@").append(readID).append("\n");
    sb.append(seq).append("\n");
    sb.append(">").append(chr).append("\n");
    chains.forEach(chain -> sb.append("<").append(chain.getTransStart()).append("\n")
            .append("<").append(chain.getTransStop()).append("\n")
            .append("<").append(chain.getGeneStart()).append("\n")
            .append("<").append(chain.getGeneStop()).append("\n"));

    return sb.append("\n").toString();
  }
}
