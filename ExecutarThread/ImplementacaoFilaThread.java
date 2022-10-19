package Thread.ExecutarThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();


    public void add(ObjetoFilaThread objetoFilaThread){
        pilha_fila.add(objetoFilaThread);
    }

    @Override
    public void run(){
       System.out.println("Fila rodando");
      
       while(true){
        
         synchronized(pilha_fila){
            Iterator iteracao = pilha_fila.iterator();
            
            while(iteracao.hasNext()){

            ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
             
            iteracao.remove();

            System.out.println("-----------------------");

            System.out.println(processar.getEmail());
            System.out.println(processar.getNome());

            try {
                Thread.sleep(5000);
            }
             catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
    }
}
