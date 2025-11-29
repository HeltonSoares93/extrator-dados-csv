# 📂 Extrator de Dados CSV (High Performance) - Gabinete Dep. Romero Albuquerque

Este é um utilitário de linha de comando (CLI) desenvolvido em Java para realizar a extração e filtragem de grandes volumes de dados de arquivos de texto/CSV.

## 🎯 Motivação e Contexto

O desenvolvimento desta ferramenta surgiu de uma necessidade crítica da assessoria de T.I.: manipular e analisar bases de dados governamentais massivas, frequentemente com tamanhos superiores a **8GB**.

As ferramentas de planilhas tradicionais apresentavam limitações bloqueantes:

  * **Microsoft Excel / Google Sheets:** Possuem limites rígidos de linhas (aprox. 1 milhão) e travam ao tentar carregar arquivos dessa magnitude na memória RAM.
  * **Performance:** A abertura desses arquivos, quando possível, tornava-se inviável devido à lentidão extrema.

**A Solução:** Este software foi escrito para **não possuir limitações de tamanho de arquivo**. Ele utiliza uma abordagem de leitura em fluxo (*stream processing*), processando linha por linha sem carregar o arquivo inteiro na memória, permitindo extrair dados específicos de arquivos de qualquer tamanho (10GB, 50GB, etc.) em questão de segundos.

## 🚀 Funcionalidades Principais

  * **Processamento de Big Data:** Capaz de ler arquivos de texto gigantescos (GBs) com consumo mínimo de memória.
  * **Caminho Inteligente (Smart Pathing):** O relatório gerado é salvo automaticamente **na mesma pasta** do arquivo original, facilitando a organização.
  * **Filtragem Dinâmica:** Busca por palavras-chave (Case Insensitive - ignora maiúsculas/minúsculas).
  * **Sanitização de Entrada:** Corrige automaticamente caminhos copiados do Windows com aspas.
  * **Output Compatível:** Gera arquivos `.csv` formatados com separadores (`;`) prontos para serem importados em Bancos de Dados ou visualizados no Excel (apenas as linhas filtradas).

## 🛠️ Pré-requisitos

  * **Java Development Kit (JDK):** Versão 8 ou superior instalada.

## 📦 Como Usar

### 1\. Compilação

No terminal, dentro da pasta do projeto:

```bash
javac ExtratorDadosDinamico.java
```

### 2\. Execução

Rode o programa:

```bash
java ExtratorDadosDinamico
```

### 3\. Exemplo de Uso

O programa solicitará o arquivo e o termo de busca.

```text
==================================================
   EXTRATOR DE DADOS CSV - GABINETE DEP. ROMERO   
==================================================

Digite o caminho do arquivo de origem: "S:\Dados_Publicos\Base_Completa_8GB.TXT"
Digite a palavra-chave para buscar: Caruaru

Iniciando busca por: 'CARUARU'
Lendo arquivo...

------------------------------------------------
SUCESSO! Exportação finalizada.
Linhas encontradas: 4.520
Tempo de processamento: 840ms
Arquivo salvo em: S:\Dados_Publicos\relatorio_caruaru.csv
------------------------------------------------
```

## ⚙️ Detalhes Técnicos

  * **I/O Otimizado:** Utiliza `BufferedReader` e `BufferedWriter` para garantir alta performance de disco.
  * **Delimitador:** Padronizado para ponto e vírgula (`;`), seguindo a norma regional brasileira.
  * **Portabilidade:** O código detecta automaticamente o separador de diretórios do sistema operacional (`\` Windows ou `/` Linux).

## 📝 Autor e Manutenção

  * **Desenvolvedor:** Helton Soares
  * **Contato:** hgsdl@live.com
  * **Função:** Assessoria de T.I. e Banco de Dados

-----
