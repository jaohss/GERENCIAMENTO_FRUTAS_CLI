import java.util.ArrayList; //importando bibliotecas referentes ao array list
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);//Instanciando o objeto do Scanner
        ArrayList<String> frutas = new ArrayList<>();

        while(true){//While que faz retição até que a opção de sair seja digitada
            try {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Adicionar uma fruta");
                System.out.println("2 - Listar todas as frutas");
                System.out.println("3 -  Modificar uma fruta");
                System.out.println("4 - Remover uma fruta");
                System.out.println("5 - Sair");
                System.out.println("Opção: ");

                int opcao = scn.nextInt();
                scn.nextLine();//Limpar o buffer

                //Caso de escolhas, se determinado número for digitado, fará determinado execução de código diferente
                switch (opcao){
                    //Caso o usuário digite 1, o usuário terá que digitar o nome de uma fruta para ser adicionada
                    case 1:
                        System.out.println("Digite o nome da fruta para adicionar: ");
                        String novaFruta = scn.nextLine();

                        frutas.add(novaFruta);//Realiza a adição da fruta digitada dentro da ArrayList
                        System.out.println(novaFruta + " foi adicionada.");
                        break;

                    //Caso o usuário digite 2, o programa vai listar todas as frutas que se estão na ArrayList    
                    case 2: 
                        System.out.println("Frutas: \n"+frutas);
                        break;
                    //Caso o usuáro diigite 3, o usuário vai digitar qual o índice da fruta que deseja modificar e colocar o novo nome para fruta modificada do índice correspondente
                    case 3:
                        System.out.println("Digite o índice da fruta que deseja modificar: ");
                        int idModificar = scn.nextInt();
                        scn.nextLine();

                        //Se o indice da fruta digitado ser maior que 0 e menor que o tamanho da ArrayList, ele vai executar determinada ação
                        if(idModificar >= 0 && idModificar <frutas.size()){
                            System.out.println("Digite o novo nome da fruta: ");
                            String frutaModificada = scn.nextLine();
                            frutas.set(idModificar, frutaModificada);//Faz a modificação da fruta correspondente ao índice digitado
                            System.out.println("Fruta no índice "+ idModificar + " foi modificada para "+ frutaModificada);
                        }
                        else{
                            //Caso o índice não seja encontra, será exibida a seguinte mensagem ao usuári
                            System.out.println("Índice inválido");
                        }
                        break;
                    //Caso o usuário digite 4, será feita a remoção da fruta desejada
                    case 4:
                        System.out.println("Digite o nome da fruta que deseja remover");
                        String frutaRemover = scn.nextLine();

                        if(frutas.remove(frutaRemover)){//faz a remoção a fruta da ArrayList
                            System.out.println(frutaRemover + " foi removida.");
                        }
                        else{
                            System.out.println(frutaRemover + " não foi encontrada");
                        }
                        break;
                    //Caso o usuário digite 5, o programe não irá mais funcionar.
                    case 5:
                        System.out.println("Saindo...");
                        scn.close();
                        return;

                    default:
                    System.out.println("Opção ínvalida. Tente novamente.");

                }
                
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scn.nextLine();
            }
        }
        
    }
}