package pt.isec.a2020134077.exerciciosficha1.ex5;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static long stopTime;
    private static long startTime;
    public static int ex5(int[]m){
        int n = 0,j=0;
        int maxAtual = 0, maxAnt = 0;
        startTimer();
        while (j<m.length){
            for(int i = 0;i<m.length;i++){
                if(m[i] == m[j]){
                    maxAtual++;
                }
            }
            if(maxAtual > maxAnt) {
                n = m[j];
                maxAnt = maxAtual;
            }
            j++;
        }
        stopTimer();
        showTime();
        return n;
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

    static int[] criaArrayCom(
            int valor,
            int dimensao,
            boolean diferentes){
        int m[]=new int[dimensao];
        if(diferentes){
            for(int i=0;i<dimensao;i++)
                m[i]=i*10;
            if((valor%10!=0)||(0>valor)||(valor>(dimensao-1)*10))
                m[0]=valor;
        }
        else{
            Random r=new Random();
            int gama=(Math.abs(valor)<10)?10:Math.abs(valor);
            for(int i=0;i<dimensao;i++)
                m[i]=r.nextInt(gama*4)-gama*2;
            m[0]=valor;
        }
        Arrays.sort(m);
        return m;
    }

    public static void main(String[] args) {
        //int []m = {3,3,4,2,4,4,2,4,4};
        int[] m = criaArrayCom(10,100000,false);

        //System.out.println(Arrays.toString(m));

        System.out.println(ex5(m));

    }
}
