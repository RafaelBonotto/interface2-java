package services;

import entities.Contrato;
import entities.Parcela;

import java.util.Calendar;
import java.util.Date;

public class ServicoDeContrato {

    private ServicoDePagamentoOnline servicoDePagamentoOnline;

    public ServicoDeContrato(ServicoDePagamentoOnline servicoDePagamentoOnline){
        this.servicoDePagamentoOnline = servicoDePagamentoOnline;
    }

    public void processarContrato(Contrato contrato, int meses){
        double parcelaBasica = contrato.getValorTotal() / meses;
        for(int i = 1; i <= meses; i ++){
            double parcelaAtualizada = parcelaBasica + servicoDePagamentoOnline.juros(parcelaBasica, i);
            double parcelaTotal = parcelaAtualizada + servicoDePagamentoOnline.taxaDePagamento(parcelaAtualizada);
            Date dataVencimento = addMeses(contrato.getDataContrato(), i);
            contrato.getParcelas().add(new Parcela(dataVencimento, parcelaTotal));

        }
    }

    private Date addMeses(Date data, int N){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MONTH, N);
        return calendar.getTime();
    }

}
