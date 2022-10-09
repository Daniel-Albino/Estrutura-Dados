package pt.isec.a2020134077.exerciciosficha1.ex3;

import java.util.Arrays;

public class Main {

    private static long stopTime;
    private static long startTime;

    public static boolean exa(int[][] m, int n){
        boolean bol = false;
        startTimer();
        for (int i = 0;i<m.length;i++) {
            for (int j = 0; j < m[i].length; j++)
                if (m[i][j] == n) {
                    bol = true;
                    break;
                }
            if(bol)
                break;
        }
        stopTimer();
        showTime();
        return false;
    }



    public static boolean exb(int[][] m, int n){
        int j = 0,i=0;
        boolean bol = false;
        startTimer();
        while (i<m.length){
            for (i = 0;i<m.length;i++){
                if(m[i][j] == n) {
                    bol = true;
                    break;
                }
            }
            if(bol)
                break;
            j++;
        }
        stopTimer();
        showTime();
        return false;
    }

    private static void showTime() {
        long interval=stopTime-startTime;
        long secs=interval/1000000000L;
        long decs=interval-secs*1000000000L;
        decs/=100000000L;
        System.out.println("secs="+secs+"."+decs);
    }
    private static void stopTimer() {
        stopTime=System.nanoTime();
    }
    private static void startTimer() {
        startTime=System.nanoTime();
    }

    public static void main(String[] args) {
        int [][]matrix = new int[8888][8888];

        int x = 0;

        for (int i = 0;i<matrix.length;i++)
            for(int j = 0;j<matrix[i].length;j++){
                matrix[i][j] = x;
                x++;
            }

        //System.out.println("Matriz: \n" + Arrays.deepToString(matrix));

        System.out.println(exa(matrix,1000000));
        System.out.println(exb(matrix,1000000));


    }
}
