package services;

public class ServicoDePagamento implements ServicoDePagamentoOnline {

    public static final double TAXA_PAGAMENTO = 0.02;
    public static final double JURO_MENSAL = 0.01;


    @Override
    public double taxaDePagamento(double valor) {
        return valor * TAXA_PAGAMENTO;
    }

    @Override
    public double juros(double valor, int meses) {
        return valor * meses * JURO_MENSAL;
    }
}
