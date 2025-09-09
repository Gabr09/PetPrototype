package entities;

import javax.swing.JOptionPane;

public class Endereco {
    private String nomeRua;
    private String numero;
    private String cep;
    private String complemento;
    private String tipo;
    private Pet pet;

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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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
                JOptionPane.showMessageDialog(null, "Você deve obrigatoriamente informar o nome da rua para cadastrar o endereço!", "ERRO", JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Preencha o campo.", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else if (entradaNumero.equalsIgnoreCase("SN")) {
                entradaNumero = "Sem número";
                setNomeRua(entradaNumero);
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
                JOptionPane.showMessageDialog(null, "Preencha corretamente o campo solicitado.", "ERRO", JOptionPane.WARNING_MESSAGE);
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
                        JOptionPane.showMessageDialog(null, "Opção inválida, direite entre 1, 2, ou 3.", "ERRO", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}