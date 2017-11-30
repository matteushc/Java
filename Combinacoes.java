public class Combinacoes {

	public static void main(String[] args) {
		String values = "12";
		int casasTabuleiro = 5;
		String acumulador = "";
		buscar(values, casasTabuleiro, 0, acumulador);
	}
	
	public static void buscar(String values, int total, int count, String acumulador){
		
		if(count == total){
			System.out.println(acumulador);
		}else{
			for (int i = 0; i < values.length(); i++) {
				acumulador += values.charAt(i);
				count = countValores(acumulador);
				if(count <= total){
					buscar(values, total, count, acumulador);
				}
				acumulador = acumulador.substring(0, acumulador.length() -1);
			}
		}
	}
	static int countValores(String valores){
		int count = 0;
		for (int i = 0; i < valores.length(); i++) {
			count += Integer.parseInt(String.valueOf(valores.charAt(i)));
		}
		
		return count;
	}
	
	
	/**
	 * Gera combinaçoes com repetição de um determinado conjunto
	 * 
	 * @param input
	 * @param depth
	 * @param output
	 */
	static void brute(String input, int depth, StringBuffer output) {
        if (depth == 0) {
            System.out.println(output);
        } else {
            for (int i = 0; i < input.length(); i++) {
                output.append(input.charAt(i));
                brute(input, depth - 1, output);
                output.deleteCharAt(output.length() - 1);
            }
        }
    }
	
	
	/**
	 * Gera combinaçoes com repetição de um determinado conjunto baseado 
	 * no calculo de cada elemento resultando no valor de count 
	 * @param input
	 * @param decrease
	 * @param output
	 * @param total
	 */
	static void generateCombination(String input, int decrease, StringBuffer output, int total) {
		if (decrease != 0) {
            for (int i = 0; i < input.length(); i++) {
                output.append(input.charAt(i));
                int c = countValores(output);
                if(c == total){
                	System.out.println(output.toString());
                }
                generateCombination(input, decrease - 1, output, total);
                output.deleteCharAt(output.length() - 1);
            }
        }
    }
	
	static int countValores(StringBuffer valores){
		String v = valores.toString();
		
		int count = 0;
		for (int i = 0; i < v.length(); i++) {
			count += Integer.parseInt(String.valueOf(v.charAt(i)));
		}
		
		return count;
	}
	
}
