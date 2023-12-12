package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {
    //#region Atributos
    protected String agencia;
    protected String conta;
    protected Integer digito;
    protected Double saldo;
    protected Double VALOR_MINIMO_DEPOSITO = 10.0;
    protected Date dataAbertura;
    protected ArrayList<Movimentacao> movimentacoes;

    //#endregion

    //#region Construtores
    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();

        // se não intaciar, vai dar uma excpetion de nullPointerExcpetion
        this.movimentacoes = new ArrayList<Movimentacao>();

        // criando minha primeira movimentação
        Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);

        // aqui estou salvando minha movimentação dentro da minha lista(aarray) de movimentações
        // aqui estou inicializando meu extrato bancario
        this.movimentacoes.add(movimentacao);
    }
    //#endregion

    //#region Getters e Setters
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }


    public Date getDataAbertura() {
        return dataAbertura;
    }
    //#endregion

    //#region Métodos

    public void depositar(Double valor) {
        if(valor < VALOR_MINIMO_DEPOSITO) {
            throw new InputMismatchException("O valor mínimo para depósito é de" + VALOR_MINIMO_DEPOSITO);
        }

        this.saldo += valor;

        // aqui faço uma movimentação de deposito
        Movimentacao movimentacao = new Movimentacao("Depósito", valor);
        this.movimentacoes.add(movimentacao);
    }

    public double sacar(Double valor) {
        if(valor > this.saldo) {
            throw new InputMismatchException("Saldo insuficiente!");
        }

        this.saldo -= valor;

        // aqui faço uma movimentação de saque
        Movimentacao movimentacao = new Movimentacao("Retirada de valor", valor);
        this.movimentacoes.add(movimentacao);

        return valor;
    }

    public void transferir(ContaBancaria contaDestino, Double valor) {
        //efetua saque na conta atual
        this.sacar(valor);

        //deposita na conta destino
        contaDestino.depositar(valor);

    }
    //#endregion

    public abstract void imprimirExtrato(); 
}
