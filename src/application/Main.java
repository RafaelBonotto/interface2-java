package application;

import entities.Contrato;
import entities.Parcela;
import services.ServicoDeContrato;
import services.ServicoDePagamento;
import services.ServicoDePagamentoOnline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Número: ");
        Integer numero = sc.nextInt();
        System.out.print("Data(dd/MM/yyyy): ");
        Date data = sdf.parse(sc.next());
        System.out.print("Valor do Contrato: ");
        double valorContrato = sc.nextDouble();

        Contrato contrato = new Contrato(numero, data, valorContrato);

        System.out.print("Entre com o número de parcelas: ");
        int N = sc.nextInt();

        ServicoDeContrato sdc = new ServicoDeContrato(new ServicoDePagamento());

        sdc.processarContrato(contrato, N);

        System.out.println("Parcelas: ");
        for(Parcela parc : contrato.getParcelas()){
            System.out.println(parc);
        }
        sc.close();


    }
}
