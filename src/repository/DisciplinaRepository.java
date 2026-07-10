package repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


import model.Disciplina;

public class DisciplinaRepository {
    private Set<Disciplina> serviceDisciplina = new TreeSet<>(Comparator.comparingDouble(Disciplina::getPrioridade).thenComparing(Disciplina::getNome));

    public void salvarDisciplina(Disciplina d){
        serviceDisciplina.add(d);
    }

    public void exbirNomesserviceDisciplina(){
       serviceDisciplina.forEach(elemento->System.out.println(elemento.getNome()));
    }
    
    public String exbirserviceCompleta(){
        return serviceDisciplina.toString();
    }

    public void removerDisciplina(Disciplina Disciplina){
        Disciplina remover=serviceDisciplina.stream().filter(e->e==Disciplina).findFirst().orElseThrow();
        serviceDisciplina.removeIf(e->e.equals(remover));
    }

    public boolean verificacao(String Disciplina){
        return serviceDisciplina.stream().anyMatch(elemento -> elemento.getNome().equals(Disciplina));
        
    }

    public Disciplina filtro(String Disciplina){
        return serviceDisciplina.stream()
                    .filter(elemento -> elemento.getNome().equals(Disciplina))
                    .findFirst()
                    .orElseThrow();                
    }

    public double porcentagemAcertos(Disciplina d){
        return (d.getAcertos()/d.getQuestoesResolvidas())*100;
    }

    public double prioridade(Disciplina d){
        LocalDate dataDisciplina=LocalDate.from(d.getUltimoEstudo());
        LocalDate hoje = LocalDate.now();
        long t;
        double p;
        if(dataDisciplina.until(hoje,ChronoUnit.DAYS)<0){
            t=d.getPesoProva();
        }else{
            t=dataDisciplina.until(hoje,ChronoUnit.DAYS);
        }
        
        if(porcentagemAcertos(d)<0.0||Double.isNaN(porcentagemAcertos(d))){
            p=100;
        }else{
            p=porcentagemAcertos(d);
        }
        
        d.setPrioridade(d.getPesoProva()+t+(100-p));
        return d.getPrioridade();
    }

    public void preencherPriorizacao() {
    this.serviceDisciplina = this.serviceDisciplina.stream()
        .collect(Collectors.toCollection(() -> 
            new TreeSet<>(
                Comparator.comparingDouble((Disciplina d) -> prioridade(d)).reversed()
                          .thenComparing(Disciplina::getNome) 
            )
        ));
}

   
}
