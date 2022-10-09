package pt.isec.a2020134077.exerciciosficha1.ex4;

public class Main {
    private static long stopTime;
    private static long startTime;

    public static int maxSeqCont1(int [] m) {
        int maxSoma=0;
        int N=m.length;
        startTimer();
        for(int i=0;i<N;i++)
            for(int j=i;j<N;j++){
                int estaSoma=0;
            for(int k=i;k<j;k++)
               estaSoma+=m[k];
            if(estaSoma > maxSoma)
                 maxSoma = estaSoma;
            }
        stopTimer();
        showTime();
        return maxSoma;
    }

    public static int maxSeqCont2(int [] m) {
        int maxSoma=0;
        int N=m.length;
        startTimer();
        for(int i=0;i<N;i++){
            int estaSoma=0;
            for(int j=i;j<N;j++){
                estaSoma+=m[j];
                if(estaSoma>maxSoma)
                    maxSoma=estaSoma;
                }
            }
        stopTimer();
        showTime();
        return maxSoma;
    }

    public static int maxSeqCont3(int [] m) {
        int maxSoma = 0;
        int N = m.length;
        startTimer();
        for (int i = 0; i < N; i++) {
            int estaSoma = 0;
            for (int j = i; j < N; j++) {
                estaSoma += m[j];
                if (estaSoma < 0)
                    break;
                if (estaSoma > maxSoma)
                    maxSoma = estaSoma;
            }
        }
        stopTimer();
        showTime();
        return maxSoma;
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
        int [] m = new int[9000];
        for(int i = 0;i<m.length;i++)
            m[i] = (int)(Math.random() * 1000);

        //maxSeqCont1(m); //28.0 segundos
        //maxSeqCont2(m); //0.0 segundos
        maxSeqCont3(m); //0.0 segundos
    }
}
