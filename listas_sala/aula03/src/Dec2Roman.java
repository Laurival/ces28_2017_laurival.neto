
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Dec2Roman {

	// esta indirecao extra so para poder trocar as versoes facil!
	// troque conv0 por conv1, conv2, conv10, etc.
	// assim voce pode manter as versoes como metodos da mesma classe.
	public static String conv(int num) {
		return conv12(num);
	}

	// 1 {} -> null
	public static String conv0(int num) {
		return null; // version 0: no test passes.
	}

	// next iteration: one test passes
	// 2 nil -> constant
	public static String conv1(int num) {
		return "I";
	}

	/*********************************************************/
	// 3rd iteration: 2 tests pass
	// 4 Constant -> variable
	// 5 statement -> statements
	// 6 unconditional -> conditional
	public static String conv2(int num) {

		String res = "I";

		if (num > 1) {
			res += "I";
		}

		return res;
	}

	// **************** WHAT YOU HAVE TO DO ****************
	// now write a convX method for each test.
	// each new convX version must make a new test pass
	// BUT PERFORM ONLY THE MINIMUM CHANGES AT EACH STEP
	// *****************************************************

	public static String conv3(int num) {
		if(num>0){
			return "I" + conv(num-1);
		}
		else{
			return "";
		}
	}

	// test 4
	
	public static String conv4(int num){
		LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
		res.put(1,"I");
		res.put(4,"IV");
		
		if(res.containsKey(num)){
			return res.get(num);
		}
		else{
			return res.get(1)+conv(num-1);
		}
		
		
	}
	
	// test 5
	public static String conv5(int num){
		LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
		res.put(1,"I");
		res.put(4,"IV");
		res.put(5,"V");
		
		if(res.containsKey(num)){
			return res.get(num);
		}
		else{
			return res.get(1)+conv(num-1);
		}
	}
	
	// test 8
	public static String conv6(int num){
		LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
		res.put(1,"I");
		res.put(4,"IV");
		res.put(5,"V");
		
		if(res.containsKey(num)){
			return res.get(num);
		}
		else if(num>5) {
			return res.get(5) + conv(num-5);
		}
		else{
			return res.get(1)+conv(num-1);
		}	
	}
	
	// test 10
	public static String conv7(int num){
		LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
		res.put(1,"I");
		res.put(4,"IV");
		res.put(5,"V");
		res.put(9,"IX");
		res.put(10,"X");
		
		if(res.containsKey(num)){
			return res.get(num);
		}
		else if(num>5) {
			return res.get(5) + conv(num-5);
		}
		else{
			return res.get(1)+conv(num-1);
		}	
	}
	
	// test 14
	public static String conv8(int num){
		LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
		res.put(1,"I");
		res.put(4,"IV");
		res.put(5,"V");
		res.put(9,"IX");
		res.put(10,"X");
		
		if(res.containsKey(num)){
			return res.get(num);
		}
		else if(num>10){
			return res.get(10) + conv(num-10);
		}
		else if(num>5) {
			return res.get(5) + conv(num-5);
		}
		else{
			return res.get(1)+conv(num-1);
		}	
	}
	
	// test 44
	public static String conv9(int num){
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(40,"XL");
		map.put(10,"X");
		map.put(9,"IX");
		map.put(5,"V");
		map.put(4,"IV");
		map.put(1,"I");
		
		String res = "";
		for (Entry<Integer,String> entry : map.entrySet()) {
			while (num >= entry.getKey()) {
				res += entry.getValue();
				num -= entry.getKey();
			}
		}
		return res;
	}
	
	// test 100
	public static String conv10(int num){
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(100,"C");
		map.put(90,"XC");
		map.put(50,"L");
		map.put(40,"XL");
		map.put(10,"X");
		map.put(9,"IX");
		map.put(5,"V");
		map.put(4,"IV");
		map.put(1,"I");
		
		String res = "";
		for (Entry<Integer,String> entry : map.entrySet()) {
			while (num >= entry.getKey()) {
				res += entry.getValue();
				num -= entry.getKey();
			}
		}
		return res;
	}
	
	// test 100s
	
	public static String conv11(int num){
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(400,"CD");
		map.put(100,"C");
		map.put(90,"XC");
		map.put(50,"L");
		map.put(40,"XL");
		map.put(10,"X");
		map.put(9,"IX");
		map.put(5,"V");
		map.put(4,"IV");
		map.put(1,"I");
		
		String res = "";
		for (Entry<Integer,String> entry : map.entrySet()) {
			while (num >= entry.getKey()) {
				res += entry.getValue();
				num -= entry.getKey();
			}
		}
		return res;
	}
	
	// test 2008
	public static String conv12(int num){
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(1000,"M");
		map.put(900,"CM");
		map.put(500,"D");
		map.put(400,"CD");
		map.put(100,"C");
		map.put(90,"XC");
		map.put(50,"L");
		map.put(40,"XL");
		map.put(10,"X");
		map.put(9,"IX");
		map.put(5,"V");
		map.put(4,"IV");
		map.put(1,"I");
		
		String res = "";
		for (Entry<Integer,String> entry : map.entrySet()) {
			while (num >= entry.getKey()) {
				res += entry.getValue();
				num -= entry.getKey();
			}
		}
		return res;
	}
}// class Dec2Roman


/*
 * /// EXAMPLE OF HOW TO USE A DICTIONARY! // example of how to use a dictionary
 * to avoid repetition public static String conv4_2(int number) {
 * LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer,
 * String>(); Results.put(1,"I"); Results.put(4,"IV");
 * 
 * if (Results.containsKey(number) ) { return Results.get(number); } return
 * Results.get(1) + conv4_2(number - 1); }
 */
