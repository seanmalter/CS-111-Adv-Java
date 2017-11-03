public class Contact
{
  private String firstName, lastName, email, phone;

  public Contact()
  {
    firstName = "";
    lastName = "";
    email = "";
    phone = "";
  }

  public Contact(String firstName, String lastName, String email, String phone)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public String GetName()
  {
    return firstName + ' ' + lastName;
  }

  public String GetEmail()
  {
    return email;
  }

  public String GetPhone()
  {
    return phone;
  }

  public void SetFirstName(String name)
  {
    this.firstName = name;
  }

  public void SetLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public void SetEmail(String email)
  {
    this.email = email;
  }

  public void SetPhone()
  {
    this.phone = phone;
  }

  @Override
  public String toString()
  {
    return "Name: " + firstName + " " + lastName + " Email: " + email + " Phone: " + phone;
  }
}
