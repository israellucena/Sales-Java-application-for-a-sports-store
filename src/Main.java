import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.time.*;

public class Main implements Serializable{
    public static void main(String[] args) throws IOException{
        //*Declarações*//
        ArrayList<Roupa> listRoupa = new ArrayList<Roupa>();
        ArrayList<Calcado> listCalcado = new ArrayList<Calcado>();
        ArrayList<Acessorio> listAcessorio = new ArrayList<Acessorio>();
        ArrayList<Compra> listCompras = new ArrayList<Compra>();

        //*Ler Ficheiro*//
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("Roupas.dat"));
            listRoupa = (ArrayList<Roupa>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("Calcados.dat"));
            listCalcado = (ArrayList<Calcado>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("Acessorios.dat"));
            listAcessorio = (ArrayList<Acessorio>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("Compras.dat"));
            listCompras = (ArrayList<Compra>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //*Loop*//
        while(true){
            //*Declarações*//
            //*Aqui as strings e inteiros são inicializados em branco ou em 0 para assegurar que não serão reutilizados, devido ao loop, com valores anteriores*//
            int opcao = 0, opcaoRoupa, codPesquisa = 0;
            boolean b = false; // Auxílio para saber se algum poduto foi excluído
            Produto p; String nome = ""; double desconto = 0, preco = 0; int estoque = 0;
            Roupa r; String tipo = "", tamanho = "", marca = "", sexo = "";
            Calcado c;
            Acessorio a;
            Compra compra; int nif = 0; String morada = "";

            System.out.println("Escolha uma opção a seguir: \n" +
                               "1. Gerir Produtos \n" +
                               "2. Gerir Vendas \n" +
                               "3. Estatísticas \n" +
                               "4. Encerrar Sistema \n");
            opcao = Ler.umInt();

            switch(opcao){
                case 1:
                    outer:
                    while(true){
                        opcaoRoupa = 0;
                        System.out.println("Escolha uma opção a seguir: \n" +
                                           "1. Criar Produto \n" +
                                           "2. Excluir Produto \n" +
                                           "3. Pesquisar Produto \n" +
                                           "4. Editar Produto \n" +
                                           "5. Sair \n");
                        opcao = Ler.umInt();
                        switch(opcao){
                            case 1:
                                System.out.println("Escolha uma categoria para o produto: \n" +
                                                   "1. Roupa \n" +
                                                   "2. Calçado \n" +
                                                   "3. Acessório \n" +
                                                   "4. Sair \n");
                                opcao = Ler.umInt();

                                switch(opcao){
                                    case 1:
                                        //*Criação do objeto Produto*//
                                        System.out.println("Escreva o nome do produto: ");
                                        nome = Ler.umaString();
                                        System.out.println("Digite o preço do produto: ");
                                        preco = Ler.umDouble();
                                        preco = Ler.umPositivo(preco);
                                        System.out.println("Digite o desconto do produto: ");
                                        desconto = Ler.umDouble();
                                        desconto = Ler.umDesconto(desconto,preco);
                                        System.out.println("Digite o estoque do produto: ");
                                        estoque = Ler.umInt();
                                        estoque = (int) Ler.umPositivo(estoque);

                                        //*Criação do objeto Roupa*//
                                        System.out.println("Escreva o tipo de roupa(Camiseta, Casacos, Calça, Calção, Roupa de Banho e etc): ");
                                        tipo = Ler.umaString();
                                        System.out.println("Escreva o tamanho da roupa: ");
                                        tamanho = Ler.umaString();
                                        System.out.println("Escreva a marca da roupa: ");
                                        marca = Ler.umaString();

                                        while(opcaoRoupa != 1 && opcaoRoupa != 2 && opcaoRoupa != 3 && opcaoRoupa != 4){
                                            System.out.println("Escolha o sexo da roupa: \n" +
                                                               "1. Homem \n" +
                                                               "2. Mulher \n" +
                                                               "3. Unisex \n" +
                                                               "4. Criança \n");
                                            opcaoRoupa = Ler.umInt();
                                            switch (opcaoRoupa){
                                                case 1:
                                                    sexo = "Homem";
                                                    break;
                                                case 2:
                                                    sexo = "Mulher";
                                                    break;
                                                case 3:
                                                    sexo = "Unisex";
                                                    break;
                                                case 4:
                                                    sexo = "Criança";
                                                    break;
                                                default:
                                                    System.out.println("A opção não é válida. Tente novamente.");
                                                    break;
                                            }
                                        }

                                        p = new Produto(nome, desconto, preco, estoque);
                                        r = new Roupa(p, tipo, tamanho, marca, sexo);
                                        System.out.println("Produto criado. \n");
                                        listRoupa.add(r);

                                        //*Escrita em Ficheiro das Roupas*//
                                        try {
                                            ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("Roupas.dat"));
                                            os.writeObject(listRoupa);
                                            os.flush();
                                        }
                                        catch (IOException e){
                                            System.out.println(e.getMessage());
                                        }

                                        break;

                                    case 2:
                                        //*Criação do objeto Produto*//
                                        System.out.println("Escreva o nome do produto: ");
                                        nome = Ler.umaString();
                                        System.out.println("Digite o preço do produto: ");
                                        preco = Ler.umDouble();
                                        preco = Ler.umPositivo(preco);
                                        System.out.println("Digite o desconto do produto: ");
                                        desconto = Ler.umDouble();
                                        desconto = Ler.umDesconto(desconto,preco);
                                        System.out.println("Selecione o estoque do produto: ");
                                        estoque = Ler.umInt();
                                        estoque = (int) Ler.umPositivo(estoque);

                                        //*Criação do objeto Calçado*//
                                        System.out.println("Escreva o tipo de calçado(Tênis, Chuteira, Chinelo, Calçado para corrida, Bota e etc): ");
                                        tipo = Ler.umaString();
                                        System.out.println("Escreva o tamanho do calçado: ");
                                        tamanho = Ler.umaString();
                                        System.out.println("Escreva a marca do calçado: ");
                                        marca = Ler.umaString();

                                        while(opcaoRoupa != 1 && opcaoRoupa != 2 && opcaoRoupa != 3 && opcaoRoupa != 4){
                                            System.out.println("Escolha o sexo do calçado: \n" +
                                                    "1. Homem \n" +
                                                    "2. Mulher \n" +
                                                    "3. Unisex \n" +
                                                    "4. Criança \n");
                                            opcaoRoupa = Ler.umInt();
                                            switch (opcaoRoupa){
                                                case 1:
                                                    sexo = "Homem";
                                                    break;
                                                case 2:
                                                    sexo = "Mulher";
                                                    break;
                                                case 3:
                                                    sexo = "Unisex";
                                                    break;
                                                case 4:
                                                    sexo = "Criança";
                                                    break;
                                                default:
                                                    System.out.println("O opção não é válida. Tente novamente.");
                                                    break;
                                            }
                                        }

                                        p = new Produto(nome, desconto, preco, estoque);
                                        c = new Calcado(p, tipo, tamanho, marca, sexo);
                                        System.out.println("Produto criado. \n");
                                        listCalcado.add(c);

                                        //*Escrita em Ficheiro dos Calçados*//
                                        try {
                                            ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("Calcados.dat"));
                                            os.writeObject(listCalcado);
                                            os.flush();
                                        }
                                        catch (IOException e){
                                           System.out.println(e.getMessage());
                                        }

                                        break;

                                    case 3:
                                        //*Criação do objeto Produto*//
                                        System.out.println("Escreva o nome do produto: ");
                                        nome = Ler.umaString();
                                        System.out.println("Digite o preco do produto: ");
                                        preco = Ler.umDouble();
                                        preco = Ler.umPositivo(preco);
                                        System.out.println("Digite o desconto do produto: ");
                                        desconto = Ler.umDouble();
                                        desconto = Ler.umDesconto(desconto,preco);
                                        System.out.println("Selecione o estoque do produto: ");
                                        estoque = Ler.umInt();
                                        estoque = (int) Ler.umPositivo(estoque);

                                        //*Criação do objeto Acessorio*//
                                        System.out.println("Escreva o tipo de acessório(Mochila, Boné, Gorro, Meia, Óculos de Sol, Garrafa, Bola e etc): ");
                                        tipo = Ler.umaString();
                                        System.out.println("Escreva o tamanho do acessório: ");
                                        tamanho = Ler.umaString();
                                        System.out.println("Escreva a marca do acessório: ");
                                        marca = Ler.umaString();

                                        while(opcaoRoupa != 1 && opcaoRoupa != 2 && opcaoRoupa != 3 && opcaoRoupa != 4){
                                            System.out.println("Escolha o sexo do acessório: \n" +
                                                    "1. Homem \n" +
                                                    "2. Mulher \n" +
                                                    "3. Unisex \n" +
                                                    "4. Criança \n");
                                            opcaoRoupa = Ler.umInt();
                                            switch (opcaoRoupa){
                                                case 1:
                                                    sexo = "Homem";
                                                    break;
                                                case 2:
                                                    sexo = "Mulher";
                                                    break;
                                                case 3:
                                                    sexo = "Unisex";
                                                    break;
                                                case 4:
                                                    sexo = "Criança";
                                                    break;
                                                default:
                                                    System.out.println("A opção não é válida. Tente novamente.");
                                                    break;
                                            }
                                        }

                                        p = new Produto(nome, desconto, preco, estoque);
                                        a = new Acessorio(p, tipo, tamanho, marca, sexo);
                                        System.out.println("Produto criado. \n");
                                        listAcessorio.add(a);

                                        //*Escrita em Ficheiro de Acessórios*//
                                        try {
                                            ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("Acessorios.dat"));
                                            os.writeObject(listAcessorio);
                                            os.flush();
                                        }
                                        catch (IOException e){
                                            System.out.println(e.getMessage());
                                        }

                                        break;

                                    case 4:
                                        System.out.println("Saindo...");
                                        break;

                                    default:
                                        System.out.println("A opção é inválida. Tente novamente.");
                                        break;
                                }
                                break;

                            case 2:
                                System.out.println("Selecione o código do produto que deseja excluir: ");
                                codPesquisa = Ler.umInt();
                                for(int i = 0; i < listRoupa.size(); i++){
                                    if(listRoupa.get(i).getCodigo() == codPesquisa){
                                        Produto.atualizarFicheiroCod(listRoupa.get(i).getCodigo());
                                        listRoupa.remove(i);
                                        System.out.println("Produto excluído. \n");
                                        b = true;
                                    }
                                }
                                for(int i = 0; i < listCalcado.size(); i++){
                                    if(listCalcado.get(i).getCodigo() == codPesquisa){
                                        Produto.atualizarFicheiroCod(listCalcado.get(i).getCodigo());
                                        listCalcado.remove(i);
                                        System.out.println("Produto excluído. \n");
                                        b = true;
                                    }
                                }
                                for(int i = 0; i < listAcessorio.size(); i++){
                                    if(listAcessorio.get(i).getCodigo() == codPesquisa){
                                        Produto.atualizarFicheiroCod(listAcessorio.get(i).getCodigo());
                                        listAcessorio.remove(i);
                                        System.out.println("Produto excluído. \n");
                                        b = true;
                                    }
                                }
                                if(!b)
                                    System.out.println("O produto não existe. \n");
                                break;

                            case 3:
                                PesquisarProduto.pesquisarProduto(listRoupa, listCalcado, listAcessorio, listCompras);
                                break;

                            case 4:
                                EditarProduto.editarProduto(listRoupa, listCalcado, listAcessorio);
                                break;

                            case 5:
                                System.out.println("Saindo... \n");
                                break outer;

                            default:
                                System.out.println("A opção é inválida. Tente Novamente. \n");
                                break outer;
                        }
                    }
                    break;

