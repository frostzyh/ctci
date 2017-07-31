import java.util.HashSet;
import java.util.Arrays;
public class Q01{

  // Object: is Unique. return false if duplicates is found.
  public Q01(){
  }

  // Best solution. Time = O(min(c,n)). c = 256 in this case.
  // Space = O(c)
  public boolean isUnique1(String str){
    // assume the character encoding is ASCII Extended
    boolean[] checker = new boolean[256];
    for (int i = 0; i < str.length(); i++){
      int c = str.charAt(i);
      if (checker[c] == true) return false;
      checker[c] = true;
    }
    return true;
  }

  // Theoritical time = O(n). Actual Time = O(min(c,n)). c = number of unique characters.
  // Space = O(n). n <= c.
  public boolean isUnique2(String str){
    HashSet<Character> hs = new HashSet<>();
    for (int i = 0; i < str.length(); i++)
      if (!hs.add(str.charAt(i))) return false;
    return true;
  }

  // space = O(1). Time = O(n).
  public boolean isUnique3(String str){
    if (str.length() < 2) return true;
    char[] ca = str.toCharArray();
    Arrays.sort(ca);
    char prev = ca[0];
    for (int i = 1; i < ca.length; i++){
      if (ca[i] == prev) return false;
      prev = ca[i];
    }
    return true;
  }

  public static void main(String[] args){
    Q01 obj = new Q01();

    String[] str = new String[4];
    str[0] = "asdfghjklmnbvcxz,.";
    str[1] = "yehuizhang";
    str[2] = "";
    str[3] = "zxc569bm";


    for (String s:str){
      System.out.println("Testing : " + s);
      System.out.println(obj.isUnique1(s));
      System.out.println(obj.isUnique2(s));
      System.out.println(obj.isUnique3(s));
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
  }
}
