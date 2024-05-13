package principal;

import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		//Muestra los positivos sin duplicados
		List<Integer> nums=List.of(5,11,4,-22,3,11,5,9,4,6,-3,3,-8);
		nums.parallelStream()
		.distinct()
		.filter(n->n>0)
		.sequential() //Se devuelve el stream a su forma original, sin multitarea. De esta forma
		// imprime los números en su orden normal.
		.forEach(System.out::println); // Imprime todos los números
		

	}

}
