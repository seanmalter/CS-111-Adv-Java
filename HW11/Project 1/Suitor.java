public class Suitor
{
  private int count;
  private String name;
  private Suitor link;
  public Suitor()
  {
    count = 0;
    name = null;
    link = null;
  }
  public Suitor(String newName, int newCount, Suitor linkValue)
  {
    setData(newName, newCount);
    link = linkValue;
  }
  public void setData(String newName, int newCount)
  {
    name = newName;
    count = newCount;
  }
  public void setLink(Suitor newLink)
  {
    link = newLink;
  }
  public String getName()
  {
    return name;
  }
  public int getCount()
  {
    return count;
  }
  public Suitor getLink()
  {
    return link;
  }
}
