package patterns.methodtemplate;

public abstract class Boisson {

    // Template Method (la recette)
    public final void preparer() {
        bouillirEau();
        ajouterIngredient(); // varie
        servir();
    }

    private void bouillirEau() {
        System.out.println("Faire bouillir l'eau");
    }

    protected abstract void ajouterIngredient();

    private void servir() {
        System.out.println("Servir la boisson");
    }

}
