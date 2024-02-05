import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
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
  public boolean palindrome(String word) 
  {
    String baseWord = lettercheck(noCapitals(moveSpaces(word))); 
    String reversedWord = reverse(baseWord);
    return baseWord.equals(reversedWord);
  }

public String noCapitals(String word){
  String rstr = "";
  for(int i=0; i < word.length(); i ++){
    rstr += (word.substring(i, i++)).toLowerCase();
  }
  return rstr;
}
public String moveSpaces(String word){
  String mspc = "";
  for( int i = 0; i < word.length(); i++) {
    if(word.substring(i,i+1).equals(" ")) {
    }else{
      mspc += word.substring(i,i+1);
    }
  }
  return mspc;
}
public String lettercheck(String str){
  String increword = "";
  for (int i = 0 ; i < str.length(); i ++) {
    if (Character.isLetter(str.charAt(i))) {
      increword += str.substring(i, i+1);
   }
  }
  return increword;
}
public String reverse(String str)
{
    String sNew = new String();
    for (int i = str.length(); i > 0; i--) {
        sNew += str.substring(i--, i); 
}
return sNew;
}
