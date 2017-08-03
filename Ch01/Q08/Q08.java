import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Q08 {

  // Time : O(n*n)    Space : O (1)
  public static int[][] mySol(int[][] matrix){
    // Copy matrix
    int[][] mat = new int[matrix.length][matrix.length];
    // using hashSet instead of ArrayList avoids redundant reassignment.
    HashSet<Integer> row = new HashSet<>();
    HashSet<Integer> col = new HashSet<>();
    //copy list O(n^2)
    for (int i =0; i < mat.length; i++){  
      for (int j =0; j <mat.length; j++){ 
        mat[i][j] = matrix[i][j];
        if (mat[i][j] == 0){
          row.add(i);
          col.add(j);
        }
      }
    }
    
    // set all rows to 0
    for (int i: row){
      for (int j=0; j < mat.length; j++){
        mat[i][j] = 0;
      }
    }
    // set all cols to 0
    for (int j: col){
      for (int i=0; i < mat.length; i++){
        if (row.contains(i)) continue;
        mat[i][j] = 0;
      }
    }
    return mat;
  }





  /*
  // Time : O()    Space : O ()
  public static int stdSol(){
  }


  */


  public static void main(String[] args){

    System.out.println();

    long startTime, endTime;
    startTime = System.currentTimeMillis();
    
    int[][] mm = {
      {1,6,9,2},
      {3,6,0,1},
      {0,4,2,11},
      {8,5,3,2}
    };
    
    System.out.println(Arrays.deepToString(mm));
    System.out.println(Arrays.deepToString(mySol(mm)));
    
    endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");




    startTime = System.currentTimeMillis();
    endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");
  }
}
