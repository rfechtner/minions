package minion;

import augmentedTree.*;

public class MySAMRecord implements Interval
{
  private final String id;
  private final int start;
  private final int end;
  private final String ref;

  public MySAMRecord(String id, int start, int end, String reference)
  {
    this.id = id;
    this.start = start;
    this.end = end;
    this.ref = reference;
  }

  @Override
  public int getStart()
  {
    return start;
  }

  @Override
  public int getStop()
  {
    return end;
  }

  public String getId()
  {
    return id;
  }

  public String getRef()
  {
    return ref;
  }

  public int getLength()
  {
    return end - start + 1;
  }
}
