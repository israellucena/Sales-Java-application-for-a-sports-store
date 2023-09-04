import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Produto implements Serializable{
    //*Declarações*//
      private String nome;
      private int codigo;
      LocalDate data;
      private double desconto;
      private double preco;
      private double precofinal;
      private int estoque;

    //*Contrutores*//
    public Produto(String nome, double desconto, double preco, int estoque){
        this.nome = nome;

        //*Leitura dos códigos já existentes*//
        ArrayList<Integer> codList = new ArrayList<Integer>();
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("cods.dat"));
            codList = (ArrayList<Integer>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
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

        data = java.time.LocalDate.now();
        this.desconto = desconto;
        this.preco = preco;
        precofinal = preco - this.desconto;
        this.estoque = estoque;
    }

    public Produto(String nome, double desconto, double preco, int estoque, int codigo){
        this.nome = nome;
        this.codigo = codigo;
        data = java.time.LocalDate.now();
        this.desconto = desconto;
        this.preco = preco;
        precofinal = preco - this.desconto;
        this.estoque = estoque;

        //*Leitura dos códigos já existentes*//
        ArrayList<Integer> codList = new ArrayList<Integer>();
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("cods.dat"));
            codList = (ArrayList<Integer>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //**//

        codList.add(codigo);

        //*Atualização*//
        try {
            ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("cods.dat"));
            os.writeObject(codList);
            os.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        //**//

    }

    //*Métodos*//
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data){
        this.data = data;
    }
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        if(desconto > preco){
            System.out.println("O valor não é aplicável. \n");
            return;
        }

        this.desconto = desconto;
        precofinal = preco - this.desconto;
    }
    public void setPorcDesconto(double desconto) {
        if (desconto <= 100){
            this.desconto = (desconto*preco)/100;
            precofinal = preco - this.desconto;
        }
        else
            System.out.println("A porcentagem não pode ser aplicada");
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPrecoFinal() {
        return precofinal;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public void incEstoque(int x) {
        estoque = estoque + x;
    }
    public String toString(){
        return "Nome: " + nome + "\n" +
               "Código: " + codigo + "\n" +
               "Data de Lançamento: " + data + "\n" +
               "Desconto: " + desconto + "\n" +
               "Preço: " + preco + "\n" +
               "Preço Final: " + precofinal + "\n" +
               "Estoque: " + estoque + "\n";
    }
    public static void atualizarFicheiroCod(int codDel){
        //*Leitura dos códigos já existentes*//
        ArrayList<Integer> codList = new ArrayList<Integer>();
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("cods.dat"));
            codList = (ArrayList<Integer>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for(int i = 0; i < codList.size(); i++){
            if(codList.get(i) == codDel)
                codList.remove(i);
        }
        //**//

        //*Atualização*//
        try {
            ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("cods.dat"));
            os.writeObject(codList);
            os.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        //**//
    }
}
