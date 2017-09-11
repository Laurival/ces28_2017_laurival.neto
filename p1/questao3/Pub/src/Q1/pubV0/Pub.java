package Q1.pubV0;


public class Pub {
	// Nomes Que o Pub reconhece os Drinks
	private static final String ONE_BEER = "hansa";
    private	static final String ONE_CIDER = "grans";
    private static final String A_PROPER_CIDER = "strongbow";
    private static final String GT = "gt";
    private static final String BACARDI_SPECIAL = "bacardi_special";
    
	public int computeCost(String drinkName, boolean student, int amount) {
        Drink drink = new Drink(drinkName);
        //Lista de Drincks do PUB
        drink.addRecipe(ONE_BEER, 74);
        drink.addRecipe(ONE_CIDER, 103);
        drink.addRecipe(A_PROPER_CIDER, 110);
        int[] gtRecipe ={3,4,5};
        drink.addRecipe(GT, gtRecipe);
        int[] bacardiRecipe ={0,1,2,5};
        drink.addRecipe(BACARDI_SPECIAL, bacardiRecipe);
        
        // Computação dos preços
        int price = drink.getDrinkPrice();
        if (drink.isSpecial()){
        	if(amount>2){
        		throw new RuntimeException("Too many drinks, max 2.");
            }
        }else{
        	if(student){
        		price = price - price/10;
        	}
        }
        
        return price*amount;
    }
    
 
}
