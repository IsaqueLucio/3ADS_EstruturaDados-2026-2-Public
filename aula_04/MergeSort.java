package aula_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeSort {
	// Ordena o array usando o algoritmo Merge Sort.
	public static <MS extends Comparable<MS>> void mergeSort(MS[] vetor) {
		if (vetor.length < 2) {
			return;
		}

		MS[] auxiliar = vetor.clone();
		ordenar(vetor, auxiliar, 0, vetor.length - 1);
	}

	// Divide o vetor, ordena as partes e depois intercala os resultados.
	private static <MS extends Comparable<MS>> void ordenar(
			MS[] vetor, MS[] auxiliar, int inicio, int fim) {
		if (inicio >= fim) {
			return;
		}

		int meio = inicio + (fim - inicio) / 2;
		ordenar(vetor, auxiliar, inicio, meio);
		ordenar(vetor, auxiliar, meio + 1, fim);
		intercalar(vetor, auxiliar, inicio, meio, fim);
	}

	// Junta duas partes já ordenadas em uma única parte ordenada.
	private static <MS extends Comparable<MS>> void intercalar(
			MS[] vetor, MS[] auxiliar, int inicio, int meio, int fim) {
		for (int indice = inicio; indice <= fim; indice++) {
			auxiliar[indice] = vetor[indice];
		}

		int esquerda = inicio;
		int direita = meio + 1;

		for (int indice = inicio; indice <= fim; indice++) {
			if (esquerda > meio) {
				vetor[indice] = auxiliar[direita++];
			} else if (direita > fim) {
				vetor[indice] = auxiliar[esquerda++];
			} else if (auxiliar[esquerda].compareTo(auxiliar[direita]) <= 0) {
				vetor[indice] = auxiliar[esquerda++];
			} else {
				vetor[indice] = auxiliar[direita++];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		//Integer[] numeros = {38, 27, 43, 3, 9, 82, 10};
		//String[] nomes = {"CARLOS", "ANA", "DANIEL", "BEATRIZ"};
        
		//mergeSort(numeros);
		//mergeSort(nomes);

		//System.out.println("Números ordenados: " + java.util.Arrays.toString(numeros));
		//System.out.println("Nomes ordenados: " + java.util.Arrays.toString(nomes));

        Path caminho = Path.of("data/nomes-desord.txt");
        List<String> lista = Files.readAllLines(caminho);
        String[] nomes = lista.toArray(new String[0]);
        long inicio = System.nanoTime();
        mergeSort(nomes);
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
