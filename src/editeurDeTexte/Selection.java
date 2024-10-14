package editeurDeTexte;

public class Selection {
    private int debut;
    private int fin;

    public void creerSelection(int debut, int fin) {
        if (debut >= 0 && fin > debut) {
            this.debut = debut;
            this.fin = fin;
        } else {
            System.out.println("Indices de sélection invalides.");
        }
    }

    public int[] obtenirSelection() {
        return new int[] { debut, fin };
    }
}
