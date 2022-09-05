import java.util.ArrayList;
import java.util.Scanner;

import deposito.GaragemLocomotiva;
import deposito.GaragemVagao;
import deposito.PatioTrem;
import veiculo.ParteTrem;
import veiculo.Locomotiva;
import veiculo.Vagao;
import veiculo.Trem;

public class App {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        GaragemLocomotiva garagemLocomotiva = new GaragemLocomotiva();
        GaragemVagao garagemVagao = new GaragemVagao();
        PatioTrem patioTrem = new PatioTrem();
        int idTrem = 0;
        int idLocomotiva = 0;
        int idVagao = 0;
        boolean continua = true;

        for(int i = 0; i < 10; i++){
            garagemLocomotiva.adicionaLocomotiva(idLocomotiva, 100, 4);
            garagemVagao.adicionaVagao(idVagao, 25);
            idLocomotiva++;
            idVagao++;
        }

        System.out.println("********************");
        System.out.println("Bem-vindo ao Sistema de Composição de Trens");
        System.out.println("********************\n");

        while(continua){

            System.out.println("Escolha uma das opções: ");
            System.out.println("(0) Encerrar o programa;");
            System.out.println("(1) Criar um trem;");
            System.out.println("(2) Editar um trem;");
            System.out.println("(3) Listar todos os trens;");
            System.out.println("(4) Desfazer um trem.");

            int opcao = in.nextInt();

            switch(opcao){
                case 1:
                    Locomotiva locomotivaAdicao = garagemLocomotiva.removeLocomotiva();
                    if(locomotivaAdicao == null){
                        System.out.println("\nNão foi possível criar um trem, pois não há locomotivas disponíveis.\n");
                        break;
                    }
                    patioTrem.adicionaTrem(idTrem, locomotivaAdicao);
                    idTrem++;
                    System.out.println("\nTrem criado com sucesso no pátio de trens.\n");
                    break;
                case 2:
                    System.out.println("\nInforme o id do trem que você deseja editar: ");
                    int idTremEdicao = in.nextInt();
                    Trem tremEdicao = patioTrem.encontraTrem(idTremEdicao);
                    boolean continuaEdicao = true;
                    while(continuaEdicao){
                        System.out.println("\nAgora, escolha uma das opções: ");
                        System.out.println("(0) Encerrar a edição;");
                        System.out.println("(1) Inserir uma locomotiva;");
                        System.out.println("(2) Inserir um vagão;");
                        System.out.println("(3) Remover o último elemento do trem;");
                        System.out.println("(4) Listar locomotivas livres;");
                        System.out.println("(5) Listar vagões livres.");
                        int opcaoEdicao = in.nextInt();
                        switch(opcaoEdicao){
                            case 1:
                                if(tremEdicao.engataLocomotiva(garagemLocomotiva.removeLocomotiva())){
                                    System.out.println("\nLocomotiva adicionada com sucesso.");
                                }else{
                                    System.out.println("\nHouve um erro ao adicionar uma locomotiva.");
                                }
                                break;
                            case 2:
                                if(tremEdicao.engataVagao(garagemVagao.removeVagao())){
                                    System.out.println("\nVagão adicionada com sucesso.");
                                }else{
                                    System.out.println("\nHouve um erro ao adicionar um vagão.");
                                }
                                break;
                            case 3:
                                ParteTrem ultimo = tremEdicao.desengataUltimo();
                                if(ultimo instanceof Vagao){
                                    garagemVagao.adicionaVagao((Vagao) ultimo);
                                }else{
                                    garagemLocomotiva.adicionaLocomotiva((Locomotiva) ultimo);
                                }
                                System.out.println("\nÚltimo elemento do trem removido com sucesso.");
                                break;
                            case 4:
                                ArrayList<String> locomotivas = garagemLocomotiva.listaLocomotivas();
                                System.out.print("\n");
                                for (String string : locomotivas) {
                                    System.out.println(string);
                                }
                                System.out.print("\n");
                                break;
                            case 5:
                                ArrayList<String> vagoes = garagemVagao.listaVagoes();
                                System.out.print("\n");
                                for (String string : vagoes) {
                                    System.out.println(string);
                                }
                                System.out.print("\n");
                                break;
                            case 0:
                            default:
                                System.out.println("\nFim da edição.\n");
                                continuaEdicao = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    ArrayList<Trem> trens = patioTrem.listaTrens();
                    System.out.print("\n");
                    for (Trem trem : trens) {
                        System.out.println(trem.toString());
                    }
                    System.out.print("\n");
                    break;
                case 4:
                    System.out.println("\nInforme o id do trem que você deseja remover: ");
                    int idTremRemocao = in.nextInt();
                    Trem tremRemocao = patioTrem.removeTrem(idTremRemocao);
                    while(true){
                        Locomotiva locomotiva = tremRemocao.desengataLocomotiva();
                        if(locomotiva == null){
                            break;
                        }
                        garagemLocomotiva.adicionaLocomotiva(locomotiva);
                    }
                    while(true){
                        Vagao vagao = tremRemocao.desengataVagao();
                        if(vagao == null){
                            break;
                        }
                        garagemVagao.adicionaVagao(vagao);
                    }
                    System.out.println("\nTrem desmontado com sucesso.\n");
                    break;
                case 0:
                default:
                    System.out.println("\nObrigado por utilizar o Sistema.");
                    continua = false;
                    break;
            }
        }

        in.close();
    }
}
