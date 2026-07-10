package model;


import java.time.LocalDate;


import util.RegexUtil;

public class Disciplina {
    private String nome;
    private int pesoProva=0;
    private RegexUtil configNome = new RegexUtil();
    private int horasEstudadas=0;
    private double questoesResolvidas=0.0;
    private double acertos=0.0;
    private LocalDate ultimoEstudo=LocalDate.of(1973, 01, 10);
    private double prioridade=0.0;

    public double getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(double prioridade) {
        this.prioridade = prioridade;
    }

    public Disciplina(String nome, int pesoProva) {
        
        if (configNome.configString("[a-zA-Z]+", nome) && pesoProva > 0) {
            this.nome = nome;
            this.pesoProva = pesoProva;
        } else {
            throw new IllegalArgumentException("Nome ou peso invalido", null);
        }

    }

    public int getHorasEstudadas() {
        return horasEstudadas;
    }

    public void setHorasEstudadas(int horasEstudadas) {
        if (horasEstudadas < 0 ) {
            throw new IllegalArgumentException("Não pode colocar numeros negativos");
        }this.horasEstudadas += horasEstudadas;
    }

    public double getQuestoesResolvidas() {
        return questoesResolvidas;
    }

    public void setQuestoesResolvidas(double questoesResolvidas) {
        if (questoesResolvidas < 0 ) {
            throw new IllegalArgumentException("Não pode colocar numeros negativos");
        }
        this.questoesResolvidas += questoesResolvidas;
       
    }

    public double getAcertos() {
        return acertos;
    }

    public void setAcertos(double acertos) {
        if (acertos < 0 ) {
            throw new IllegalArgumentException("Não pode colocar numeros negativos");
        }
        this.acertos += acertos;
       
    }

    public LocalDate getUltimoEstudo() {
        return ultimoEstudo;
    }

    public void setUltimoEstudo(LocalDate ultimoEstudo) {
        if(this.ultimoEstudo.isAfter(ultimoEstudo)){}
        else{this.ultimoEstudo = ultimoEstudo;}
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (configNome.configString("[a-zA-Z]+", nome)) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome invalido", null);
        }
    }

    public int getPesoProva() {
        return pesoProva;
    }

    public void setPesoProva(int pesoProva) {
        if (pesoProva > 0) {
            this.pesoProva = pesoProva;
        } else {
            throw new IllegalArgumentException("Peso invalido", null);
        }
    }

    @Override
    public String toString() {
        return "Disciplina=" + nome + "\nPeso da Prova=" + pesoProva + ",\nHoras Estudadas=" + horasEstudadas + "\nQuestoes Resolvidas=" + questoesResolvidas + ",\nAcertos="
                + acertos + "\nUltimo dia Estudado=" + ultimoEstudo+"\nPioridade= "+prioridade;
    }

    

}
