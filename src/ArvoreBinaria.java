public class ArvoreBinaria {
    // Nó da árvore binária
    private static class No {
        int valor;
        No esq, dir;
        No(int valor) { this.valor = valor; }
    }

    private No raiz;

    // Inserção
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, int valor) {
        if (no == null) return new No(valor);
        if (valor < no.valor) no.esq = inserirRec(no.esq, valor);
        else if (valor > no.valor) no.dir = inserirRec(no.dir, valor);
        return no;
    }

    // Remoção
    public void remover(int valor, boolean preferirEsquerda) {
        raiz = removerRec(raiz, valor, preferirEsquerda);
    }

    public void remover(int valor) {
        remover(valor, false);
    }

    private No removerRec(No no, int valor, boolean preferirEsquerda) {
        if (no == null) return null;
        if (valor < no.valor) no.esq = removerRec(no.esq, valor, preferirEsquerda);
        else if (valor > no.valor) no.dir = removerRec(no.dir, valor, preferirEsquerda);
        else {
            if (no.esq == null) return no.dir;
            if (no.dir == null) return no.esq;
            if (preferirEsquerda) {
                No temp = maiorNo(no.esq);
                no.valor = temp.valor;
                no.esq = removerRec(no.esq, temp.valor, preferirEsquerda);
            } else {
                No temp = menorNo(no.dir);
                no.valor = temp.valor;
                no.dir = removerRec(no.dir, temp.valor, preferirEsquerda);
            }
        }
        return no;
    }

    private No menorNo(No no) {
        while (no.esq != null) no = no.esq;
        return no;
    }

    private No maiorNo(No no) {
        while (no.dir != null) no = no.dir;
        return no;
    }

    public void removerRaiz(boolean preferirEsquerda) {
        if (raiz != null) raiz = removerRec(raiz, raiz.valor, preferirEsquerda);
    }

    public void removerRaiz() {
        removerRaiz(false);
    }

    public void removerFolhas() {
        raiz = removerFolhasRec(raiz);
    }

    private No removerFolhasRec(No no) {
        if (no == null) return null;
        if (no.esq == null && no.dir == null) return null;
        no.esq = removerFolhasRec(no.esq);
        no.dir = removerFolhasRec(no.dir);
        return no;
    }

    public void removerNosUmFilho() {
        raiz = removerNosUmFilhoRec(raiz);
    }

    private No removerNosUmFilhoRec(No no) {
        if (no == null) return null;
        no.esq = removerNosUmFilhoRec(no.esq);
        no.dir = removerNosUmFilhoRec(no.dir);
        if ((no.esq == null && no.dir != null) || (no.esq != null && no.dir == null)) {
            return (no.esq != null) ? no.esq : no.dir;
        }
        return no;
    }

    public void removerNosDoisFilhos(boolean preferirEsquerda) {
        raiz = removerNosDoisFilhosRec(raiz, preferirEsquerda);
    }

    public void removerNosDoisFilhos() {
        removerNosDoisFilhos(false);
    }

    private No removerNosDoisFilhosRec(No no, boolean preferirEsquerda) {
        if (no == null) return null;
        no.esq = removerNosDoisFilhosRec(no.esq, preferirEsquerda);
        no.dir = removerNosDoisFilhosRec(no.dir, preferirEsquerda);
        if (no.esq != null && no.dir != null) {
            // Remove o nó usando a preferência
            if (preferirEsquerda) {
                No temp = maiorNo(no.esq);
                no.valor = temp.valor;
                no.esq = removerRec(no.esq, temp.valor, preferirEsquerda);
            } else {
                No temp = menorNo(no.dir);
                no.valor = temp.valor;
                no.dir = removerRec(no.dir, temp.valor, preferirEsquerda);
            }
        }
        return no;
    }

    // Busca
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No no, int valor) {
        if (no == null) return false;
        if (valor == no.valor) return true;
        if (valor < no.valor) return buscarRec(no.esq, valor);
        return buscarRec(no.dir, valor);
    }

    // Impressão em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdemRec(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRec(No no) {
        if (no != null) {
            imprimirEmOrdemRec(no.esq);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRec(no.dir);
        }
    }

    // Impressão pré-ordem
    public void imprimirPreOrdem() {
        imprimirPreOrdemRec(raiz);
        System.out.println();
    }

    private void imprimirPreOrdemRec(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            imprimirPreOrdemRec(no.esq);
            imprimirPreOrdemRec(no.dir);
        }
    }

    // Impressão pós-ordem
    public void imprimirPosOrdem() {
        imprimirPosOrdemRec(raiz);
        System.out.println();
    }

    private void imprimirPosOrdemRec(No no) {
        if (no != null) {
            imprimirPosOrdemRec(no.esq);
            imprimirPosOrdemRec(no.dir);
            System.out.print(no.valor + " ");
        }
    }

    // Impressão visual da árvore (raiz à direita, folhas à esquerda)
    public void imprimirVisual() {
        imprimirVisualRec(raiz, 0);
    }

    private void imprimirVisualRec(No no, int nivel) {
        if (no == null) return;
        imprimirVisualRec(no.dir, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print("    ");
        System.out.println(no.valor);
        imprimirVisualRec(no.esq, nivel + 1);
    }
}
