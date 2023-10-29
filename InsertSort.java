import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        int[] sizes = {50, 500, 1000, 5000, 10000};
        int numExecucao = 5;

        for (int size : sizes) {
            long totalTempoExecucao = 0;
            long totalTrocas = 0;
            long totalIteracoes = 0;

            for (int execucao = 0; execucao < numExecucao; execucao++) {
                int[] array = generateRandomArray(size);

                long tempoInicio = System.nanoTime();
                long trocas = insertSort(array, size);
                long tempoFim = System.nanoTime();
                long duracao = (tempoFim - tempoInicio);

                totalTempoExecucao += duracao;
                totalTrocas += trocas;
                totalIteracoes += size - 1;
            }

            long mediaTempoExecucao = totalTempoExecucao / numExecucao;
            long mediaTrocas = totalTrocas / numExecucao;
            long mediaIteracoes = totalIteracoes / numExecucao;

            System.out.println("Média de tempo de ordenação para " + size + " elementos: " + mediaTempoExecucao + " ns");
            System.out.println("Média de trocas para " + size + " elementos: " + mediaTrocas);
            System.out.println("Média de iterações para " + size + " elementos: " + mediaIteracoes);
            System.out.println();
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    public static int insertSort(int vetor[], int size) {
        int trocas = 0;

        for (int i = 1; i < size; i++) {
            int chave = vetor[i];
            int j = i;

            while (j > 0 && vetor[j - 1] > chave) {
                vetor[j] = vetor[j - 1];
                j--;
                trocas++;
            }

            if (j != i) {
                vetor[j] = chave;
            }
        }

        return trocas;
    }

}
