import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha a moeda de origem:");
        menu.opcoesDeMoedas();
        String converterDe = escolherMoeda("origem", sc);

        System.out.println("Escolha a moeda de destino:");
        menu.opcoesDeMoedas();
        String converterPara = escolherMoeda("destino", sc);

        System.out.println("Digite o valor em " + converterDe + " para converter em " + converterPara);
        double quantia = obterQuantia(sc, converterDe);

        Referencias referencias = new Referencias(converterDe, converterPara, quantia);
        ConversorApi.converterMoeda(referencias);

        sc.close();
    }

    private static String escolherMoeda(String tipo, Scanner sc) {
        while (true) {
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1: return "ARS";
                case 2: return "BOB";
                case 3: return "BRL";
                case 4: return "CLP";
                case 5: return "COP";
                case 6: return "USD";
                default:
                    System.out.println("Digite um número válido entre 1 a 6 para a moeda de " + tipo + ".");
            }
        }
    }

    private static double obterQuantia(Scanner sc, String moeda) {
        while (true) {
            try {
                System.out.print("Digite o valor em " + moeda + ": ");
                String valor = sc.next().replace(',', '.');
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido.");
            }
        }
    }
}