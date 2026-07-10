package service;

import model.Disciplina;
import repository.DisciplinaRepository;

public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;
    public DisciplinaService(DisciplinaRepository disciplinaRepository){
        this.disciplinaRepository = disciplinaRepository;
    }

    public void cadastrar(String nomeDisciplina,int peso){
        disciplinaRepository.salvarDisciplina(new Disciplina(nomeDisciplina, peso));
    }

    public void exbirNomes(){
        disciplinaRepository.exbirNomesserviceDisciplina();
    }
    
    public String exbirserviceCompleta(){
        return disciplinaRepository.exbirserviceCompleta();
    }

    public boolean verificar(String disciplina){
        return disciplinaRepository.verificacao(disciplina);
    }
    
    public Disciplina filtrar(String disciplina){
        return disciplinaRepository.filtro(disciplina);
    }

    public double porcentagemAcertos(Disciplina d){
        return disciplinaRepository.porcentagemAcertos(d);
    }

    public void prioridade(){
        disciplinaRepository.preencherPriorizacao();
    }

    
    
}
