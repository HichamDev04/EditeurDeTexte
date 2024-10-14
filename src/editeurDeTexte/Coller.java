package editeurDeTexte;

public class Coller implements Command {
    private Buffer buffer;
    private PressePapier pressePapier;
    private int position;

    public Coller(Buffer buffer, PressePapier pressePapier) {
        this.buffer = buffer;
        this.pressePapier = pressePapier;
    }

    public void definirPosition(int position) {
        this.position = position;
    }

    @Override
    public void executer() {
        String texteAColler = pressePapier.coller();
        if (!texteAColler.isEmpty()) {
            buffer.insererTexte(position, texteAColler);
            System.out.println("Texte collé : " + texteAColler);
        } else {
            System.out.println("Le presse-papier est vide. Impossible de coller.");
        }
    }
}
