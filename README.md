# Alarme de Relógio

Este é um projeto simples de um alarme de relógio desenvolvido em Java.

## ⚠️ Aviso Importante: Arquivo de Áudio do Alarme

Devido a questões de tamanho de repositório e direitos autorais, o arquivo de áudio (música) utilizado para tocar o alarme **não está incluído** neste repositório do GitHub.

Para que o alarme toque um som, você precisará adicionar seu próprio arquivo de áudio e configurar o caminho no código-fonte.

## ⚙️ Configuração e Execução

Siga os passos abaixo para configurar e executar o projeto em sua máquina:

### 1. Clonar o Repositório

```bash
git clone https://github.com/GilvanPedro/Alarme.git
cd Alarme/AlarmeDeRelogio
```

### 2. Adicionar o Arquivo de Áudio

O projeto foi configurado para ler arquivos de áudio no formato **`.wav`** (Waveform Audio File Format), que é o formato recomendado para a API `javax.sound.sampled`.

Você deve colocar seu arquivo `.wav` no diretório raiz do projeto, que é onde o programa será executado.

```bash
# Estando no diretório Alarme/AlarmeDeRelogio/
# Coloque seu arquivo .wav aqui, por exemplo:
# Alarme/AlarmeDeRelogio/meu_alarme.wav
```

### 3. Configurar o Caminho do Arquivo

O arquivo que contém o caminho do áudio é o `Main.java`. Você precisará editá-lo para que a variável `filePath` aponte para o nome do arquivo que você adicionou.

**Arquivo:** `Alarme/AlarmeDeRelogio/src/main/java/br/com/Main.java`

Localize a linha que define a variável `filePath` (aproximadamente na linha 13) e substitua o nome do arquivo existente pelo nome do seu arquivo `.wav`:

```java
// Exemplo de como deve ficar no arquivo Main.java
String filePath = "nome_do_seu_arquivo.wav"; // Substitua pelo nome do seu arquivo
```

### 4. Compilar e Executar (Projeto Maven)

Este é um projeto Maven. Você pode compilá-lo e executá-lo usando seu IDE (como IntelliJ IDEA ou Eclipse) ou via linha de comando.

**Via Linha de Comando (no diretório `Alarme/AlarmeDeRelogio/`):**

1.  **Compilar:**
    ```bash
    mvn clean install
    ```
2.  **Executar:**
    ```bash
    mvn exec:java -Dexec.mainClass="br.com.Main"
    ```

### 5. Uso do Alarme

Após a execução, o programa solicitará que você digite a hora do alarme no formato **HH:mm:ss**.

```
Digite a hora do alarme (HH:mm:ss): 15:30:00
Alarme definido para: 15:30:00
```

Quando o horário for atingido, o alarme será acionado e o áudio começará a tocar. Você pode parar o alarme pressionando **Enter** no console.

---
**Desenvolvido por:** Gilvan Pedro
**Licença:** MIT License
