package Q1.pubV0;

import java.util.LinkedHashMap;

public class Drink {
	private int[] ingredients = {65,10,10,10,20,85};
	private String drinkName;
    private static final String GT = "gt";
    private static final String BACARDI_SPECIAL = "bacardi_special";
    LinkedHashMap<String, Integer> recipes = new LinkedHashMap<String, Integer>();
    
    public Drink(String drinkName) {
		super();
		this.drinkName = drinkName;
	}
        
    public int getDrinkPrice(){
    	if(recipes.containsKey(drinkName)){
			return recipes.get(drinkName);
		}
    	else{
    		throw new RuntimeException("No such drink exists");
    	}
    }
	public int[] getIngredients() {
		return ingredients;
	}
	public void addIngredients(int newIngredients) {
		this.ingredients[ingredients.length-1]= newIngredients;
	}
	
	public void addRecipe(String Name, int price){
		recipes.put(Name, price);
	}
	public void addRecipe(String Name, int[] ingrediente){
		int price=0;
		for(int i : ingrediente){
			price += ingredients[i];
		}
		recipes.put(Name, price);
	}
	
	public boolean isSpecial() {
		if(drinkName.equals(BACARDI_SPECIAL)|drinkName.equals(GT))
			return true;
		return false;
	}



	
}
