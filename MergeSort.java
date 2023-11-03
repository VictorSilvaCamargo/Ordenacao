import java.util.Random;

public class MergeSort {
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
                int trocas = mergeSort(vetor, tamanho);
                long tempoFim = System.nanoTime();

                tempoExecucaoTotal += (tempoFim - tempoInicio);
                totalTrocas += trocas;
                totalIteracoes += tamanho - 1;
            }

            long mediaTempoExecucao = tempoExecucaoTotal / numExecucoes;
            int mediaTrocas = totalTrocas / numExecucoes;
            int mediaIteracoes = totalIteracoes / numExecucoes;

            System.out.println("Média de tempo de ordenação para " + tamanho + " elementos: " + mediaTempoExecucao + " ns");
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

    public static int mergeSort(int[] vetor, int tamanho) {
        int trocas = 0;
        int tamanhoAtual;

        for (tamanhoAtual = tamanho / 2; tamanhoAtual > 0; tamanhoAtual /= 2) {
            for (int esquerda = 0; esquerda < tamanho - 1; esquerda += 2 * tamanhoAtual) {
                int meio = esquerda + tamanhoAtual - 1;
                int direita = esquerda + 2 * tamanhoAtual - 1;
                if (meio >= tamanho - 1) {
                    meio = tamanho - 1;
                }
                if (direita >= tamanho - 1) {
                    direita = tamanho - 1;
                }
                trocas += merge(vetor, esquerda, meio, direita);
            }
        }

        return trocas;
    }

    public static int merge(int[] vetor, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] vetorEsquerda = new int[n1];
        int[] vetorDireita = new int[n2];

        for (int i = 0; i < n1; i++) {
            vetorEsquerda[i] = vetor[esquerda + i];
        }
        for (int j = 0; j < n2; j++) {
            vetorDireita[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0, k = esquerda, trocas = 0;

        while (i < n1 && j < n2) {
            if (vetorEsquerda[i] <= vetorDireita[j]) {
                vetor[k] = vetorEsquerda[i];
                i++;
            } else {
                vetor[k] = vetorDireita[j];
                j++;
                trocas++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = vetorEsquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = vetorDireita[j];
            j++;
            k++;
        }

        return trocas;
    }
}