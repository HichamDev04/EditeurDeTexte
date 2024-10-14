package editeurDeTexte;

public class Buffer {
    private String contenu;

    public Buffer() {
        this.contenu = "";
    }

    public String getTexte(int debut, int fin) {
        if (debut >= 0 && fin <= contenu.length() && debut < fin) {
            return contenu.substring(debut, fin);
        }
        System.out.println("Indices invalides pour la sélection du texte.");
        return "";
    }

    public void supprimerTexte(int debut, int fin) {
        if (debut >= 0 && fin <= contenu.length() && debut < fin) {
            this.contenu = contenu.substring(0, debut) + contenu.substring(fin);
        } else {
            System.out.println("Indices invalides pour la suppression du texte.");
        }
    }

    public void insererTexte(int position, String texte) {
        if (position >= 0 && position <= contenu.length()) {
            this.contenu = contenu.substring(0, position) + texte + contenu.substring(position);
        } else {
            System.out.println("Position invalide pour l'insertion.");
        }
    }

    public String getContenu() {
        return contenu;
    }
}
