public class Q09 {

  // Time : O()    Space : O ()
  
  private static boolean isSubString(String sub, String str){
    if (str.length() < sub.length() || sub.length() == 0) return false;
    boolean found = false;
    int subSize = sub.length();
    int index = 0;
    for(int i =0; i < str.length(); i++){
      if (str.charAt(i) == sub.charAt(index)){
        if (index == subSize -1){
          found = true;
          break;
        }
        index++;
      }
      else index = 0;
    }
    
    return found;
    
  }
  public static boolean mySol(String s1, String s2){
    if (s1.length() == s2.length() && s1.length() > 0){
      return isSubString(s1,s2+s2);
    }
    return false;
    
  }

  /*
  // Time : O()    Space : O ()
  public static int stdSol(){
  }


  */


  public static void main(String[] args){
    String[] strs = {
      "aabcd", "aaabaabcdd",
      "aaaeebbccdd","aaaeebcccccdd",
      "bbczd", "aaaeebbczdd",
      "peachBanana", "eachBananap"};
      
    // Test isSubString
    System.out.println(isSubString(strs[0],strs[1]));
    System.out.println(isSubString(strs[2],strs[3]));
    System.out.println(isSubString(strs[4],strs[5]));
    
    System.out.println();

    long startTime, endTime;
    startTime = System.currentTimeMillis();
    System.out.println(mySol(strs[6],strs[7]));
    
    
    endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");
  }
}
