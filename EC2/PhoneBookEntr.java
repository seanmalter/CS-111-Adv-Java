import java.util.ArrayList;
import java.util.ListIterator;

public class PhoneBookEntr
{

  public static void main(String[] args) {
    ArrayList<PhoneBookEntry> entries = new ArrayList<PhoneBookEntry>();

    entries.add(new PhoneBookEntry("Sean", "760-555-5989", "CS"));
    entries.add(new PhoneBookEntry("Marc", "760-555-2039", "Biology"));
    entries.add(new PhoneBookEntry("Jon", "760-555-2415", "Math"));
    entries.add(new PhoneBookEntry("Teagan", "760-555-0972", "English"));
    entries.add(new PhoneBookEntry("Mill", "760-555-8408", "CS"));

    ListIterator list = entries.listIterator();

    String csMajors = "";

    while(list.hasNext())
    {
      PhoneBookEntry temp = (PhoneBookEntry) list.next();
      if(temp.getMajor().toLowerCase().equals("cs"))
      {
        csMajors += temp.getName() + ", ";
      }
    }
    System.out.println(csMajors);
  }
  private String name;
  private String phone;
  private String major;

  public PhoneBookEntry()
  {
    name = "";
    phone = "";
    major = "";
  }

  public PhoneBookEntry(String name, String phone, String major)
  {
    this.name = name;
    this.phone = phone;
    this.major = major;
  }

  public String getName(){
    return name;
  }
  public String getPhone()
  {
    return phone;
  }
  public String getMajor()
  {
    return major;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setPhone(String phone)
  {
    this.phone = phone;
  }
  public void setMajor(String major)
  {
    this.major = major;
  }
  @Override
  public String toString()
  {
    return "Name: " + name + " Phone: " + phone + " Major: " + major;
  }

  public boolean equals(PhoneBookEntry entry)
  {
    if(name.equals(entry.getName()) && major.equals(entry.getMajor()) && phone.equals(entry.getPhone()))
    {
      return true;
    }
    else
      return false;
  }
}
