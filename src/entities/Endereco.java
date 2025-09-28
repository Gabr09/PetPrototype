package entities;

import javax.swing.JOptionPane;
import java.util.Objects;

public class Endereco {
    private String nomeRua;
    private String numero;
    private String cep;
    private String complemento;
    private String tipo;

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void solicitarCep() {
        boolean entradaValida = false;
        while (!entradaValida) {
            String entrada = JOptionPane.showInputDialog("Digite o cep (apenas números): ");
            if (entrada != null && entrada.matches("\\d{8}")) {
                setCep(entrada); // usa o setter
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Dado inválido, deve conter 8 dígitos.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void solicitarNomeRua() {
        boolean entradaValida = false;
        while (!entradaValida) {
            String entradaNomeRua = JOptionPane.showInputDialog("Digite o nome da rua: ");
            if (entradaNomeRua == null || entradaNomeRua.isBlank()) {
                JOptionPane.showMessageDialog(null, "Você deve obrigatoriamente informar o nome da rua para cadastrar o endereço!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                setNomeRua(entradaNomeRua);
                entradaValida = true;
            }
        }
    }

    public void solicitarNumero() {
        boolean entradaValida = false;
        while(!entradaValida) {
            String entradaNumero = JOptionPane.showInputDialog("Digite o número ou [SN] para sem número ");
            if (entradaNumero.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha o campo.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else if (entradaNumero.equalsIgnoreCase("SN")) {
                entradaNumero = "Sem número";
                setNumero(entradaNumero);
                entradaValida = true;
            } else {
                setNumero(entradaNumero);
                entradaValida = true;
            }
        }
    }

    public void solicitarTipo() {
        String entradaTipo;
        boolean entradaValida = false;
        while (!entradaValida) {
            entradaTipo = JOptionPane.showInputDialog("""
                    Digite a opção correta para a sua moradia:
                    [1] Casa
                    [2] Condomínio
                    [3] Outro
  """);
            if (entradaTipo == null || entradaTipo.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha corretamente o campo solicitado.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                switch (entradaTipo.trim()){
                    case "1":
                        entradaTipo = "Casa";
                        entradaValida = true;
                        setTipo(entradaTipo);
                        break;
                    case "2":
                        entradaTipo = "Condomínio";
                        entradaValida = true;
                        setTipo(entradaTipo);
                        break;
                    case "3":
                        entradaTipo = JOptionPane.showInputDialog("Digite o tipo da sua moradia: ");
                        entradaValida = true;
                        setTipo(entradaTipo);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida, direite entre 1, 2, ou 3.", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void solicitarComplemento() {
        String entradaComplemento = JOptionPane.showInputDialog("Digite o complemento: ");
        if (entradaComplemento == null || entradaComplemento.trim().isBlank()) {
            entradaComplemento = "Sem complemento";
            setComplemento(entradaComplemento);
            } else {
            setComplemento(entradaComplemento);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(nomeRua, endereco.nomeRua) && Objects.equals(numero, endereco.numero) && Objects.equals(cep, endereco.cep) && Objects.equals(complemento, endereco.complemento) && Objects.equals(tipo, endereco.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeRua, numero, cep, complemento, tipo);
    }

    @Override
    public String toString() {
        return "Endereço cadastrado! "
                +"\n CEP: " + getCep()
                + "\nRua: " + getNomeRua()
                + "\nNumero: " + getNumero()
                + "\nComplemento: " + getComplemento();
    }

    public Endereco() {
        solicitarCep();
        solicitarNomeRua();
        solicitarNumero();
        solicitarTipo();
        solicitarComplemento();
        JOptionPane.showMessageDialog(null, toString());
    }
}