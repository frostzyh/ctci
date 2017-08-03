import java.lang.StringBuilder;

public class Q06 {

  // Time : O(n)    Space : O (n)
  public static String mySol(String str){
    if (str.length() <3) return str;
    StringBuilder sb = new StringBuilder();
    sb.append(str.charAt(0));
    char c = str.charAt(0);
    int counter = 1;
    for (int i = 1; i < str.length(); i++){
      if (str.charAt(i) == c){
        counter++;
      }
      else{
        sb.append(counter);
        c = str.charAt(i);
        sb.append(c);
        counter = 1;
      }
    }
    sb.append(counter);

    String ssb = sb.toString();
    return str.length() > ssb.length() ? ssb : str;
  }

  // Time : O()    Space : O ()
  public static String stdSol(String str){
    if (str.length() <3) return str;
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    for (int i = 0; i < str.length(); i++){
      counter ++;
      if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
        sb.append(str.charAt(i));
        sb.append(counter);
        counter = 0;
      }
    }
    return str.length() > sb.length() ? sb.toString() : str;
  }




  public static void main(String[] args){
    String[] strs = {"aabbccdd", "aaaebbccdd",
    "aaaeebbccdd","aaaeebcccccdd",
    "aaaeebbcceczdd"
    };

    long startTime = System.currentTimeMillis();
    for (String s: strs){
      System.out.println(s + ":");
      System.out.println(mySol(s) + "\n");

    }
    long endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");

    startTime = System.currentTimeMillis();
    for (String s: strs){
      System.out.println(s + ":");
      System.out.println(stdSol(s) + "\n");

    }
    endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");


  }
}
