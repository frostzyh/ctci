import java.util.Arrays;

public class Q02 {

  public Q02(){

  }

  // Best solution
  // Time : O()    Space : O ()
  public boolean solution1(String str1, String str2){
    if (str1.length() != str2.length()) return false;
    char[] c1 = str1.toCharArray();
    char[] c2 = str2.toCharArray();
    Arrays.sort(c1); // O(nlog(n))
    Arrays.sort(c2); // O(nlog(n))

    for (int i = 0; i < c1.length; i++){
      if (c1[i] != c2[i]) return false;
    }
    return true;
  }


  // Time : O()    Space : O ()
  public boolean solution2(String str1, String str2){
    if (str1.length() != str2.length()) return false;
    int[] letters = new int[256]; // Assume ASCII Extended

    for (int i=0; i < str1.length(); i++){
      letters[str1.charAt(i)]++;
      letters[str2.charAt(i)]--;
    }
    for (int i=0; i < str1.length(); i++){
      if (letters[i] != 0) return false;
    }
    return true;
  }


  /*
  // Time : O()    Space : O ()
  public boolean solution1(){

  }

  */


  public static void main(String[] args){


    String[] str = new String[4];
    str[0] = "absdbfvghj";
    str[1] = "jhbgfdbsav";
    str[2] = "haha";
    str[3] = "ahah";

    Q02 obj = new Q02();
    System.out.println(str[0] + "  " + str[1]);
    System.out.println(obj.solution1(str[0],str[1]));
    System.out.println(obj.solution2(str[0],str[1]));
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(str[2] + "  " + str[3]);
    System.out.println(obj.solution1(str[3],str[2]));
    System.out.println(obj.solution2(str[3],str[2]));


  }
}
