import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = -1;
        ArvoreBinaria arvore = new ArvoreBinaria();
        boolean preferirEsquerda = false; // false = menor da direita (padrão), true = maior da esquerda

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
            "11. Imprimir visualmente\n" +
            "12. Definir preferência de remoção (maior da esquerda/menor da direita)\n" +
            "0. Sair\n" +
            "Sua opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = sc.nextInt();
                    arvore.inserir(valorInserir);
                    System.out.println("Valor " + valorInserir + " inserido.");
                    break;
                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = sc.nextInt();
                    arvore.remover(valorRemover, preferirEsquerda);
                    System.out.println("Valor " + valorRemover + " removido.");
                    break;
                case 3:
                    arvore.removerRaiz(preferirEsquerda);
                    System.out.println("Raiz removida.");
                    break;
                case 4:
                    arvore.removerFolhas();
                    System.out.println("Folhas removidas.");
                    break;
                case 5:
                    arvore.removerNosUmFilho();
                    System.out.println("Nós com um filho removidos.");
                    break;
                case 6:
                    arvore.removerNosDoisFilhos(preferirEsquerda);
                    System.out.println("Nós com dois filhos removidos.");
                    break;
                case 7:
                    System.out.print("Digite o valor a ser buscado: ");
                    int valorBuscar = sc.nextInt();
                    boolean encontrado = arvore.buscar(valorBuscar);
                    if (encontrado)
                        System.out.println("Valor " + valorBuscar + " encontrado.");
                    else
                        System.out.println("Valor " + valorBuscar + " não encontrado.");
                    break;
                case 8:
                    arvore.imprimirEmOrdem();
                    System.out.println("Árvore impressa em ordem.");
                    break;
                case 9:
                    arvore.imprimirPreOrdem();
                    System.out.println("Árvore impressa em pré-ordem.");
                    break;
                case 10:
                    arvore.imprimirPosOrdem();
                    System.out.println("Árvore impressa em pós-ordem.");
                    break;
                case 11:
                    arvore.imprimirVisual();
                    System.out.println("Árvore impressa visualmente.");
                    break;
                case 12:
                    System.out.print("Usar maior da esquerda ao remover nós com dois filhos? (s/n): ");
                    String pref = sc.next();
                    preferirEsquerda = pref.equalsIgnoreCase("s");
                    System.out.println("Preferência atual: " + (preferirEsquerda ? "maior da esquerda" : "menor da direita"));
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
