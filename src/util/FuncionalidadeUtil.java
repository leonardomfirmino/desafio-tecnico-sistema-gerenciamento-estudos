package util;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import service.DisciplinaService;

public class FuncionalidadeUtil {

    public void opcao1(DisciplinaService service,Scanner scan) {
        System.out.printf("Nome: ");
        String nome = scan.next();
        System.out.printf("Peso da prova: ");
        int peso = scan.nextInt();
        service.cadastrar(nome, peso);
        System.out.println("\nDisciplina cadastrada com sucesso!");
    }

    public void opcao2(DisciplinaService service,Scanner scan) {
        System.out.println("Qual Disciplina?\n");
        service.exbirNomes();
        System.out.printf("\nNome: ");
        String nome = scan.next();
        if (service.verificar(nome)) {
            System.out.printf("Horas estudadas: ");
            int horas = scan.nextInt();
            System.out.printf("Data dd/MM/yyyy: ");
            String data = scan.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataFormatadada = LocalDate.parse(data, formatter);
            service.filtrar(nome).setHorasEstudadas(horas);
            service.filtrar(nome).setUltimoEstudo(dataFormatadada);

        } else {
            System.out.println("essa disciplina: " + nome + ", não está registrada");
        }
    }

    public void opcao3(DisciplinaService service,Scanner scan) {
        
        System.out.println("Qual Disciplina?\n");
        service.exbirNomes();
        System.out.printf("\nNome: ");
        String nome = scan.next();
        if (service.verificar(nome)) {
            System.out.printf("\nQuantas questões: ");
            double qtdQuest = scan.nextDouble();
            System.out.printf("\nQuantos acertos: ");
            double qtdAcertos = scan.nextDouble();

            service.filtrar(nome).setQuestoesResolvidas(qtdQuest);
            service.filtrar(nome).setAcertos(qtdAcertos);

            System.out.printf("Você acertou %.0f%%\n", service.porcentagemAcertos(service.filtrar(nome)));

        } else {
            System.out.println("essa disciplina: " + nome + ", não está registrada");
        }
    }

    public void opcao4(DisciplinaService service,Scanner scan) {
        System.out.println("Qual Disciplina?\n");
        service.exbirNomes();
        System.out.printf("\nNome: ");
        String nome = scan.next();
        if (service.verificar(nome)) {
            service.prioridade();
            System.out.println(service.filtrar(nome).toString());
            System.out.printf("Taxa: %.0f%%\n", service.porcentagemAcertos(service.filtrar(nome)));

        } else {
            System.out.println("essa disciplina: " + nome + ", não está registrada");
        }
    }

    public void opcao5(DisciplinaService service) {
        System.out.println("Ranking de Prioridade de estudos!");
        service.prioridade();
        System.out.println(service.exbirserviceCompleta());

    }

    public void opcao6(DisciplinaService service) {
        System.out.println("Relatório de disciplinas");
        System.out.println(service.exbirserviceCompleta() + "\n");
    }

    public void opcao7() {
        ApiUtil api = new ApiUtil();
        System.out.printf("Frase do dia é: %s\n", api.traduzir());

    }

    public void opcao8(DisciplinaService service) {
        try {
            FileWriter arquivo = new FileWriter("Registro.txt");
            arquivo.write(service.exbirserviceCompleta());
            arquivo.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
