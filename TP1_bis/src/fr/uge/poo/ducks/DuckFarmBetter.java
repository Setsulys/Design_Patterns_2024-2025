package fr.uge.poo.ducks;

import java.util.Arrays;
import java.util.ServiceLoader;

public class DuckFarmBetter {

	public static void main(String[] args) {
		ServiceLoader<DuckFactory> loader = ServiceLoader.load(fr.uge.poo.ducks.DuckFactory.class);
		var name = Arrays.asList("Riri","Fifi","Loulou");
		var i =0;
		for(var dF : loader) {
			if(i < name.size()) {
				System.out.println(dF.withName(name.get(i++)).quack());
			}
			
		}
	}
}
