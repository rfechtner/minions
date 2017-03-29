package minion;

import java.util.List;

public class SeedChain
{
  private static final int SHIFT = 5;
  private final int tStart;
  private final int tStop;
  private final int gStart;
  private final int gStop;

  public SeedChain(int tStart, int tStop, int gStart, int gStop)
  {
    this.tStart = tStart;
    this.tStop = tStop;
    this.gStart = gStart;
    this.gStop = gStop;
  }

  public SeedChain(List<MySAMRecord> overlaps)
  {
    MySAMRecord first = overlaps.get(0);
    String firstReadName = first.getId();

    MySAMRecord last = overlaps.get(overlaps.size());
    String lastReadName = last.getId();

    this.tStart = Integer.parseInt(firstReadName.substring(firstReadName.indexOf("."))) * SHIFT;
    this.tStop = Integer.parseInt(lastReadName.substring(lastReadName.indexOf("."))) * SHIFT + last.getLength();
    this.gStart = first.getStart();
    this.gStop = last.getStop();
  }

  public int getTransStart()
  {
    return this.tStart;
  }

  public int getTransStop()
  {
    return this.tStop;
  }

  public int getGeneStart()
  {
    return this.gStart;
  }

  public int getGeneStop()
  {
    return this.gStop;
  }
}
