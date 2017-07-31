import java.lang.StringBuilder;
import java.util.Arrays;

public class Q03 {

  //Obect: Replace spaces between words of a string to "%20"

  // Time : O()    Space : O ()
  public static String mySol(char[] str, int trueLength){
    StringBuilder sb = new StringBuilder();
    for (int i=0; i <trueLength; i++){
      if (str[i] != ' ') sb.append(str[i]);
      else sb.append("%20");
    }
    return sb.toString();
  }


  public static String mySol2(char[] str, int trueLength){
    // create a copy of array. keey the original object unchaged.
    str = Arrays.copyOf(str, str.length);
    int endPointer = str.length -1;
    int frontPointer = trueLength-1;
    while (frontPointer >= 0){
      if (str[frontPointer] != ' '){
        str[endPointer--] = str[frontPointer--];
        //endPointer--;
        //frontPointer--;
      }
      else{
        str[endPointer--] = '0';
        str[endPointer--] = '2';
        str[endPointer--] = '%';
        frontPointer--;
      }
    }
    return new String(str);
  }

  public static String stdSol(char[] str, int trueLength) {
    str = Arrays.copyOf(str, str.length);
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length) str[trueLength] = '\0';
		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
    return new String(str);
	}

  public static int lastCharPosition(char[] str) {
    for (int i = str.length-1; i >= 0; i--){
      if (str[i] != ' ') return i;
    }
    return -1;
  }

  public static void main(String[] args){
    String str = "Mr John Smith    ";
    char[] arr = str.toCharArray();
    int trueLength = lastCharPosition(arr) + 1;
    System.out.println(mySol(arr,trueLength));
    System.out.println(mySol2(arr,trueLength));
    System.out.println(stdSol(arr,trueLength));
    System.out.println("This is the original string: " + new String(arr));

  }
}
