package aula_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.util.Arrays;
import java.util.List;

public class QuickSort {
    //metodo public que facilita a chamada: o usuatrio só passa o vetor
    public static <QS extends Comparable<QS>> void quickSort(QS[] vetor){
        //inicia a recursão passando o primeiro(0) e o ultimo indice    
        quickSort(vetor, 0, vetor.length -1);

    }

    //metodo privado recursivo que que define os limites atuais
    private static <PQS extends Comparable<PQS>> void quickSort(PQS[] vetor, int inicio, int fim){
        // se o inicio foi menor do que o fim, signfica que ainda há elementos para ordenar
        if(inicio < fim){
            //reorganiza o vetor e encontra a posição correta do pivô
            int pivo = particionar(vetor, inicio, fim);
            //ordena a sub-lista á esquerda do pivô(menores)
            quickSort(vetor, inicio, pivo - 1);
            //ordena a sub-lista á direita do pivô(maiores)
            quickSort(vetor, pivo + 1, fim);
        }
    }    
    // metodo privado que organiza os elementos entorno do pivô
    private static <PT extends Comparable<PT>> int particionar(PT[] vetor, int inicio, int fim){
        //escolha o ultimo elemento como pivô
        PT pivo = vetor[fim];
        // "i" rastreia a posiçao do ultimo elemento menor do que o pivô encontrado
        int i = inicio - 1;
        //"j" percorre o vetor do inicio até o prenultimo elemento
        for(int j = inicio; j < fim; j++){
            //compara o elemento atual "i" com o pivô
            //compareTO < 0 signiica que o vetor[j] é menor do que o pivô
            if(vetor[j].compareTo(pivo) < 0){
                //avança um indice do "limite dos menores"
                i++;
                //joga o elemento menor para a esquerda
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i+1, fim);

        return i+1;

    }

    private static <TR extends Comparable<TR>> void trocar(TR[] vetor, int i, int j){
        TR temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static void main(String[] args) throws IOException{

        //Integer[] nums = {77, 44, 22, 33, 99, 55, 0, 66, 11};
        //String[] nomesDesord = {"Maria", "João", "Ana", "Carlos", "Beatriz"};

        //quickSort(nums);
        //.out.println("Numeros ordenados: "+Arrays.toString(nums));
        //quickSort(nomesDesord);
        //System.out.println("Nomes ordenados: "+Arrays.toString(nomesDesord));

        Path caminho = Path.of("data/nomes-desord.txt");
        List<String> lista = Files.readAllLines(caminho);
        String[] nomes = lista.toArray(new String[0]);
        long inicio = System.nanoTime();
        quickSort(nomes);
        long fim = System.nanoTime();
        System.out.println("Tempo da ordenação: "+ (fim - inicio) / 1_000_000_000.0 + " ms");
        long inicioPrint = System.nanoTime();
        for (String nome : nomes) {
            System.out.println(nome);
        }  
        long fimPrint = System.nanoTime();
        System.out.println("Tempo dos print dos 100k de nomes: "+ (fimPrint - inicioPrint) / 1_000_000_000.0 + " ms");
    }

}
