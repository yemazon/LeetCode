package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 */
public class Chef {

    private static final double DECAYING_TIME_COEFFICIENT = 0.5;

    public static void main(String[] args) {

        Oven oven = new Oven(300);
        SousChef sousChef = new SousChef(oven);

        PotRoast potRoast = new PotRoast();
        Baguette firstBaguette = new Baguette(DECAYING_TIME_COEFFICIENT);
        Baguette secondBaguette = new Baguette(DECAYING_TIME_COEFFICIENT);
        RoastedSweetPotato roastedSweetPotato = new RoastedSweetPotato();

        startToCook(oven, sousChef, potRoast);
        startToCook(oven, sousChef, firstBaguette);
        startToCook(oven, sousChef, roastedSweetPotato);
        startToCook(oven, sousChef, secondBaguette);
    }

    private static void startToCook(Oven oven, SousChef sousChef, Recipe recipe) {

        recipe.initializeFromOven(oven);

        sousChef.prepare(recipe, new RecipeReadyCallback() {
            @Override
            public void recipeReadyToCook(Recipe recipe) {
                cookRecipe(recipe, oven,true);
            }
        });
    }

    private static void cookRecipe(Recipe recipe, Oven oven, boolean putInOven) {
        oven.cook(recipe, new Timer() {
            @Override
            public void update(Time unit, int value, int ovenTemperature) {
                checkStatus(recipe, oven, unit, value, ovenTemperature);
            }}, putInOven);
    }

    private static void checkStatus(Recipe recipe, Oven oven, Time unit, int value, int ovenTemperature) {
        recipe.adjust(unit, value, ovenTemperature);
        if (!recipe.isRecipeDone()) {
            cookRecipe(recipe, oven, false);
        } else {
            oven.takeOut(recipe);
        }
    }
}