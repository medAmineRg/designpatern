package patterns.methodtemplate;

public class Cafe extends Boisson {

    @Override
    protected void ajouterIngredient() {
        System.out.println("Ajouter du café");
    }
}
