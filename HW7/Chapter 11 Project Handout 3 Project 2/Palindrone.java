public class Palindrone
{
  public static void main(String[] args)
  {
    checkPalindrone("bob");
    checkPalindrone("muhahahum");
    checkPalindrone("a");
    checkPalindrone("sadf i*??na l");
  }

  public static String cleanString(String string)
  {
    return string.replaceAll("[^a-zA-Z]", "").toLowerCase();
  }

  public static boolean palindrone(String string)
  {
    int stringLength = string.length();
    if(stringLength <= 1)
    {
      return true;
    }
    //check that the two chars on the end are equal
    else if(string.charAt(0) == string.charAt(stringLength-1))
    {
      return true && palindrone(string.substring(1, stringLength-1));
    }
    else
    {
      return false;
    }
  }
  
  public static void checkPalindrone(String string)
  {
  	String superCleanString = cleanString(string);
  	if(superCleanString.length() <= 1)
  	{
  		System.out.printf("unable to check string \"%s\", it is too short%n", string);
  		return;
  	}

  	boolean isPalindrone = palindrone(superCleanString);
  	System.out.printf("string \"%s\" is a palindrone? %b%n", string, isPalindrone);
  }
}
