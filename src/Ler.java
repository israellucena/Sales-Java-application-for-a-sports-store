//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ler {
    public Ler() {
    }

    public static String umaString() {
        String s = "";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
        } catch (IOException var2) {
            System.out.println("Erro ao ler fluxo de entrada.");
        }

        return s;
    }

    public static int umInt() {
        while(true) {
            try {
                return Integer.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("Não é um inteiro válido!!!");
            }
        }
    }

    public static double umDouble() {
        while(true) {
            try {
                return Double.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("Não é um double válido!!!");
            }
        }
    }

    public static char umChar() {
        while(true) {
            try {
                return umaString().charAt(0);
            } catch (Exception var1) {
                System.out.println("Não é um char válido!!!");
            }
        }
    }

    public static byte umByte() {
        while(true) {
            try {
                return Byte.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("Não é um byte válido!!!");
            }
        }
    }

    public static short umShort() {
        while(true) {
            try {
                return Short.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("Não é um short válido!!!");
            }
        }
    }

    public static long umLong() {
        while(true) {
            try {
                return Long.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("Não é um long válido!!!");
            }
        }
    }

    public static float umFloat() {
        while(true) {
            try {
                return Float.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("Não é um float válido!!!");
            }
        }
    }

    public static boolean umBoolean() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            try {
                return Boolean.parseBoolean(br.readLine());
            } catch (Exception var2) {
                System.out.println("Não é um boolean válido!!!");
            }
        }
    }

    public static double umPositivo(double x) {
        while(x < 0){
            System.out.println("O valor não é valido, insira novamente:");
            x = umDouble();
        }
        return x;
    }

    public static double umDesconto(double desconto, double preco){
        while(desconto < 0 || desconto > preco){
            System.out.println("O valor não é valido, insira novamente:");
            desconto = umDouble();
        }
        return desconto;
    }
}
