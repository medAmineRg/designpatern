package patterns.methodtemplate;

public class The extends Boisson {

    @Override
    protected void ajouterIngredient() {
        System.out.println("Ajouter du thé");
    }
}
