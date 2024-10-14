package editeurDeTexte;

public class Couper implements Command {
    private Buffer buffer;
    private PressePapier pressePapier;
    private Selection selection;

    public Couper(Buffer buffer, PressePapier pressePapier, Selection selection) {
        this.buffer = buffer;
        this.pressePapier = pressePapier;
        this.selection = selection;
    }

    @Override
    public void executer() {
        int[] indices = selection.obtenirSelection();
        String texteACouper = buffer.getTexte(indices[0], indices[1]);
        if (!texteACouper.isEmpty()) {
            pressePapier.copier(texteACouper);
            buffer.supprimerTexte(indices[0], indices[1]);
            System.out.println("Texte coupé : " + texteACouper);
        } else {
            System.out.println("Erreur : impossible de couper. Sélection invalide.");
        }
    }
}
