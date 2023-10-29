import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};
        int numExecucoes = 5;

        for (int tamanho : tamanhos) {
            long tempoExecucaoTotal = 0;
            int totalTrocas = 0;
            int totalIteracoes = 0;

            for (int execucao = 0; execucao < numExecucoes; execucao++) {
                int[] vetor = gerarArrayAleatorio(tamanho);

                long tempoInicio = System.nanoTime();
                int trocas = BubbleSort(vetor, tamanho);
                long tempoFim = System.nanoTime();

                tempoExecucaoTotal += (tempoFim - tempoInicio);
                totalTrocas += trocas;
                totalIteracoes += tamanho - 1;
            }

            long tempoExecucaoMedio = tempoExecucaoTotal / numExecucoes;
            int mediaTrocas = totalTrocas / numExecucoes;
            int mediaIteracoes = totalIteracoes / numExecucoes;

            System.out.println("Média de tempo de ordenação para " + tamanho + " elementos: " + tempoExecucaoMedio + " ns");
            System.out.println("Número médio de trocas: " + mediaTrocas);
            System.out.println("Número médio de iterações: " + mediaIteracoes);
            System.out.println();
        }
    }

    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(10000);
        }
        return vetor;
    }

    public static int BubbleSort(int vetor[], int tamanho) {
        int temp, trocas = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 1; j < tamanho - i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    temp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = temp;
                    trocas++;
                }
            }
        }
        return trocas;
    }
}
