import java.util.Scanner;
import java.text.DateFormat;

class Data {

    Scanner t = new Scanner(System.in);

    private int dia;
    private int mes;
    private int ano;

    public Data() {
        entraAno();
        entraAno(ano);
        entraDia();
        entraDia(dia);
        entraMes();
        entraMes(mes);
        mostra1();
        mostra2();
        System.out.print("Total de dias transcorridos: " + diasTranscorridos());
        apresentaDataAtual();
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void entraDia(int d) {
        this.dia = d;
    }

    public void entraMes(int m) {
        this.mes = m;
    }

    public void entraAno(int a) {
        this.ano = a;
    }

    public void entraDia() {
        System.out.print("Informe o dia: ");
        this.dia = t.nextInt();
        while (this.dia > 31 || this.dia < 1) {
            System.out.print("Informe o dia: ");
            this.dia = t.nextInt();
        }

    }

    public void entraMes() {
        boolean bissexto = bissexto();
        System.out.print("Informe o mes: ");
        this.mes = t.nextInt();
        while (this.mes > 12 || this.mes < 1) {
            System.out.print("Informe o mes: ");
            this.mes = t.nextInt();
        }
        if(this.dia > 30 && (this.mes == 2 || this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11)){
            System.out.print("Dia informado nao existe no mes / ano informados\nInforme o mes: ");
            this.mes = t.nextInt();
        }
        if(this.dia > 28 && this.mes == 2 && bissexto == false){
            System.out.print("Dia informado nao existe no mes / ano informados\nInforme o mes: ");
            this.mes = t.nextInt();
        }
    }

    public void entraAno() {
        System.out.print("Informe o ano: ");
        this.ano = t.nextInt();
        while (this.ano < 0) {
            System.out.print("Informe o ano: ");
            this.ano = t.nextInt();
        }
    }

    public int retDia() {
        return (this.dia);
    }

    public int retMes() {
        return (this.mes);
    }

    public int retAno() {
        return (this.ano);
    }

    public void mostra1() {
        System.out.println(this.retDia() + "/" + this.retMes() + "/" + this.retAno());
    }

    public void mostra2() {
        String[]meses = {"Janeiro","Fevereiro", "Março", "Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        System.out.println(this.retDia() + "/" + meses[this.mes - 1] + "/" + this.retAno());
    }

    public boolean bissexto() {
        if(this.ano % 4 == 0){
            if(this.ano % 100 == 0){
                if(this.ano % 400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    public int diasTranscorridos() {
        boolean bissexto = bissexto();
        int[] diasmes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int contador = 0;
        int total = 0;
        if(bissexto == true){
            while(contador < this.mes){
                total += diasmes[contador];
                contador++;
            }
            total += 1;
        }
        else{
            while(contador < this.mes){
                total += diasmes[contador];
                contador++;
            }
        }
        return total;
    }
    void apresentaDataAtual(){
        DateFormat atual = DateFormat.getDateInstance(DateFormat.FULL);
    }
}

public class DataTP {

    public static void main(String[] args) {
        Data data = new Data();
    }

}