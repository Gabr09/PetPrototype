package entities;

import javax.swing.JOptionPane;

public class Pet {
    private String nome;
    private int idade;
    private TipoAnimal tipoAnimal;
    private SexoAnimal sexoAnimal;

    public void setNome() {
        String nome;
        boolean entradaValida = false;
        while (!entradaValida) {
            nome = JOptionPane.showInputDialog("Digite o nome do seu pet: ");
            if (nome == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada. \nReinicie o programa.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!nome.isBlank() && nome.matches("[a-zA-Z\\s]+")) {
                this.nome = nome;
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Digite um nome válido!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setIdade() {
        int idade = 0;
        while (true) {
            String entradaIdade = JOptionPane.showInputDialog("Digite a idade do seu pet: ");
            if (entradaIdade == null) {
                continue;
            }
            try {
                idade = Integer.parseInt(entradaIdade);
                if (idade >0 && idade <40) {
                    this.idade = idade;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Digite uma idade válida por favor.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Você deve informar uma idade válida.");
            }
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setTipoAnimal() {
        boolean entradaValida = false;
        while (!entradaValida) {
            String animal = JOptionPane.showInputDialog("""
            Escolha a opção correta para seu pet:
            [1] Para cachorro
            [2] Para gato
            [3] Para coelho
            """);
            if (animal == null || animal.isBlank()) {
                JOptionPane.showMessageDialog(null, "Você deve informar uma opção correta!", "ERRO", JOptionPane.ERROR_MESSAGE);
                continue;
            } else {
                switch (animal.trim()) {
                    case "1":
                        this.tipoAnimal = TipoAnimal.CACHORRO;
                        entradaValida = true;
                        break;
                    case "2":
                        this.tipoAnimal = TipoAnimal.GATO;
                        entradaValida = true;
                        break;
                    case "3":
                        this.tipoAnimal = TipoAnimal.COELHO;
                        entradaValida = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida, digite entre [1], [2] ou [3]", "ERRO", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public SexoAnimal getSexo() {
        return sexoAnimal;
    }

    public void setSexo(SexoAnimal sexoAnimal) {
        boolean entradaValida = false;
        while (!entradaValida) {
            String resposta = JOptionPane.showInputDialog("""
                    Digite a opção que corresponde ao sexo do seu pet:
                    [1] Macho
                    [2] Fêmea
                    """);
            if (resposta == null && resposta.isBlank()) {
                JOptionPane.showMessageDialog(null, "Você deve obrigatoriamente informar o sexo do animal.", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                switch (resposta.trim()) {
                    case "1":
                        sexoAnimal = SexoAnimal.MACHO;
                        entradaValida = true;
                    case "2":
                        sexoAnimal = SexoAnimal.FEMEA;
                        entradaValida = true;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida, escolha entre [1] MACHO ou [2] FEMEA.", "ERRO", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
