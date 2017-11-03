import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class ContactList
{

  public static void main(String[] args)
  {
  	ContactList contacts = new ContactList();

    contacts.Menu();
  }

  private ArrayList<Contact> contacts;

  public ContactList()
  {
    contacts = new ArrayList<Contact>();
  }

  public void AddContact()
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the new user data in the form " +
    "First Name, Last Name, Email, Phone");
    String contactInfo = scanner.nextLine();
    String[] contactArray = contactInfo.split(", ");
    if(contactArray.length == 4)
    {
      Contact tempContact = new Contact(
      contactArray[0], contactArray[1], contactArray[2], contactArray[3]);
      contacts.add(tempContact);
      Menu();
    }
    else
    {
      System.out.println("unable to process input, make sure" +
      " you separate your entries with a ', ' and have all fields");
      AddContact();
    }
  }

  public void DisplayContacts()
  {
    for( Contact contact : contacts)
    {
      System.out.println(contact);
    }
    Menu();
  }

  public void SearchForContact()
  {
    System.out.println("Enter your search:");
  	Scanner scanner = new Scanner(System.in);
  	String search = scanner.nextLine();
  	search = search.toLowerCase();
    ArrayList<Contact> matchingContacts = new ArrayList<Contact>();
    for( Contact contact : contacts)
    {
      boolean Name = contact.GetName().toLowerCase().indexOf(search) != -1;
      boolean Email = contact.GetEmail().toLowerCase().indexOf(search) != -1;
      boolean Phone = contact.GetPhone().toLowerCase().indexOf(search) != -1;

      if( Name || Email || Phone )
      {
        matchingContacts.add(contact);
      }
    }
    OptionalDeleteContact(matchingContacts);
  }

  public void OptionalDeleteContact(ArrayList<Contact> searchedContacts)
  {
    Scanner scanner = new Scanner(System.in);
    for( Contact contact : searchedContacts )
    {
      System.out.println(contact);
      System.out.println("Would you like to delete this contact? (Y / n)");
      String input = scanner.nextLine();
      if( input.toLowerCase().equals("y") )
      {
        contacts.remove(contact);
      }
    }
    Menu();
  }

  public void Menu()
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.println("Pick an option: 'Add Contact', 'Display Contacts', 'Search'");
    String choice = scanner.nextLine();
    switch(choice.toLowerCase()){
      case "add contact":
        AddContact();
        break;
      case "display contacts":
        DisplayContacts();
        break;
      case "search":
        SearchForContact();
        break;
      default:
        System.out.println("that was not an option, try again");
        Menu();
        break;
    }
  }
}
