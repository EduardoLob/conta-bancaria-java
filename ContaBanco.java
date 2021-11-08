package banco;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ContaBanco {

    Random gerador = new Random();

    Scanner leia = new Scanner(System.in);

    private int tipo;
    private double saldo;
    private double depositar;
    private boolean contaAberta;
    private double quantSac;
    private String nomeBanco;
    private String nomeAgencia;
    private String numeroConta;
    private int agencia;
    private ArrayList<String> extrato = new ArrayList<>();

    public void abrirConta() {

        System.out.println("MENU: ");
        System.out.println("1 - Conta corrente \n2 - Conta poupança \n3 - Conta conjunta ");
        this.setTipo(leia.nextInt());
        leia.nextLine();

        for (int i = 0; i < 1; i++){
            this.setAgencia(gerador.nextInt(9999));
            System.out.println("Agência = " + this.getAgencia());
        }

        for (int i = 0; i < 1; i++) {
            this.setNumeroConta("Numero conta: " + gerador.nextInt(99999999) + "-" + gerador.nextInt(9));
            System.out.println(this.getNumeroConta());
        }

        System.out.println("Qual o nome do banco: ");
        this.setNomeBanco(leia.nextLine());


        System.out.println("Qual o nome da agência: ");
        this.setNomeAgencia(leia.nextLine());


        if (this.getTipo() == 1) {
            setContaAberta(true);
            System.out.println("Conta corrente aberta");
            extrato.add("Usuário abriu conta corrente");

        } else if (this.getTipo() == 2) {
            setContaAberta(true);
            System.out.println("Conta poupança aberta");
            extrato.add("Usuário abriu conta poupança");
        } else if (this.getTipo() == 3) {
            setContaAberta(true);
            System.out.println("Conta conjunta aberta");
            extrato.add("Usuário abriu conta conjunta");
        }
        for (int i = 0; this.getTipo() != 1 && this.getTipo() != 2 && this.getTipo() != 3; i++) {
            System.out.println("Opção errada, tente novamente");
            this.tipo = leia.nextInt();
            if (this.getTipo() == 1 || this.getTipo() == 2 || this.getTipo() == 3) {
                setContaAberta(true);
                System.out.println("Conta tipo " + this.getTipo() + " aberta");
            }
        }
    }

    public void fecharConta() {
        if (this.getSaldo() >= 0 && this.getContaAberta()) {
            this.setContaAberta(false);
            System.out.println("Retornando o saldo de " + this.getSaldo() + " para fechar a conta");
            System.out.println("Conta fechada");
            extrato.add("Usuário fechou conta");

        } else if (!this.getContaAberta()) {
            System.out.println("Voce não tem conta para fechar");
        } else
            System.out.println("Erro... Deposite o valor negativo e tente novamente");
    }

    public void sacar() {
        if (this.getContaAberta()) {
            System.out.println("Quanto voce deseja sacar? ");
            this.quantSac = leia.nextDouble();
            this.setSaldo(this.getSaldo() - this.getQuantSac());
            System.out.println("Sacando... Feito");
            extrato.add("Usuário sacou: " + this.getQuantSac());

        } else
            System.out.println("Voce deve abrir uma conta primeiro");
    }

    public void depositar() {
        if (this.getContaAberta()) {
            System.out.println("Quanto você deseja depositar? ");
            this.depositar = leia.nextDouble();
            this.setSaldo(this.getDepositar() + this.getSaldo());
            System.out.println("Depositando... Feito");
            extrato.add("Usuário depositou: R$" + this.getDepositar());

        } else
            System.out.println("Você não tem conta para depositar");
    }

    public void status() {
        System.out.println("Conta aberta: " + this.getContaAberta());
        if (this.getContaAberta()) {
            System.out.println("Saldo da conta: " + this.getSaldo());
            System.out.println("Tipo de conta: " + this.getTipo());
            System.out.println("Nome do banco: " + this.getNomeBanco());
            System.out.println("Nome da Agência: " + this.getNomeAgencia());
            System.out.println("Número da conta: " + this.getNumeroConta());
            System.out.println("Número da Agência: " + this.getAgencia());
        }
    }

    public void mostrarExtrato() {
        System.out.println("Histórico usuário: ");
        for (String s : extrato) {
            System.out.println(s);
        }
    }

    public ContaBanco() {
        this.saldo = 0;
        this.depositar = 30;
        this.contaAberta = false;
        this.quantSac = 20;
        this.tipo = 0;
        this.agencia = 0;
        this.nomeBanco = null;
        this.numeroConta = null;
        this.nomeAgencia = null;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getDepositar() {
        return depositar;
    }

    public void setDepositar(double depositar) {
        this.depositar = depositar;
    }

    public boolean getContaAberta() {
        return contaAberta;
    }

    public void setContaAberta(boolean contaAberta) {
        this.contaAberta = contaAberta;
    }

    public double getQuantSac() {
        return quantSac;
    }

    public void setQuantSac(double quantSac) {
        this.quantSac = quantSac;
    }
}