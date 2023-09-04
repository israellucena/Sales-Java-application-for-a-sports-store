import java.io.Serializable;
import java.util.ArrayList;

public class Calcado extends Produto implements Serializable{
    //*Declarações*//
    private String tipo;
    private String tamanho;
    private String desporto;
    private String cor;
    private String marca;
    private String sexo;

    //*Construtores*//
    public Calcado(Produto p, String tipo, String tamanho, String marca, String sexo){
        super(p.getNome(),p.getDesconto(),p.getPreco(),p.getEstoque(), p.getCodigo());
        this.tipo = tipo;
        this.tamanho = tamanho;
        desporto = "";
        cor = "";
        this.marca = marca;
        this.sexo = sexo;
    }

    //*Métodos*//
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTamanho(){
        return tamanho;
    }
    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }
    public String getDesporto(){
        return desporto;
    }
    public void setDesporto(String desporto){
        this.desporto = desporto;
    }
    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getSexo(){
        return sexo;
    }
    public void setSexo(){
        int opcao = 0;
        System.out.println("Escolha o novo sexo da roupa: \n" +
                "1. Homem \n" +
                "2. Mulher \n" +
                "3. Unisex \n" +
                "4. Criança \n");
        opcao = Ler.umInt();
        switch (opcao){
            case 1:
                this.sexo = "Homem";
                break;
            case 2:
                this.sexo = "Mulher";
                break;
            case 3:
                this.sexo = "Unisex";
                break;
            case 4:
                this.sexo = "Criança";
                break;
            default:
                System.out.println("O opção é inválida.\n");
                break;
        }
    }

    public String getNome(){
        return super.getNome();
    }
    public void setNome(String nome){
        super.setNome(nome);
    }
    public double getDesconto(){
        return super.getDesconto();
    }
    public void setDesconto(double desconto){
        super.setDesconto(desconto);
    }
    public double getPreco(){
        return super.getPreco();
    }
    public void setPreco(double preco){
        super.setPreco(preco);
    }
    public int getEstoque(){
        return super.getEstoque();
    }
    public void setEstoque(int estoque){
        super.setEstoque(estoque);
    }
    public void decEstoque(){
        super.setEstoque(getEstoque() - 1);
    }
    public void incEstoque(){
        super.setEstoque(getEstoque() + 1);
    }
    public Object clone(){
        Calcado novo = new Calcado(new Produto(super.getNome(), super.getDesconto(), super.getPreco(), super.getEstoque()), this.tipo, this.tamanho, this.marca, this.sexo);
        return novo;
    }
    public String toString(){
        return super.toString() +
                "Tipo: " + tipo + "\n" +
                "Tamanho: " + tamanho + "\n"+
                "Desporto: " + desporto + "\n"+
                "Cor: " + cor + "\n"+
                "Marca: " + marca + "\n"+
                "Sexo: " + sexo + "\n";
    }
}
