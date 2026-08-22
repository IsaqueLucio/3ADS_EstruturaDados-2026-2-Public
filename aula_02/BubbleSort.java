package aula_02;

//import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BubbleSort {

    public static <BS extends Comparable<BS>>void bubbleSort(BS[] vetor){
        
        boolean trocou;

        do{
            trocou = false;
            for (int i=0; i < vetor.length - 1; i++){
                if(vetor[i].compareTo(vetor[i+1]) > 0){
                    BS temp = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = temp;
                    trocou = true;
                }
            }
        } while(trocou);

    }

    public static void main(String[] args) throws IOException{

        /*Integer[] numsDesord = {77, 44, 22, 23, 77, 99, 55, 88, 0 ,66, 11};
        String[] nomesDesord = {"MARIA", "JOÂO", "ANA", "CARLOS", "BEATRIZ"};

        bubbleSort(numsDesord);
        System.out.println(Arrays.toString(numsDesord));

        bubbleSort(nomesDesord);
        System.out.println(Arrays.toString(nomesDesord));*/

        Path caminho = Path.of("data/nomes-desord.txt");
        List<String> lista = Files.readAllLines(caminho);
        String[] nomes = lista.toArray(new String[0]);
        long inicio = System.nanoTime();
        bubbleSort(nomes);
        long fim = System.nanoTime();
        System.out.println("Tempo da ordenação: "+ (fim - inicio) / 1_000_000.0 + " ms");
        long inicioPrint = System.nanoTime();
        for (String nome : nomes) {
            System.out.println(nome);
        }  
        long fimPrint = System.nanoTime();
        System.out.println("Tempo dos print dos 100k de nomes: "+ (fimPrint - inicioPrint) / 1_000_000.0 + " ms");
    }
}
