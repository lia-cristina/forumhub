package br.com.alura.forumhub.enums;

public enum Nivel {
    ZERO(0),
    UM(1),
    DOIS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5);

    private final int nivel;

    Nivel(int nivel) {
        this.nivel = nivel;
    }

    public static Nivel buscaPorValor(int nivel) {
        for (Nivel n :Nivel.values()){
            if (n.getValor() == nivel){
                return n;
            }
        }
        throw new RuntimeException("Nível não encontrado");
    }

    public int getValor() {
        return nivel;
    }
}
