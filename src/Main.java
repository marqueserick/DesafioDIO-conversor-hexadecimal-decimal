import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String valor;
        valor = leitor.nextLine().toLowerCase(Locale.ROOT);
        while (!valor.equals("-1")) {
            if (valor.length() > 1) {
                if (valor.charAt(0) == '0' && valor.charAt(1) == 'x') {
                    try {
                        System.out.println(converterParaDecimal(valor));
                    }catch (RuntimeException e){
                        System.out.println("Você inseriu caracter inválido");
                    }catch (Exception e){
                        System.out.println("Ocorreu erro inesperado...");
                    }
                } else {
                    try {
                        System.out.println(converterParaHexadecimal(valor));
                    }catch(RuntimeException e){
                        System.out.println("Você inseriu caracter inválido");
                    }catch (Exception e){
                        System.out.println("Ocorreu erro inesperado...");
                    }
                }
            } else {
                try {
                    System.out.println(converterParaHexadecimal(valor));
                }catch(RuntimeException e){
                    System.out.println("Você inseriu caracter inválido");
                }catch (Exception e){
                    System.out.println("Ocorreu erro inesperado...");
                }
            }
            valor = leitor.nextLine().toLowerCase(Locale.ROOT);
        }
    }

    public static String converterParaDecimal(String valor) {
        int tamanho = valor.length() - 2;
        int cursor = 2;
        int resultado = 0;

        for (int i = tamanho - 1; i >= 0; i--) {
            resultado = resultado + valorConvertidoDecimal(valor.charAt(cursor), i);
            cursor++;
        }
        return String.valueOf(resultado);
    }

    public static String converterParaHexadecimal(String valor) {
        int valorAux = 0;
        try {
            valorAux = Integer.parseInt(valor);
        }catch (Exception e){
            throw new RuntimeException("Esse valor não é um inteiro");
        }
        String retorno = "";
        while (valorAux > 15) {
                int resto = (valorAux % 16);
                valorAux = (valorAux - resto) / 16;
                retorno = new StringBuilder(retorno).append(valorConvertidoHexadecimal(resto)).toString();
            }

        retorno += valorConvertidoHexadecimal(valorAux);
        retorno = new StringBuilder(retorno).reverse().toString();

        return "0x"+retorno;
    }

    public static int valorConvertidoDecimal(char c, int potencia) {
        int resultado;
        potencia = (int) Math.pow(16, Double.parseDouble(String.valueOf(potencia)));
        switch (c) {
            case '0':
                resultado = 0;
                break;
            case '1':
                resultado = potencia;
                break;
            case '2':
                resultado = (2 * potencia);
                break;
            case '3':
                resultado = (3 * potencia);
                break;
            case '4':
                resultado = (4 * potencia);
                break;
            case '5':
                resultado = (5 * potencia);
                break;
            case '6':
                resultado = (6 * potencia);
                break;
            case '7':
                resultado = (7 * potencia);
                break;
            case '8':
                resultado = (8 * potencia);
                break;
            case '9':
                resultado = (9 * potencia);
                break;
            case 'a':
                resultado = (10 * potencia);
                break;
            case 'b':
                resultado = (11 * potencia);
                break;
            case 'c':
                resultado = (12 * potencia);
                break;
            case 'd':
                resultado = (13 * potencia);
                break;
            case 'e':
                resultado = (14 * potencia);
                break;
            case 'f':
                resultado = (15 * potencia);
                break;
            default:
                throw new RuntimeException("character inválido");
        }
        return resultado;
    }

    public static String valorConvertidoHexadecimal(int valor) {
        String resultado = "";
        switch (valor) {
            case 0:
                resultado = "0";
                break;
            case 1:
                resultado = "1";
                break;
            case 2:
                resultado = "2";
                break;
            case 3:
                resultado = "3";
                break;
            case 4:
                resultado = "4";
                break;
            case 5:
                resultado = "5";
                break;
            case 6:
                resultado = "6";
                break;
            case 7:
                resultado = "7";
                break;
            case 8:
                resultado = "8";
                break;
            case 9:
                resultado = "9";
                break;
            case 10:
                resultado = "A";
                break;
            case 11:
                resultado = "B";
                break;
            case 12:
                resultado = "C";
                break;
            case 13:
                resultado = "D";
                break;
            case 14:
                resultado = "E";
                break;
            case 15:
                resultado = "F";
                break;
        }
        return resultado;
    }

}
