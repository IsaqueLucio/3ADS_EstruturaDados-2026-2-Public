package aula_01;

public class BuscaBinaria1 {
    
    public static int buscaBinariaInt(Integer[] vetor, Integer valorBusca){
        int ini = 0;
        int fim = vetor.length -1;

        while(fim >= ini){
            int meio = (ini + fim) / 2;
            if(valorBusca.equals(vetor[meio])){
                return meio;
            } else if(valorBusca > vetor[meio]){
                ini = meio++;
            } else{
                fim =  meio -1;
            }
            
        }
        return -1;
    }

        public static int buscaBinariaString(String[] vetor, String valorBusca){
        int ini = 0;
        int fim = vetor.length -1;
        valorBusca.toLowerCase();
        while(fim >= ini){
            int meio = (ini + fim) / 2;
            if(valorBusca.equals(vetor[meio])){
                return meio;
            } else if(valorBusca != vetor[meio]){
                ini = meio++;
            } else{
                fim =  meio -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer[] nums = {0,11,22,33,44,55,66,77,88,99};
        String[] names = {"ADAMASTOR", "ALEXANDRE","ANA","CARLOS","DANIEL","MARIA"};
        System.out.println("Posição 66: "+buscaBinariaInt(nums, 66));
        System.out.println("Posição ADAMASTOR: "+ buscaBinariaString(names, "ADAMASTOR"));
    }
}
