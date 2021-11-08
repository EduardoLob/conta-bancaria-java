package banco;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {


        int escolha;

        Scanner leia = new Scanner(System.in);
        System.out.println("MENU DO BANCO:");
        System.out.println("\n1 - Abrir conta \n2 - Sacar \n3 - Depositar  \n4 - Status Geral \n5 - Ver apenas o saldo da conta  \n6 - Fechar conta \n7 - Ver extrato");
        escolha = leia.nextInt();

        ContaBanco c = new ContaBanco();

        while (escolha != 8) {
            switch (escolha) {
                case 1:
                    c.abrirConta();
                    break;
                case 2:
                    c.sacar();
                    break;
                case 3:
                    c.depositar();
                    break;
                case 4:
                    c.status();
                    break;
                case 5:
                    System.out.println("Saldo = " + c.getSaldo());
                    break;
                case 6:
                    c.fecharConta();
                    break;
                case 7:
                    c.mostrarExtrato();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
            System.out.println("\nQual sua próxima ação, caso já tenha concluído tudo, digite 8");
            escolha = leia.nextInt();
            if (escolha == 8) {
                System.out.println("Saindo e disponibilizando seu histórico...");
                c.mostrarExtrato();
            }
        }
        leia.close();
    }
}