                case 2:
                    outer2:
                    while(true){
                        System.out.println("Escolha uma opção a seguir: \n" +
                                "1. Vendas em Andamento \n" +
                                "2. Vendas Finalizadas \n" +
                                "3. Realizar uma venda\n" +
                                "4. Entregar Produto \n" +
                                "5. Sair \n");
                        opcao = Ler.umInt();
                        switch(opcao){
                            case 1:
                                for(int i = 0; i < listCompras.size(); i++){
                                    if(!listCompras.get(i).getEntregue()){
                                        System.out.println("Vendas não entregues: \n");
                                        System.out.println(listCompras.get(i).toString());
                                    }
                                }
                                break;

                            case 2:
                                for(int i = 0; i < listCompras.size(); i++){
                                    if(listCompras.get(i).getEntregue()){
                                        System.out.println("Vendas entregues: \n");
                                        System.out.println(listCompras.get(i).toString());
                                    }
                                }
                                break;

                            case 3:

                                System.out.println("Escreva o nome do cliente: ");
                                nome = Ler.umaString();
                                System.out.println("Digite o nif do cliente: ");
                                nif = Ler.umInt();
                                System.out.println("Escreva a morada de entrega: ");
                                morada = Ler.umaString();

                                compra = new Compra(nome,nif,morada);

                                outer3:
                                while(true){
                                    System.out.println("Escolha uma opção a seguir: \n" +
                                            "1. Adicionar Produto à Venda \n" +
                                            "2. Excluir Produto da Venda\n" +
                                            "3. Sair e Confirmar\n");
                                    opcao = Ler.umInt();

                                    switch(opcao){
                                        case 1:
                                            System.out.print("Digite o código do produto que deseja adicionar: ");
                                            codPesquisa = Ler.umInt();

                                            for(int i = 0; i < listRoupa.size(); i++){
                                                if(listRoupa.get(i).getCodigo() == codPesquisa){
                                                    if(listRoupa.get(i).getEstoque() > 0){
                                                        compra.adicionarRoupa(listRoupa, i);
                                                        b = true;
                                                    }
                                                }
                                            }
                                            for(int i = 0; i < listCalcado.size(); i++){
                                                if(listCalcado.get(i).getCodigo() == codPesquisa){
                                                    if(listCalcado.get(i).getEstoque() > 0){
                                                        compra.adicionarCalcado(listCalcado, i);
                                                        b = true;
                                                    }
                                                }
                                            }
                                            for(int i = 0; i < listAcessorio.size(); i++){
                                                if(listAcessorio.get(i).getCodigo() == codPesquisa){
                                                    if(listAcessorio.get(i).getEstoque() > 0){
                                                        compra.adicionarAcessorio(listAcessorio, i);
                                                        b = true;
                                                    }
                                                }
                                            }
                                            if(!b)
                                                System.out.println("O produto não existe ou não possui estoque. \n");

                                            break;

                                        case 2:
                                            System.out.print("Digite o código do produto que deseja remover: ");
                                            codPesquisa = Ler.umInt();

                                            for(int i = 0; i < listRoupa.size(); i++){
                                                if(listRoupa.get(i).getCodigo() == codPesquisa){
                                                    compra.removerRoupa(listRoupa, i);
                                                    b = true;
                                                }
                                            }
                                            for(int i = 0; i < listCalcado.size(); i++){
                                                if(listCalcado.get(i).getCodigo() == codPesquisa){
                                                    compra.removerCalcado(listCalcado, i);
                                                    b = true;
                                                }
                                            }
                                            for(int i = 0; i < listAcessorio.size(); i++){
                                                if(listAcessorio.get(i).getCodigo() == codPesquisa){
                                                    compra.removerAcessorio(listAcessorio, i);
                                                    b = true;
                                                }
                                            }
                                            if(!b)
                                                System.out.println("O produto não existe. \n");

                                            break;

                                        case 3:
                                            System.out.println("Saindo... \n");
                                            break outer3;

                                        default:
                                            System.out.println("Opção inválida. Tente novamente. \n");
                                            break outer3;
                                    }
                                }

                                listCompras.add(compra);

                                //*Escrita em Ficheiro dos Calçados*//
                                try {
                                    ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("Compras.dat"));
                                    os.writeObject(listCompras);
                                    os.flush();
                                }
                                catch (IOException e){
                                    System.out.println(e.getMessage());
                                }

                                break;

                            case 4:
                                System.out.print("Digite o código da compra que deseja entregar: ");
                                codPesquisa = Ler.umInt();

                                for(int i = 0; i < listCompras.size(); i++){
                                    if(listCompras.get(i).getCodigo() == codPesquisa){
                                        listCompras.get(i).entregarProduto();
                                    }
                                }

                                //*Escrita em Ficheiro dos Calçados*//
                                try {
                                    ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("Compras.dat"));
                                    os.writeObject(listCompras);
                                    os.flush();
                                }
                                catch (IOException e){
                                    System.out.println(e.getMessage());
                                }

                                break;

                            case 5:
                                System.out.println("Saindo... \n");
                                break outer2;

                            default:
                                System.out.println("A opção é inválida. Tente Novamente. \n");
                                break outer2;
                        }
                    }
                    break;

                case 3:
                    Estatisticas.Estatisticas(listRoupa, listCalcado, listAcessorio, listCompras);
                    break;

                case 4:
                    System.out.println("Encerrando sistema... \n");
                    return;

                default:
                    System.out.println("A opção é inválida. Tente Novamente. \n");
                    break;
            }
        }
    }
}

