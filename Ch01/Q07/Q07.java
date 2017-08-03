import java.util.Arrays;

public class Q07 {

  // Rotate NxN image 90 degree.
  // Time : O()    Space : O ()
  public static int[][] mySol(int[][] mat){ // rotate to left

    // Copy matrix
    int[][] matrix = new int[mat.length][mat.length];
    for (int i =0; i < mat.length; i++){
      for (int j =0; j <mat.length; j++){
        matrix[i][j] = mat[i][j];
      }
    }
    for (int i = 0; i < matrix.length/2; i++){
      for (int j = i; j<matrix.length-1-i; j++){
        swap(matrix, i,j);
      }
    }
    return matrix;
  }


  public static boolean stdSol(int[][] matrix){ // rotate to right
    if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
    int n = matrix.length;
    for (int layer = 0; layer < n /2; layer++){
      int first = layer;
      int last = n-1-layer;
      for (int i = first; i < last; i++){
        int offset = i - first;
        int top= matrix[first][i];

        matrix[first][i] = matrix[last-offset][first];
        matrix[last-offset][first] = matrix[last][last-offset];
        matrix[last][last-offset] = matrix[i][last];
        matrix[i][last] = top;
      }
    }
    return true;
  }

  private static void swap(int[][] matrix, int i, int j){
    int temp = matrix[i][j];
    int N = matrix.length -1;
    // Go to Book see my handdrawing. P203
    matrix[i][j] = matrix[j][N-i]; // Right to top
    matrix[j][N-i] = matrix[N-i][N-j]; // Bot to right
    matrix[N-i][N-j] = matrix[N-j][i]; //left to bot;
    matrix[N-j][i] = temp;
  }





  /*
  // Time : O()    Space : O ()
  public static int stdSol(){
  }


  */


  public static void main(String[] args){

    long startTime, endTime;
    startTime = System.currentTimeMillis();

    int[][] m5 = new int[50][50];
    int start = 1;
    for (int i = 0; i < m5.length; i++){
      for (int j =0; j< m5.length; j++){
        m5[i][j] = start++;
      }
    }
    System.out.println(Arrays.deepToString(m5));
    // Three rotation to left = 90 degree right rotation
    int[][] left = mySol(mySol(mySol(m5)));
    System.out.println(Arrays.deepToString(left));
    if (stdSol(m5)){
      System.out.println(Arrays.deepToString(m5));
    }

    boolean isSame = true;
    for (int i = 0; i < left.length; i++){
      for (int j =0; j< left.length; j++){
        if (m5[i][j] != left[i][j]) isSame = false;
      }
    }
    System.out.println(isSame ? "Result matches" : "result does not match");




    endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");


    /*
    long startTime, endTime;
    startTime = System.currentTimeMillis();
    endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");

    startTime = System.currentTimeMillis();
    endTime = System.currentTimeMillis();
    System.out.println("Running time: " + (endTime - startTime) + "(ms)");
    */
  }
}
