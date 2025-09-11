package entities;

import javax.swing.JOptionPane;

public class Pet {
    private String nome;
    private int idade;
    private TipoAnimal tipoAnimal;
    private SexoAnimal sexoAnimal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public SexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(SexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public void solicitarNome() {
        boolean entradaValida = false;
        while (!entradaValida) {
            String entradaNome = JOptionPane.showInputDialog("Digite o nome do seu animal: ");
            if (entradaNome == null || entradaNome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Informe o nome do animal para facilitar no gerenciamento interno de consultas", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else if (!entradaNome.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                JOptionPane.showMessageDialog(null, "O nome do animal deve conter apenas letras.", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                setNome(entradaNome);
                entradaValida = true;
            }
        }
    }

    public void setIdade() {
        boolean entradaValida = false;
        while (!entradaValida) {
            String entradaIdade = JOptionPane.showInputDialog("Digite a idade do seu animal: (caso não tenha ainda o primeiro ano de vida, digite 0");
            if (entradaIdade == null) {
                JOptionPane.showMessageDialog(null, "É obrigatório informar a idade do animal.", "ERRO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                int entradaIdade2 = Integer.parseInt(entradaIdade);
                if (entradaIdade2 < 0 || entradaIdade2 > 70) {
                    JOptionPane.showMessageDialog(null, "Digite a idade do seu animal sendo entre 0 e 70 anos.", "ERRO", JOptionPane.WARNING_MESSAGE);
                } else {
                    setIdade(entradaIdade2);
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada, digite a idade corretamente.", "ERRO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void solicitarTipoAnimal() {
        String entradaTipoAnimal;
        boolean entradaValida = false;
        while (!entradaValida) {
            entradaTipoAnimal = JOptionPane.showInputDialog("""
                    Digite qual a classificação do animal que precisa de atendimento
                    [1] Para Mamíferos domésticos (cachorro, gato, roedor, etc)
                    [2] Para Mamíferos de produção (bovino, suíno, equino, caprino, etc)
                    [3] Para aves
                    [4] Para répteis
                    [5] Para Peixes
                    [6] Caso não identificou seu animal nas opções anteriores.""");
            switch (entradaTipoAnimal.trim()) {
                case "1":
                    setTipoAnimal(TipoAnimal.MAMIFEROSDOMESTICOS);
                    entradaValida = true;
            }
        }
    }
}
