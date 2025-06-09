public class ArvoreBinaria {
    private class No {
        int valor;
        No esq, dir;
        No(int valor) { this.valor = valor; }
    }

    private No raiz;

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, int valor) {
        if (no == null) return new No(valor);
        if (valor < no.valor) no.esq = inserirRec(no.esq, valor);
        else if (valor > no.valor) no.dir = inserirRec(no.dir, valor);
        return no;
    }

    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No no, int valor) {
        if (no == null) return null;
        if (valor < no.valor) no.esq = removerRec(no.esq, valor);
        else if (valor > no.valor) no.dir = removerRec(no.dir, valor);
        else {
            if (no.esq == null) return no.dir;
            if (no.dir == null) return no.esq;
            No temp = menorNo(no.dir);
            no.valor = temp.valor;
            no.dir = removerRec(no.dir, temp.valor);
        }
        return no;
    }

    private No menorNo(No no) {
        while (no.esq != null) no = no.esq;
        return no;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No no, int valor) {
        if (no == null) return false;
        if (valor == no.valor) return true;
        if (valor < no.valor) return buscarRec(no.esq, valor);
        return buscarRec(no.dir, valor);
    }

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

    public void removerRaiz() {
        if (raiz != null) raiz = removerRec(raiz, raiz.valor);
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

    public void removerNosDoisFilhos() {
        raiz = removerNosDoisFilhosRec(raiz);
    }

    private No removerNosDoisFilhosRec(No no) {
        if (no == null) return null;
        no.esq = removerNosDoisFilhosRec(no.esq);
        no.dir = removerNosDoisFilhosRec(no.dir);
        if (no.esq != null && no.dir != null) {
            return null;
        }
        return no;
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
