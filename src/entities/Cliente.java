package entities;

import javax.swing.JOptionPane;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import services.Servico;

public class Cliente {
    private String nome;
    private String cpf;
    private String numeroCelular;
    private Animal animal;
    private Endereco endereco;
    private List<Servico> servicosContratados = new ArrayList<>();
    private List<Animal> animaisAtendimento = new ArrayList<>();

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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void solicitarNome() {
        String entradaNome;
        boolean entradaValida = false;
        while (!entradaValida) {
            entradaNome = JOptionPane.showInputDialog("Digite seu nome completo: ");
            if (entradaNome.isBlank() || !entradaNome.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(null, "Informe seu nome corretamente.", "ERRO", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "É obrigatório informar seu CPF.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                entradaCpf = entradaCpf.replaceAll("\\D", "");
                if (!entradaCpf.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "O CPF tem exatamente 11 dígitos.", "ERRO", JOptionPane.ERROR_MESSAGE);
                } else {
                    setCpf(entradaCpf);
                    entradaValida = true;
                }
            }
        }
    }

    public void solicitarNumeroCelular() {
        boolean entradaNumero = false;
        while(!entradaNumero) {
            String entradaNumeroCelular = JOptionPane.showInputDialog("Digite o número do celular junto ao DDD");
            if (entradaNumeroCelular == null || entradaNumeroCelular.isBlank()) {
                JOptionPane.showMessageDialog(null, "É obrigatório informar um número de contato", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                entradaNumeroCelular = entradaNumeroCelular.replaceAll("\\D", "");
                if (!entradaNumeroCelular.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "Número de telefone incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
                } else {
                    setNumeroCelular(entradaNumeroCelular);
                    entradaNumero = true;
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
        return "<html><b>CADASTRO REALIZADO COM SUCESSO!<b/></html>" +
               "Lembrando " + getNome()+  " caso seja necessário realizar alteração cadastral, dirija-se até a recepção.";
    }

    public void contratarServico() {
        boolean ofertaServico = true;
        while (ofertaServico) {
            Servico servico = new Servico();
            servico.atribuicaoValorServico();
            servico.atribuicaoValorServico();
            servicosContratados.add(servico);
            int respostaCliente = JOptionPane.showConfirmDialog(null, "Deseja solicitar um novo serviço?", "NOVA SOLICITAÇÃO", JOptionPane.YES_NO_OPTION);
            if (respostaCliente != JOptionPane.YES_OPTION) {
                ofertaServico = false;
                servicosContratados.forEach(services -> {
                    JOptionPane.showMessageDialog(null, "Serviço contratado: " + services.getNomeServico()
                    + "\nDescrição do serviço solicitado: " + services.getDescricaoServico()
                    + "\nData do agendamento: " + services.getDataAgendamento()
                    + "\nValor total: " + calcValorServicos());
                });
            }
        }
    }

    public double calcValorServicos() {
        double total = 0.0;
        for (Servico servico : servicosContratados) {
            total += servico.getValorServico();
        }
        return total;
    }

    public void cadastrarAnimais() {
        boolean ofertarCadastro = false;
        while (!ofertarCadastro) {
            Animal animal = new Animal();
            animaisAtendimento.add(animal);
            int respostaCliente = JOptionPane.showConfirmDialog(null, "Deseja cadastrar/solicitar atendimento para outro animal? ", "CADASTRAR NOVO", JOptionPane.YES_NO_OPTION);
            if (respostaCliente == JOptionPane.NO_OPTION) {
                ofertarCadastro = true;
            }
        }
    }
    public Cliente() {
        solicitarNome();
        solicitarCpf();
        solicitarNumeroCelular();
        this.endereco = new Endereco();
        JOptionPane.showMessageDialog(null, toString());
        cadastrarAnimais();
        contratarServico();
    }
}