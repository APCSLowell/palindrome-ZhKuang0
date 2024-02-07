import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
  public boolean palindrome(String sWord){
  String scanWord = onlyLetters(noSpaces(noCapitals(sWord)));
  String reversesWord = reverse(scanWord);
  return (scanWord.equals(reversesWord));
}

public String noCapitals(String sWord){
  return sWord.toLowerCase();
}
public String noSpaces(String sWord)
{
  char spc = ' ';
  String newstr = "";
  for (int i = 0; i < sWord.length(); i++) {
    if (!(sWord.charAt(i) == spc))
    newstr += sWord.charAt(i);
  }
  return newstr;
}

public String onlyLetters(String sString){
   if (sString.length() == 0)
   return "";
   else 
   if (Character.isLetter(sString.charAt(0)))
   return sString.charAt(0) + onlyLetters(sString.substring(1));
   else
   return onlyLetters(sString.substring(1));
}

public String reverse(String sWord)
{
  String tmp = new String();
  for (int i = sWord.length(); i > 0; i--) {
      tmp += sWord.substring(i-1,i);
  }
  return tmp;
}
}
