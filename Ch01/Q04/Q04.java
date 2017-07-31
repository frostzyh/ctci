import java.util.HashMap;

public class Q04 {

  //Object: Check string is either a Palindrome Permutation
  // Palindrome: string is same by read from either front or end
  // Permutation: rearrangement of letters.

  // Time : O(n)    Space : O (n)
  public static boolean mySol(String str){
    String ss = str.toLowerCase();  // O(n)
    HashMap<Character,Integer> map = new HashMap<>(); // O(n) space
    for (char i: ss.toCharArray()){  // O(n)
      if (getCharNumber(i) == -1){
        continue;
      }
      if (!map.containsKey(i)){
        map.put(i,1);
      }
      else map.put(i, map.get(i)+1);
    }
    int numOfOdds = 0;
    for (int i: map.values()){
      if (i % 2 == 1) numOfOdds++;
    }

    if (numOfOdds < 2) return true;
    return false;
  }


  // Time : O(n)    Space : O (1)
  public static boolean stdSol(String str){
    int countOdd = 0;
    int[] table = new int[26]; // 26 letters
    // int[] table = new int[Character.getNumericValue('z')
    // -Character.getNumericValue('a')+1]
    for (char c: str.toCharArray()){
      int x = getCharNumber(c);
      if (x != -1){
        table[x] ++;
        if (table[x] % 2 == 1) countOdd++;
        else countOdd--;
      }
    }
    return countOdd <= 1;
  }

  // Make sure the character is a letter of alphabet
  private static int getCharNumber(char c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && z >= val) return val - a;
    return -1;
  }

  public static void main(String[] args){

    String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Taco tac",
							"asda",
              "tact Coa"};
    for (String s : strings){
      System.out.println("Input is :" + s);
      System.out.println(mySol(s));
      System.out.println(stdSol(s));
    }
  }
}
