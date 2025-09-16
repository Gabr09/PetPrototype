package entities;

import javax.swing.JOptionPane;
import java.util.Objects;

public class Cliente {
    private String nome;
    private String cpf;
    private Animal animal;
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

    public Animal getPet() {
        return animal;
    }

    public void setPet(Animal animal) {
        this.animal = animal;
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
                JOptionPane.showMessageDialog(null, "Informe seu nome corretamente.", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                setNome(entradaNome);
                entradaValida = true;
            }
        }
    }

    public void solicitarCpf() {
        String entradaCpf;
        boolean entradaValida = false;
        while (!entradaValida) {
            entradaCpf = JOptionPane.showInputDialog("Digite seu CPF completo: ");
            if (entradaCpf == null || entradaCpf.isBlank()) {
                JOptionPane.showMessageDialog(null, "É obrigatório informar seu CPF.", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                entradaCpf = entradaCpf.replaceAll("\\D", "");
                if (!entradaCpf.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "O CPF tem exatamente 11 dígitos.", "ERRO", JOptionPane.WARNING_MESSAGE);
                } else {
                    setCpf(entradaCpf);
                    entradaValida = true;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(cpf, cliente.cpf) && Objects.equals(animal, cliente.animal) && Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, animal, endereco);
    }

    @Override
    public String toString() {
        String mensagem = "";
        return mensagem;
    }
}
