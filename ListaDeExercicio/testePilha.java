

public class testePilha {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		Integer[] b = new Integer[1];		
		PilhaArray pp=new PilhaArray(1,0);
		System.out.println("inserindo");
		for(int f=0;f<1000000;f++){ // so inserir as variações da quantidade de elementos no for
		  pp.push(f);
		}
		long fim = System.currentTimeMillis();
		long merda = fim - inicio;
		System.out.println(merda);
    }
}
