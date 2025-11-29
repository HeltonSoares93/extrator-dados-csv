import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtratorDadosDinamico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Desenvolvedor: Helton Soares - hgsdl@live.com");
        System.out.println("==================================================");
        System.out.println("   EXTRATOR DE DADOS CSV - GABINETE DEP. ROMERO   ");
        System.out.println("==================================================\n");

        System.out.print("Digite o caminho do arquivo de origem: ");
        String entradaUsuario = sc.nextLine();
        String arquivoEntrada = entradaUsuario.replace("\"", "");

        System.out.print("Digite a palavra-chave para buscar (ex: Caruaru, Recife): ");
        String termoBusca = sc.nextLine().trim();

        if (termoBusca.isEmpty()) {
            System.out.println("Erro: A palavra-chave não pode ser vazia.");
            sc.close();
            return;
        }

        File arquivoOriginal = new File(arquivoEntrada);

        String pastaDestino = arquivoOriginal.getParent();

        if (pastaDestino == null) {
            pastaDestino = ".";
        }

        String nomeArquivoGerado = "relatorio_" + termoBusca.toLowerCase().replaceAll("\\s+", "_") + ".csv";

        String arquivoSaida = pastaDestino + File.separator + nomeArquivoGerado;

        String divisorEntrada = ";";
        String divisorSaida = ";";

        System.out.println("\nIniciando busca por: '" + termoBusca.toUpperCase() + "'");
        System.out.println("Lendo arquivo...");

        long inicio = System.currentTimeMillis();
        int count = 0;

        try (
                BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
                BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {
            String linha;
            while ((linha = br.readLine()) != null) {

                if (linha.toUpperCase().contains(termoBusca.toUpperCase())) {

                    String[] colunas = linha.split(divisorEntrada);
                    String linhaCSV = String.join(divisorSaida, colunas);

                    bw.write(linhaCSV);
                    bw.newLine();

                    count++;
                }
            }

        } catch (IOException e) {
            System.err.println("ERRO CRÍTICO: " + e.getMessage());

            if (e.getMessage().contains("sistema não pode encontrar")) {
                System.out.println("DICA: Verifique se o caminho do arquivo está correto.");
            }
        }

        long fim = System.currentTimeMillis();

        System.out.println("\n------------------------------------------------");
        if (count > 0) {
            System.out.println("SUCESSO! Exportação finalizada.");
            System.out.println("Linhas encontradas: " + count);
            System.out.println("Tempo de processamento: " + (fim - inicio) + "ms");
            System.out.println("Arquivo salvo em: " + arquivoSaida);
        } else {
            System.out.println("AVISO: Nenhuma linha contendo '" + termoBusca + "' foi encontrada.");

            new File(arquivoSaida).delete();
        }
        System.out.println("------------------------------------------------");

        sc.close();
    }
}