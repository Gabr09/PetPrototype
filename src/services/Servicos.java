package services;

public enum Servicos {
    CONSULTADEROTINA("Consulta para avaliação geral do animal."),
    VACINACAO("Aplicação de vacinas preventivas."),
    EXAMESLABORATORIAIS("Exames de fezes, urina ou sangue."),
    EXAMESDEIMAGEM("Ultrassonografia, radiografia e outros exames de imagem."),
    CASTRACAO("Procedimento cirúrgico de castração."),
    CIRURGIAS("Cirurgias gerais conforme a necessidade.");

    private final String descricao;

    Servicos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
