package entities;

public class Dono {
    private String nome;
    private String cpf;
    private Pet pet;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void solicitarNome() {
        String entradaNome;
        boolean entradaValida = false;
        while (!entradaValida) {
            entradaNome = JOptionPane.showInputDialog("Digite seu nome completo: ");
            if (entradaNome.isBlank() || !entradaNome.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(null, "É obrigatório informar seu nome.", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                setNome(entradaNome);
                entradaValida = true;
            }
        }
    }

    public void setCpf() {
        String entradaCpf;
        boolean entradaValida = false;
        while (!entradaValida) {
            entradaCpf = JOptionPane.showInputDialog("Digite seu CPF completo: ");
            if (entradaCpf
            }
        }
    }
}
