package find_all_possible_recipes;

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<List<String>> allIngredients = new ArrayList<>();
        List<String> allRecipes = new ArrayList<>();
        allRecipes.addAll(Arrays.asList(recipes));
        allRecipes.addAll(Arrays.asList(supplies));
        for (int i = 0; i < recipes.length + supplies.length; i++) {
            allIngredients.add(new ArrayList<>());
        }
        for (int i = 0; i < recipes.length; i++) {
            List<String> recipeList = allIngredients.get(i);
            recipeList.addAll(ingredients.get(i));
        }

        int[] state = new int[allRecipes.size()];
        Set<String> suppliesSet = new HashSet<>();

        for (int i = 0; i < allIngredients.size(); i++) {
            if (state[i] == 0) {
                dfs(i, allIngredients, allRecipes, state, suppliesSet);
            }
        }

        List<String> result = new ArrayList<>();

        for (String recipe: recipes) {
            if (suppliesSet.contains(recipe)) result.add(recipe);
        }

        return result;
    }

    private boolean dfs(int node, List<List<String>> allIngredients, List<String> allRecipes, int[] state, Set<String> suppliesSet) {
        if (node == -1) return true;
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;
        List<String> localIngredients = allIngredients.get(node);

        state[node] = 1;
        for (int i = 0; i < localIngredients.size(); i++) {
            int allIngredientIndex = allRecipes.indexOf(localIngredients.get(i));
            if (dfs(allIngredientIndex, allIngredients, allRecipes, state, suppliesSet)) return true;

        }

        state[node] = 2;
        suppliesSet.add(allRecipes.get(node));
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> recipes = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        list1.add("yeast");
        list1.add("flour");

        List<String> list2 = new ArrayList<>();
        list2.add("bread");
        list2.add("meat");

        /*List<String> list3 = new ArrayList<>();
        list3.add("sandwich");
        list3.add("meat");
        list3.add("bread");*/

        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(list1);
        ingredients.add(list2);
        //ingredients.add(list3);

        System.out.println(solution.findAllRecipes(new String[]{"bread","sandwich"}, ingredients, new String[]{"yeast"}));

        /*Solution solution = new Solution();
        List<String> recipes = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        list1.add("yeast");
        list1.add("flour");

        List<String> list2 = new ArrayList<>();
        list2.add("bread");
        list2.add("meat");

        *//*List<String> list3 = new ArrayList<>();
        list3.add("sandwich");
        list3.add("meat");
        list3.add("bread");*//*

        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(list1);
        ingredients.add(list2);
        //ingredients.add(list3);

        System.out.println(solution.findAllRecipes(new String[]{"bread","sandwich"}, ingredients, new String[]{"yeast", "flour", "meat"}));*/
    }
}