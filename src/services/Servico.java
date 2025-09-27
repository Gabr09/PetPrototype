package services;

import entities.Cliente;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Servico {
    private Servicos nomeServico;
    private String descricaoServico;
    private double valorServico;
    private LocalDateTime dataAgendamento;

    public Servicos getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(Servicos nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public void solicitarNomeServico() {
        String entradaNomeServico;
        boolean entradaCorreta = false;
        while (!entradaCorreta) {
            entradaNomeServico = JOptionPane.showInputDialog("""
                    Informe o serviço que deseja agendar:
                    [1] Para consulta de rotina
                    [2] Para vacinação
                    [3] Para exames laboratoriais
                    [4] Para exames de imagem
                    [5] Para castração
                    [6] Para cirurgia""");
            switch (entradaNomeServico.trim()) {
                case "1":
                    setNomeServico(Servicos.CONSULTADEROTINA);
                    entradaCorreta = true;
                    break;
                case "2":
                    setNomeServico(Servicos.VACINACAO);
                    entradaCorreta = true;
                    break;
                case "3":
                    setNomeServico(Servicos.EXAMESLABORATORIAIS);
                    entradaCorreta = true;
                    break;
                case "4":
                    setNomeServico(Servicos.EXAMESDEIMAGEM);
                    entradaCorreta = true;
                    break;
                case "5":
                    setNomeServico(Servicos.CASTRACAO);
                    entradaCorreta = true;
                    break;
                case "6":
                    setNomeServico(Servicos.CIRURGIAS);
                    entradaCorreta = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Você deve selecionar uma das opções listadas, tente novamente!", "ERRO", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
    }

    public void atribuicaoDescricaoServico() {
        if (getNomeServico() != null) {
            setDescricaoServico(getNomeServico().getDescricao());
        }
    }

    public void atribuicaoValorServico() {
        switch (getNomeServico()) {
            case CONSULTADEROTINA -> setValorServico(120.0);
            case VACINACAO -> setValorServico(60.0);
            case EXAMESLABORATORIAIS -> setValorServico(150.0);
            case EXAMESDEIMAGEM -> setValorServico(200.0);
            case CASTRACAO -> setValorServico(400.0);
            case CIRURGIAS -> setValorServico(600.0);
            default -> setValorServico(0.0);
        }
    }

    public void solicitarDataAgendamento() {
        boolean entradaCorreta = false;
        while (!entradaCorreta) {
            JOptionPane.showMessageDialog(null, "Antes de realizar um agendamento, informamos que nossa clínica está prestando serviços de segunda a sexta das 07:00h até 19:00h" +
                    " e aos sábados das 08:00h até as 16:00h");
            String entradaData = JOptionPane.showInputDialog("""
                    informe a data para agendamento no formato DIA/MÊS/ANO   HORAS:MINUTOS
                    Por exemplo: 20/06/2025 14:30""");
            try {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime date = LocalDateTime.parse(entradaData, formatador);
                DayOfWeek diaAgendamento = date.getDayOfWeek();
                int hour = date.getHour();
                int minute = date.getMinute();
                boolean dataPermitida = false;
                if (diaAgendamento != DayOfWeek.SUNDAY) {
                    if (diaAgendamento == DayOfWeek.SATURDAY) {
                        if (hour >= 8 && (hour  < 16 || (hour == 16 && minute == 0))) {
                            dataPermitida = true;
                        }
                    } else {
                        if (hour >= 7 && (hour <19 || (hour == 19 && minute == 0 ))) {
                            dataPermitida = true;
                        }
                    }
                }
                if (dataPermitida) {
                    this.dataAgendamento = date;
                    JOptionPane.showMessageDialog(null, "Agendamento confirmado para: " + date.format(formatador));
                    entradaCorreta = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Horário fora do expediente da clínica, tente novamente.", "ERRO", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato inválido, use o padrão DIA/MÊS/ANO   HORA:MINUTO", "ERRO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public Servico() {
        solicitarNomeServico();
        solicitarDataAgendamento();
        atribuicaoDescricaoServico();
        atribuicaoValorServico();
    }
}
