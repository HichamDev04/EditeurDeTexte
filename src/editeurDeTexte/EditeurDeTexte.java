package editeurDeTexte;

public class EditeurDeTexte {
    private Buffer buffer;
    private PressePapier pressePapier;
    private Selection selection;

    public EditeurDeTexte(Buffer buffer, PressePapier pressePapier, Selection selection) {
        this.buffer = buffer;
        this.pressePapier = pressePapier;
        this.selection = selection;
    }

    public void executerCommande(Command cmd) {
        cmd.executer();
    }

    public void selectionnerTexte(int debut, int fin) {
        selection.creerSelection(debut, fin);
    }
}
