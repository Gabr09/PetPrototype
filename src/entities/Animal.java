package entities;

import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Animal {
    private String nome;
    private int idAnimal;
    private int idade;
    private TipoAnimal tipoAnimal;
    private SexoAnimal sexoAnimal;
    private static final Set<Integer> idsUsados = new HashSet<>();

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

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void solicitarNome() {
        boolean entradaValida = false;
        while (!entradaValida) {
            String entradaNome = JOptionPane.showInputDialog("Digite o nome do seu animal: ");
            if (entradaNome == null || entradaNome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Informe o nome do animal para facilitar no gerenciamento interno de consultas", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else if (!entradaNome.matches("^[A-Za-zÀ-ÿ\\s\\-']+$")) {
                JOptionPane.showMessageDialog(null, "O nome do animal deve conter apenas letras.", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                setNome(entradaNome);
                entradaValida = true;
            }
        }
    }

    public void criarId() {
        int novoId;
        do {
            novoId = (int) (Math.random() * 1000) + 1;
        } while (idsUsados.contains(novoId));
        idsUsados.add(novoId);
        this.idAnimal = novoId;
    }

    public void solicitarIdade() {
        while (true) {
            String entradaIdade = JOptionPane.showInputDialog("Digite a idade do seu animal: (caso não tenha ainda o primeiro ano de vida, digite 0)");
            if (entradaIdade == null) {
                int confirm = JOptionPane.showConfirmDialog(null, "Você deseja cancelar o cadastro da idade?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    setIdade(0);
                    break;
                } else {
                    continue;
                }
            }
            try {
                int idade = Integer.parseInt(entradaIdade);
                if (idade < 0 || idade > 100) {
                    JOptionPane.showMessageDialog(null, "Digite a idade do seu animal sendo entre 0 e 100 anos.", "ERRO", JOptionPane.WARNING_MESSAGE);
                } else {
                    setIdade(idade);
                    break;
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
                    break;
                case "2":
                    setTipoAnimal(TipoAnimal.MAMIFEROSDEPRODUCAO);
                    entradaValida = true;
                    break;
                case "3":
                    setTipoAnimal(TipoAnimal.AVES);
                    entradaValida = true;
                    break;
                case "4":
                    setTipoAnimal(TipoAnimal.REPTEIS);
                    entradaValida = true;
                    break;
                case "5":
                    setTipoAnimal(TipoAnimal.PEIXES);
                    entradaValida = true;
                    break;
                case "6":
                    setTipoAnimal(TipoAnimal.OUTROS);
                    entradaValida = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Você só pode escolher entre as opções acima.", "ERRO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void solicitarSexoAnimal() {
        String entradaSexo;
        boolean entradaValida = false;
        while (!entradaValida) {
            entradaSexo = JOptionPane.showInputDialog("""
                    Sexo do animal:
                    [1] Para macho
                    [2] Para fêmea""");
            switch (entradaSexo.trim()) {
                case "1":
                    setSexoAnimal(SexoAnimal.MACHO);
                    entradaValida = true;
                    break;
                case "2":
                    setSexoAnimal(SexoAnimal.FEMEA);
                    entradaValida = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, digite uma das opções [1] para macho ou [2] para fêmea");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return idade == animal.idade && idAnimal == animal.idAnimal && Objects.equals(nome, animal.nome) && tipoAnimal == animal.tipoAnimal && sexoAnimal == animal.sexoAnimal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, tipoAnimal, sexoAnimal, idAnimal);
    }

    @Override
    public String toString() {
        return "Nome do animal cadastrado: " + getNome()
                + "\n Idade do animal: " + getIdade()
                + "\n Classificação: " + getTipoAnimal()
                + "\n Sexo do animal: " + getSexoAnimal()
                + "\n Identificador do animal: " + getIdAnimal();
    }

    public Animal() {
        solicitarNome();
        criarId();
        solicitarIdade();
        solicitarTipoAnimal();
        solicitarSexoAnimal();
        JOptionPane.showMessageDialog(null, toString());
    }
}

