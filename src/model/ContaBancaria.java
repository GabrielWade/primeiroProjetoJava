package src.model;

import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {
    //#region Atributos
    private String agencia;
    private String conta;
    private Integer digito;
    private Double saldo;
    private Double VALOR_MINIMO_DEPOSITO = 10.0;
    private Date dataAbertura;

    //#endregion

    //#region Construtores
    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();
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
    }

    public double sacar(Double valor) {
        if(valor > this.saldo) {
            throw new InputMismatchException("Saldo insuficiente!");
        }

        this.saldo -= valor;

        return valor;
    }

    public void transferir(ContaBancaria contaDestino, Double valor) {
        //efetua saque na conta atual
        this.sacar(valor);

        //deposita na conta destino
        contaDestino.depositar(valor);
    }
    //#endregion
}
