
import java.util.NoSuchElementException;
import java.util.Scanner;

import repository.DisciplinaRepository;
import service.DisciplinaService;
import util.FuncionalidadeUtil;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DisciplinaService service = new DisciplinaService(new DisciplinaRepository());
        FuncionalidadeUtil funcionalidadeUtil = new FuncionalidadeUtil();

        boolean loop = true;

        while (loop != false) {
            try {
                System.out.println("""
                        ====================================
                         SISTEMA DE GERENCIAMENTO DE ESTUDOS
                        ====================================

                        1 - Cadastrar Disciplina
                        2 - Registrar Estudo
                        3 - Registrar Questões
                        4 - Consultar Disciplina
                        5 - Ranking de Prioridade
                        6 - Gerar Relatório
                        7 - Sincronizar Dados da API
                        8 - Salvar Dados
                        0 - Sair
                                    """);
                int resp = scan.nextInt();
                System.out.println("");
                switch (resp) {
                    case 1:
                        funcionalidadeUtil.opcao1(service, scan);
                        break;
                    case 2:
                        funcionalidadeUtil.opcao2(service, scan);
                        break;
                    case 3:
                        funcionalidadeUtil.opcao3(service, scan);
                        break;
                    case 4:
                        funcionalidadeUtil.opcao4(service, scan);
                        break;
                    case 5:
                        funcionalidadeUtil.opcao5(service);
                        break;
                    case 6:
                        funcionalidadeUtil.opcao6(service);
                        break;
                    case 7:
                        funcionalidadeUtil.opcao7();
                        break;

                    case 8:
                        funcionalidadeUtil.opcao8(service);
                        break;
                    case 0:
                        loop = false;
                        break;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }

            } catch (NoSuchElementException e) {
                System.out.println("Não escrever esse caracter, tem ser uma das opções \n");
                scan.nextLine();
            }
        }

    }
}
