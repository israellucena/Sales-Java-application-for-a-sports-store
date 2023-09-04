import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Compra implements Serializable{
    //*Declarações*//
    private String nomeCliente;
    private long nif;
    String morada;
    LocalDate data;
    private int codigo;
    private double precoTotal;
    private double descontoTotal;
    private double precoFinal;
    private boolean entregue;
    ArrayList<Roupa> roupas;
    ArrayList<Calcado> calcados;
    ArrayList<Acessorio> acessorios;

    //*Construtor*//
    public Compra(String nomeCliente, long nif, String morada){
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        data = java.time.LocalDate.now();

        //*Leitura dos códigos já existentes*//
        ArrayList<Integer> codList = new ArrayList<Integer>();

        File file1 = new File("codsCompras.dat");
        try{
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);
            String linha;

            while(br.ready()){
                linha = br.readLine();
                int x = Integer.parseInt(linha);
                codList.add(x);
            }

            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //**//

        int m = (int) Math.pow(10, 6 - 1);
        boolean b = false;
        while(!b){
            b = true;
            codigo = m + new Random().nextInt(9 * m);
            for(int i = 0; i < codList.size(); i++)
                if(codList.get(i) == codigo)
                    b = false;
        }

        //*Escrita no ficheiro dos códigos existentes*//
        try{
            FileOutputStream os = new FileOutputStream("codsCompras.dat", true);
            PrintWriter pw = new PrintWriter(os);
            pw.println(codigo);
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //**//

        this.precoTotal = 0;
        this.descontoTotal = 0;
        this.precoFinal = this.precoTotal - this.descontoTotal;

        roupas = new ArrayList<Roupa>();
        calcados = new ArrayList<Calcado>();
        acessorios = new ArrayList<Acessorio>();

        entregue = false;
    }

    //*Métodos*//
    public String getNomeCliente(){
        return nomeCliente;
    }
    public long getNif(){
        return nif;
    }
    public String getMorada(){
        return morada;
    }
    public void setMorada(String morada){
        this.morada = morada;
    }
    public int getCodigo(){
        return codigo;
    }
    public double getPrecoTotal(){
        return precoTotal;
    }
    public double getDescontoTotal(){
        return descontoTotal;
    }
    public double getPrecoFinal(){
        return precoFinal;
    }
    public ArrayList getRoupa(){
        return roupas;
    }
    public void atualizar(){
        int preco = 0;
        int desconto = 0;

        for(int i = 0; i < roupas.size(); i++){
            preco += roupas.get(i).getPreco();
        }
        for(int i = 0; i < calcados.size(); i++){
            preco += calcados.get(i).getPreco();
        }
        for(int i = 0; i < acessorios.size(); i++){
            preco += acessorios.get(i).getPreco();
        }

        for(int i = 0; i < roupas.size(); i++){
            desconto += roupas.get(i).getDesconto();
        }
        for(int i = 0; i < calcados.size(); i++){
            desconto += calcados.get(i).getDesconto();
        }
        for(int i = 0; i < acessorios.size(); i++){
            desconto += acessorios.get(i).getDesconto();
        }

        precoTotal = preco;
        descontoTotal = desconto;
        precoFinal = precoTotal - descontoTotal;
    }
    public boolean getEntregue(){
        return entregue;
    }
    public void entregarProduto(){
        this.entregue = true;
        System.out.println("Venda entregue. \n");
    }
    public void adicionarRoupa(ArrayList<Roupa> listRoupa, int i){
        roupas.add(listRoupa.get(i));
        listRoupa.get(i).decEstoque();
        atualizar();
        System.out.println("Produto adicionado. \n");
    }
    public void adicionarCalcado(ArrayList<Calcado> listCalcado, int i){
        calcados.add(listCalcado.get(i));
        listCalcado.get(i).decEstoque();
        atualizar();
        System.out.println("Produto adicionado. \n");
    }
    public void adicionarAcessorio(ArrayList<Acessorio> listAcessorio, int i){
        listAcessorio.add(listAcessorio.get(i));
        listAcessorio.get(i).decEstoque();
        atualizar();
        System.out.println("Produto adicionado. \n");
    }
    public void removerRoupa(ArrayList<Roupa> listRoupa, int i){
        for(int j = 0; j < roupas.size(); j++){
            if(roupas.get(j).getCodigo() == listRoupa.get(i).getCodigo()){
                roupas.remove(j);
                listRoupa.get(i).incEstoque();
                atualizar();
                System.out.println("Produto removido. \n");
            }
        }
    }
    public void removerCalcado(ArrayList<Calcado> listCalcado, int i){
        for(int j = 0; j < calcados.size(); j++){
            if(calcados.get(j).getCodigo() == listCalcado.get(i).getCodigo()){
                calcados.remove(j);
                listCalcado.get(i).incEstoque();
                atualizar();
                System.out.println("Produto removido. \n");
            }
        }
    }
    public void removerAcessorio(ArrayList<Acessorio> listAcessorio, int i){
        for(int j = 0; j < acessorios.size(); j++){
            if(acessorios.get(j).getCodigo() == listAcessorio.get(i).getCodigo()){
                acessorios.remove(j);
                listAcessorio.get(i).incEstoque();
                atualizar();
                System.out.println("Produto removido. \n");
            }
        }
    }
    public String toString(){
        String s = "";

        s = "Nome do Cliente: " + nomeCliente + "\n" +
                "Nif do Cliente: " + nif + "\n" +
                "Morada do Cliente: " + morada + "\n" +
                "Data da Venda: " + data + "\n" +
                "Código: " + codigo + "\n" +
                "Preço final da compra: " + precoFinal + "\n" +
                "Desconto total recebido na compra: " + descontoTotal + "\n" +
                "O produto foi entregue? " + entregue + "\n" +
                "Produtos do pedido: \n";

        for(int i = 0; i < roupas.size(); i++)
            s += roupas.get(i).getNome() + "\n";

        for(int i = 0; i < calcados.size(); i++)
            s += calcados.get(i).getNome() + "\n";

        for(int i = 0; i < acessorios.size(); i++)
            s += acessorios.get(i).getNome() + "\n";

        return s;
    }
}
