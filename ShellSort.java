import java.util.Random;

public class ShellSort {
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
                long trocas = shell(array, size);
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

    public static int shell(int[] vetor, int size) {
        int incr, j, k, span, y;
        int trocas = 0;

        for (incr = 0; incr < size; incr++) {
            span = vetor[incr];
            for (j = span; j < size; j++) {
                y = vetor[j];
                for (k = j - span; k >= 0 && y < vetor[k]; k -= span) {
                    vetor[k + span] = vetor[k];
                    trocas++;
                }
                vetor[k + span] = y;
            }
        }
        return trocas;
    }
}
