package editeurDeTexte;

public class Bouton {
    private Command commande;

    public Bouton(Command commande) {
        this.commande = commande;
    }

    public void clic() {
        commande.executer();
    }
}


