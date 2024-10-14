package editeurDeTexte;

public class Copier implements Command {
    private Buffer buffer;
    private PressePapier pressePapier;
    private Selection selection;

    public Copier(Buffer buffer, PressePapier pressePapier, Selection selection) {
        this.buffer = buffer;
        this.pressePapier = pressePapier;
        this.selection = selection;
    }

    @Override
    public void executer() {
        int[] indices = selection.obtenirSelection();
        String texteACopier = buffer.getTexte(indices[0], indices[1]);
        if (!texteACopier.isEmpty()) {
            pressePapier.copier(texteACopier);
            System.out.println("Texte copié : " + texteACopier);
        } else {
            System.out.println("Erreur : impossible de copier. Sélection invalide.");
        }
    }
}
