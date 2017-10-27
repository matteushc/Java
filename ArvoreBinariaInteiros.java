import java.util.ArrayDeque;
import java.util.Deque;


public class ArvoreBinariaInteiros {
	private int valorNo;
    private ArvoreBinariaInteiros subarvoreEsquerda;
    private ArvoreBinariaInteiros subarvoreDireita;

    public ArvoreBinariaInteiros(int valorNo)
    {
        this.valorNo = valorNo;
        this.subarvoreEsquerda = null;
        this.subarvoreDireita = null;
    }

    public void inserirItem(int item)
    {
         int valorNoAtual = valorNo;
         if ( item < valorNoAtual )
         {
             if (subarvoreEsquerda == null) 
             {
                 subarvoreEsquerda = new ArvoreBinariaInteiros(item);
             }
             else
             {
                 subarvoreEsquerda.inserirItem(item);
             }
         }
         else
         {
             if (subarvoreDireita == null)
             {
                 subarvoreDireita = new ArvoreBinariaInteiros(item);
             }
             else
             {
                 subarvoreDireita.inserirItem(item);
             }
         }
    }
    
    public static void emOrdem(ArvoreBinariaInteiros no) {
        if (no != null) {
            emOrdem(no.subarvoreEsquerda);
            System.out.println(no.valorNo);
            emOrdem(no.subarvoreDireita);
        }
    }
    
    public static void preOrdem(ArvoreBinariaInteiros no) {
        if (no != null){
            System.out.println(no.valorNo);
            preOrdem(no.subarvoreEsquerda);
            preOrdem(no.subarvoreDireita);
        }
    }
    
    /**
     * Metodo para percorrer uma arvore binaria e listar todos os niveis na mesma linha
     * @param no
     */
    public static void walkLevels(ArvoreBinariaInteiros no) {
    	if (no == null) throw new IllegalArgumentException("No nó não pode ser null");
        Deque<ArvoreBinariaInteiros> fila = new ArrayDeque<ArvoreBinariaInteiros>();
        fila.add(no);
        while (!fila.isEmpty()) {
        	ArvoreBinariaInteiros atual = fila.removeFirst();
            System.out.printf("%s, ", atual.valorNo);
            if (atual.subarvoreEsquerda != null) 
            	fila.add(atual.subarvoreEsquerda);
            if (atual.subarvoreDireita != null) 
            	fila.add(atual.subarvoreDireita);
        }
        
    }
    
    /**
     * Metodo para percorrer uma arvore binaria e listar todos os niveis em linhas diferentes
     * @param no
     */
    public static void walkLevels2(ArvoreBinariaInteiros no) {
    	if (no == null) throw new IllegalArgumentException("No nó não pode ser null");
        Deque<ArvoreBinariaInteiros> fila = new ArrayDeque<ArvoreBinariaInteiros>();
        fila.add(no);
        
        int count = fila.size();
        while (count > 0) {
        	
        	for (int i = 0; i < count; i++) {
        		ArvoreBinariaInteiros atual = fila.removeFirst();
                System.out.printf("%s, ", atual.valorNo);
                if (atual.subarvoreEsquerda != null) 
                	fila.add(atual.subarvoreEsquerda);
                if (atual.subarvoreDireita != null) 
                	fila.add(atual.subarvoreDireita);
			}
        	 System.out.println();
        	 count = fila.size();
        }
        
    }

    
    public static void main(String[] args) {
    	
    	ArvoreBinariaInteiros arvore = new ArvoreBinariaInteiros(2);
    	
//    	arvore.subarvoreDireita = new ArvoreBinariaInteiros(7);
//    	arvore.subarvoreDireita.subarvoreEsquerda = new ArvoreBinariaInteiros(6);
//    	arvore.subarvoreDireita.subarvoreDireita = new ArvoreBinariaInteiros(2);
//    	arvore.subarvoreDireita.subarvoreEsquerda.subarvoreDireita = new ArvoreBinariaInteiros(5);
//    	arvore.subarvoreDireita.subarvoreEsquerda.subarvoreEsquerda= new ArvoreBinariaInteiros(11);
//    	
//    	arvore.subarvoreEsquerda = new ArvoreBinariaInteiros(5);
//    	arvore.subarvoreEsquerda.subarvoreEsquerda = new ArvoreBinariaInteiros(9);
//    	arvore.subarvoreEsquerda.subarvoreEsquerda.subarvoreEsquerda = new ArvoreBinariaInteiros(4);
    	
//    	arvore.inserirItem(2);
    	arvore.inserirItem(7);
    	arvore.inserirItem(5);
    	arvore.inserirItem(9);
    	arvore.inserirItem(2);
    	arvore.inserirItem(6);
    	arvore.inserirItem(4);
    	arvore.inserirItem(11);
    	arvore.inserirItem(5);
    	
    	
		//emOrdem(arvore);
		//preOrdem(arvore);
		walkLevels2(arvore);
		
	}
}
