import java.util.Arrays;
import java.util.Random;

public class donut {
    public static void main(String[] args){
        int k;
        double A=0, B=0, i, j;
        int l=0;
        double[] z = new double[1760];
        char[] b = new char[1760];
        Random rand = new Random();
        String[] colors = {"\u001B[32m","\u001B[36m","\u001B[35m"};
        String material = ".,-~:;=!*#$@";
        System.out.print("\033[2J");
        while(true){
            Arrays.fill(z,0, 1760, 0);
            Arrays.fill(b, 0, 1760, ' ');
            for(i=0; i<6.28; i+=0.07){
                for(j=0; j<6.28; j+=0.02){
                    double sinj = Math.sin(j),
                            cosi = Math.cos(i),
                            sinA = Math.sin(A),
                            sini = Math.sin(i),
                            cosA = Math.cos(A),
                            cosi2 = cosi + 2,
                            mess = 1/(sinj * cosi2 * sinA + sini * cosA + 5),
                            cosj =  Math.cos(j),
                            cosB = Math.cos(B),
                            sinB = Math.sin(B),
                            t = sinj * cosi2 * cosA - sini * sinA;
                    int x = (int) (40 + 30 * mess * (cosj * cosi2 * cosB - t * sinB)),
                            y = (int) (12 + 15 * mess * (cosj * cosi2 * sinB + t * cosB)),
                            o = x + 80 * y,
                            N = (int) (8 * ((sini * sinA - sinj * cosi * cosA) * cosB - sinj * cosi * sinA - sini * cosA - cosj * cosi * sinB));
                    if(22 > y && y > 0 && x > 0 && 80 > x && mess > z[o]){
                        z[o] = mess;
                        b[o] = new char[]{'.', ',', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@'}[Math.max(N, 0)];
                        b[0] = material.charAt(Math.max(N, 0));
                    }
                }
            }
            System.out.print("\033[H");
            for(k=0; k<1761; k++){
                if(k % 80 > 0){
                    System.out.print(colors[l]+b[k]);
                }else{
                    System.out.print("\033[0m"+"\n");
                    l = rand.nextInt(3);
                }
                System.out.print((k % 80)>0 ? b[k] : 10);
            }
            A += 0.04;
            B += 0.02;
        }
    }
}
