import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        do {
            System.out.print("\n--- ÁRVORE BINÁRIA ---\n" +
            "Escolha uma opção:\n" +
            "1. Inserir\n" +
            "2. Remover\n" +
            "3. Remover raiz\n" +
            "4. Remover folhas\n" +
            "5. Remover nós com um filho\n" +
            "6. Remover nós com dois filhos\n" +
            "7. Buscar\n" +
            "8. Imprimir em ordem\n" +
            "9. Imprimir em pré-ordem\n" +
            "10. Imprimir em pós-ordem\n" +
            "0. Sair\n" +
            "Sua opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = sc.nextInt();
                    // Chamada para inserir o valor na árvore
                    System.out.println("Valor " + valorInserir + " inserido.");
                    break;
                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = sc.nextInt();
                    // Chamada para remover o valor da árvore
                    System.out.println("Valor " + valorRemover + " removido.");
                    break;
                case 3:
                    // Chamada para remover a raiz da árvore
                    System.out.println("Raiz removida.");
                    break;
                case 4:
                    // Chamada para remover folhas da árvore
                    System.out.println("Folhas removidas.");
                    break;
                case 5:
                    // Chamada para remover nós com um filho
                    System.out.println("Nós com um filho removidos.");
                    break;
                case 6:
                    // Chamada para remover nós com dois filhos
                    System.out.println("Nós com dois filhos removidos.");
                    break;
                case 7:
                    System.out.print("Digite o valor a ser buscado: ");
                    int valorBuscar = sc.nextInt();
                    // Chamada para buscar o valor na árvore
                    System.out.println("Valor " + valorBuscar + " encontrado.");
                    break;
                case 8:
                    // Chamada para imprimir em ordem
                    System.out.println("Árvore impressa em ordem.");
                    break;
                case 9:
                    // Chamada para imprimir em pré-ordem
                    System.out.println("Árvore impressa em pré-ordem.");
                    break;
                case 10:
                    // Chamada para imprimir em pós-ordem
                    System.out.println("Árvore impressa em pós-ordem.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (op != 0);
        
        sc.close();
    }
}
