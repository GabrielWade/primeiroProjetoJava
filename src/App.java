package src;

import src.model.ContaBancaria;
import src.model.ContaCorrente;
import src.model.ContaPoupanca;
import src.model.Movimentacao;
import src.utils.DataUtil;
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

        System.out.println(conta2.getDataAbertura());

        /*DataUtil util = new DataUtil();
        var f1 = util.converterDateParaDataEHora(conta2.getDataAbertura());
        var f2 = util.converterDateParaData(conta2.getDataAbertura());
        var f3 = util.converterHora(conta2.getDataAbertura());
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);*/

        //classe estática não precisa estanciar
        var f1 = DataUtil.converterDateParaDataEHora(conta2.getDataAbertura());
        var f2 = DataUtil.converterDateParaData(conta2.getDataAbertura());
        var f3 = DataUtil.converterHora(conta2.getDataAbertura());        
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        //Extrato bancario é composto por movimentações bancárias.
        //Ter algo que possa ser a movimentação
        //Ter uma lista de movimentação

        Movimentacao movimentacao = new Movimentacao("Saque", 100.0);
        System.out.println(movimentacao);
    }
}
