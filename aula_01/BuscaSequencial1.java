package aula_01;

public class BuscaSequencial1 {
    public static int buscaSequencialInt(Integer[] vetor, Integer valorBusca){
       
        for(int i=0; i < vetor.length; i++){
            if(vetor[i].equals(valorBusca)){
                return i;
            }
        }
        return -1;
    }
    public static int buscaSequencialString(String[] vetor, String valorBusca){
       
        for(int i=0; i < vetor.length; i++){
            if(vetor[i].equals(valorBusca.toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Integer[] nums = {5,7,9,8,1,3,44,66,12};
        System.out.println("Posição do numero 44: "+ buscaSequencialInt(nums, 44));
        System.out.println("Posição do numero 100: "+ buscaSequencialInt(nums, 100));

        String[] frutas = {"laranja", "maça", "pera", "uva", "limão", "mamão", "tangerina"};
        System.out.println("Posição da fruta uva: "+ buscaSequencialString(frutas, "uva"));
        System.out.println("Posição da fruta limão: "+ buscaSequencialString(frutas, "LIMÃO"));
        System.out.println("Posição da fruta morango: "+ buscaSequencialString(frutas, "morango"));
    }

}
