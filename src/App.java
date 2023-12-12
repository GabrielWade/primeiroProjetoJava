package src;

import src.model.ContaBancaria;
import src.model.ContaCorrente;
import src.model.ContaPoupanca;

public class App {
    public static void main(String[] args) {
        System.out.println("Criando Banco Digital!");
        System.out.println("");

        ContaCorrente conta = new ContaCorrente("0001", "123456", 7, 100.0);
        
        System.out.println("Saldo atual: " + conta.getSaldo());

        conta.depositar(100.0);
        System.out.println("Saldo atual: " + conta.getSaldo());
        conta.sacar(50.0);
        System.out.println("Saldo atual: " + conta.getSaldo());

        ContaPoupanca conta2 = new ContaPoupanca("0001", "123458", 8, 200.0);

        conta2.transferir(conta, 100.0);
        System.out.println("Saldo atual: " + conta2.getSaldo());
        System.out.println();

        System.out.println("Saldo atual: " + conta.getSaldo());
        System.out.println();
    }
}
