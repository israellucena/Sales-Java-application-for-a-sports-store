import java.io.*;
import java.util.ArrayList;

public class EditarProduto extends Main implements Serializable{

    public static void editarProduto(ArrayList<Roupa> roupas, ArrayList<Calcado> calcado, ArrayList<Acessorio> acessorio){
        boolean cont = true, b;
        int codProduto, i;

        //*Leitura do Código*//
        System.out.println("Selecione o código do produto que deseja editar: ");
        codProduto = Ler.umInt();
        b = verificarProduto(roupas, calcado, acessorio, codProduto);
        if(!b){
            System.out.println("O produto não existe. \n");
            return;
        }
        else{
            i = verificarIndice(roupas, calcado, acessorio, codProduto);
        }

        while (cont){
            //*Declarações*//
            int opcao = 0;
            String s = "";

            //*Método de edição*//
            System.out.println("Escolha o campo que dejesa editar: \n" +
                    "1. Nome\n" + "2. Tipo\n" + "3. Tamanho\n" + "4. Sexo\n" + "5. Categoria\n" +
                    "6. Cor\n" + "7. Desporto\n" + "8. Marca\n" + "9. Preço\n" + "10. Desconto\n" +
                    "11. Estoque\n" + "12.Sair\n");
            opcao = Ler.umInt();

            switch (opcao){
                //Nome
                case 1:
                    System.out.println("Escreva o novo nome do produto: ");
                    s = Ler.umaString();

                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setNome(s);
                        System.out.println("Nome editado. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setNome(s);
                        System.out.println("Nome editado. \n");
                    }

                    if(calcado.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setNome(s);
                        System.out.println("Nome editado. \n");
                    }

                    cont = false;
                    break;

                //Tipo
                case 2:
                    System.out.println("Escreva o novo tipo do produto: ");
                    s = Ler.umaString();

                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setTipo(s);
                        System.out.println("Tipo editado. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setTipo(s);
                        System.out.println("Tipo editado. \n");
                    }

                    if(acessorio.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setTipo(s);
                        System.out.println("Tipo editado. \n");
                    }

                    cont = false;
                    break;

                //Tamanho
                case 3:
                    System.out.println("Escreva o novo tamanho do produto: ");
                    s = Ler.umaString();

                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setTamanho(s);
                        System.out.println("Tamanho editado. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setTamanho(s);
                        System.out.println("Tamanho editado. \n");
                    }

                    if(acessorio.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setTamanho(s);
                        System.out.println("Tamanho editado. \n");
                    }

                    cont = false;
                    break;

                //Sexo
                case 4:
                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setSexo();
                        System.out.println("Sexo editado. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setSexo();
                        System.out.println("Sexo editado. \n");
                    }

                    if(acessorio.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setSexo();
                        System.out.println("Sexo editado. \n");
                    }

                    cont = false;
                    break;

                //Categoria
                case 5:
                    System.out.println("Escolha a nova categoria desejada: \n" +
                            "1. Roupa\n" +
                            "2. Calçado\n" +
                            "3. Acessório\n");
                    opcao = Ler.umInt();

                    switch(opcao){
                        case 1:
                            Roupa r;
                            if(roupas.size() > i)
                            if(roupas.get(i).getCodigo() == codProduto)
                                System.out.println("O produto já possui essa categoria. \n");

                            if(calcado.size() > i)
                            if(calcado.get(i).getCodigo() == codProduto){
                                r = new Roupa(new Produto(calcado.get(i).getNome(), calcado.get(i).getDesconto(), calcado.get(i).getPreco(), calcado.get(i).getEstoque(), codProduto), calcado.get(i).getTipo(), calcado.get(i).getTamanho(), calcado.get(i).getMarca(), calcado.get(i).getSexo());
                                r.setDesporto(calcado.get(i).getDesporto());
                                r.setCor(calcado.get(i).getCor());
                                r.setData(calcado.get(i).getData());
                                roupas.add(r);
                                calcado.remove(i);
                                System.out.println("Categoria editada. \n");
                            }

                            if(acessorio.size() > i)
                            if(acessorio.get(i).getCodigo() == codProduto){
                                r = new Roupa(new Produto(acessorio.get(i).getNome(), acessorio.get(i).getDesconto(), acessorio.get(i).getPreco(), acessorio.get(i).getEstoque(), codProduto), acessorio.get(i).getTipo(), acessorio.get(i).getTamanho(), acessorio.get(i).getMarca(), acessorio.get(i).getSexo());
                                r.setDesporto(acessorio.get(i).getDesporto());
                                r.setCor(acessorio.get(i).getCor());
                                r.setData(acessorio.get(i).getData());
                                roupas.add(r);
                                acessorio.remove(i);
                                System.out.println("Categoria editada. \n");
                            }

                        case 2:
                            Calcado c;
                            if(roupas.size() > i)
                            if(roupas.get(i).getCodigo() == codProduto){
                                c = new Calcado(new Produto(roupas.get(i).getNome(), roupas.get(i).getDesconto(), roupas.get(i).getPreco(), roupas.get(i).getEstoque(), codProduto), roupas.get(i).getTipo(), roupas.get(i).getTamanho(), roupas.get(i).getMarca(), roupas.get(i).getSexo());
                                c.setDesporto(roupas.get(i).getDesporto());
                                c.setCor(roupas.get(i).getCor());
                                c.setData(roupas.get(i).getData());
                                calcado.add(c);
                                roupas.remove(i);
                                System.out.println("Categoria editada. \n");
                            }

                            if(calcado.size() > i)
                            if(calcado.get(i).getCodigo() == codProduto)
                                System.out.println("O produto já possui essa categoria. \n");

                            if(acessorio.size() > i)
                            if(acessorio.get(i).getCodigo() == codProduto){
                                c = new Calcado(new Produto(acessorio.get(i).getNome(), acessorio.get(i).getDesconto(), acessorio.get(i).getPreco(), acessorio.get(i).getEstoque(), codProduto), acessorio.get(i).getTipo(), acessorio.get(i).getTamanho(), acessorio.get(i).getMarca(), acessorio.get(i).getSexo());
                                c.setDesporto(acessorio.get(i).getDesporto());
                                c.setCor(acessorio.get(i).getCor());
                                c.setData(acessorio.get(i).getData());
                                calcado.add(c);
                                acessorio.remove(i);
                                System.out.println("Categoria editada. \n");
                            }

                        case 3:
                            Acessorio a;
                            if(roupas.size() > i)
                            if(roupas.get(i).getCodigo() == codProduto){
                                a = new Acessorio(new Produto(roupas.get(i).getNome(), roupas.get(i).getDesconto(), roupas.get(i).getPreco(), roupas.get(i).getEstoque(), codProduto), roupas.get(i).getTipo(), roupas.get(i).getTamanho(), roupas.get(i).getMarca(), roupas.get(i).getSexo());
                                a.setDesporto(roupas.get(i).getDesporto());
                                a.setCor(roupas.get(i).getCor());
                                a.setData(roupas.get(i).getData());
                                acessorio.add(a);
                                roupas.remove(i);
                                System.out.println("Categoria editada. \n");
                            }

                            if(calcado.size() > i)
                            if(calcado.get(i).getCodigo() == codProduto){
                                a = new Acessorio(new Produto(calcado.get(i).getNome(), calcado.get(i).getDesconto(), calcado.get(i).getPreco(), calcado.get(i).getEstoque(), codProduto), calcado.get(i).getTipo(), calcado.get(i).getTamanho(), calcado.get(i).getMarca(), calcado.get(i).getSexo());
                                a.setDesporto(calcado.get(i).getDesporto());
                                a.setCor(calcado.get(i).getCor());
                                a.setData(calcado.get(i).getData());
                                acessorio.add(a);
                                calcado.remove(i);
                                System.out.println("Categoria editada. \n");
                            }

                            if(acessorio.size() > i)
                            if(acessorio.get(i).getCodigo() == codProduto)
                                System.out.println("O produto já possui essa categoria. \n");

                        default:
                            System.out.println("A opção é inválida. Tente novamente.\n");
                            break;
                    }
                    cont = false;
                    break;

                //Cor
                case 6:
                    System.out.println("Escreva a nova cor do produto: ");
                    s = Ler.umaString();

                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setCor(s);
                        System.out.println("Cor editada. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setCor(s);
                        System.out.println("Cor editada. \n");
                    }

                    if(acessorio.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setCor(s);
                        System.out.println("Cor editada. \n");
                    }

                    cont = false;
                    break;

                //Desporto
                case 7:
                    System.out.println("Escreva o novo desporto do produto: ");
                    s = Ler.umaString();

                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setDesporto(s);
                        System.out.println("Desporto editado. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setDesporto(s);
                        System.out.println("Desporto editado. \n");
                    }

                    if(acessorio.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setDesporto(s);
                        System.out.println("Desporto editado. \n");
                    }

                    cont = false;
                    break;

                //Marca
                case 8:
                    System.out.println("Escreva a nova marca do produto: ");
                    s = Ler.umaString();

                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setMarca(s);
                        System.out.println("Marca editada. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setMarca(s);
                        System.out.println("Marca editada. \n");
                    }

                    if(acessorio.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setMarca(s);
                        System.out.println("Marca editada. \n");
                    }

                    cont = false;
                    break;

                //Preço
                case 9:
                    double preco;
                    System.out.println("Selecione o novo preço do produto: \n");
                    preco = Ler.umDouble();
                    preco = Ler.umPositivo(preco);

                    if(roupas.size() > i)
                    if(roupas.get(i).getCodigo() == codProduto){
                        roupas.get(i).setPreco(preco);
                        System.out.println("Preço editado. \n");
                    }

                    if(calcado.size() > i)
                    if(calcado.get(i).getCodigo() == codProduto){
                        calcado.get(i).setPreco(preco);
                        System.out.println("Preço editado. \n");
                    }

                    if(acessorio.size() > i)
                    if(acessorio.get(i).getCodigo() == codProduto){
                        acessorio.get(i).setPreco(preco);
                        System.out.println("Preço editado. \n");
                    }

                    cont = false;
                    break;

                //Desconto
                case 10:
                    System.out.println("Selecione como deseja editar o desconto:\n" +
                            "1. Desconto por porcentagem\n" +
                            "2. Desconto por valor líquido\n");
                    opcao = Ler.umInt();

                    switch (opcao){
                        case 1:
                            int x;
                            if(roupas.size() > i)
                            if(roupas.get(i).getCodigo() == codProduto){
                                System.out.println("Digite a porcentagem de desconto: \n");
                                x = Ler.umInt();
                                roupas.get(i).setPorcDesconto(x);
                                System.out.println("Novo desconto aplicado\n");
                            }

                            if(calcado.size() > i)
                            if(calcado.get(i).getCodigo() == codProduto){
                                System.out.println("Digite a porcentagem de desconto: \n");
                                x = Ler.umInt();
                                calcado.get(i).setPorcDesconto(x);
                                System.out.println("Novo desconto aplicado\n");
                            }

                            if(acessorio.size() > i)
                            if(acessorio.get(i).getCodigo() == codProduto){
                                System.out.println("Digite a porcentagem de desconto: \n");
                                x = Ler.umInt();
                                acessorio.get(i).setPorcDesconto(x);
                                System.out.println("Novo desconto aplicado\n");
                            }
                            break;

                        case 2:
                            double y;
                            if(roupas.size() > i)
                            if(roupas.get(i).getCodigo() == codProduto){
                                System.out.println("Digite o valor líquido de desconto: \n");
                                y = Ler.umDouble();
                                y = Ler.umDesconto(y, roupas.get(i).getPreco());
                                roupas.get(i).setDesconto(y);
                                System.out.println("Novo desconto aplicado\n");
                            }

                            if(calcado.size() > i)
                            if(calcado.get(i).getCodigo() == codProduto){
                                System.out.println("Digite o valor líquido de desconto: \n");
                                y = Ler.umDouble();
                                y = Ler.umDesconto(y, calcado.get(i).getPreco());
                                calcado.get(i).setDesconto(y);
                                System.out.println("Novo desconto aplicado\n");
                            }

                            if(acessorio.size() > i)
                            if(acessorio.get(i).getCodigo() == codProduto){
                                System.out.println("Digite o valor líquido de desconto: \n");
                                y = Ler.umDouble();
                                y =  Ler.umDesconto(y, acessorio.get(i).getPreco());
                                acessorio.get(i).setDesconto(y);
                                System.out.println("Novo desconto aplicado\n");
                            }
                            break;

                        default:
                            System.out.println("A opção é inválida. Tente novamente. \n");
                            break;
                    }
                    cont = false;
                    break;

                //Estoque
                case 11:
                    System.out.println("Selecione como deseja editar o estoque: \n" +
                            "1. Adicionar quantidade ao estoque\n" +
                            "2. Selecionar estoque total\n");
                    opcao = Ler.umInt();

                    switch (opcao){
                        case 1:
                            int x;
                            if(roupas.size() > i)
                            if(roupas.get(i).getCodigo() == codProduto){
                                System.out.println("Digite a quantidade a adicionar ao estoque: \n");
                                x = Ler.umInt();
                                roupas.get(i).incEstoque(x);
                                System.out.println("Estoque incrementado.\n");
                            }

                            if(calcado.size() > i)
                            if(calcado.get(i).getCodigo() == codProduto){
                                System.out.println("Digite a quantidade a adicionar ao estoque: \n");
                                x = Ler.umInt();
                                calcado.get(i).incEstoque(x);
                                System.out.println("Estoque incrementado.\n");
                            }

                            if(acessorio.size() > i)
                            if(acessorio.get(i).getCodigo() == codProduto){
                                System.out.println("Digite a quantidade a adicionar ao estoque: \n");
                                x = Ler.umInt();
                                acessorio.get(i).incEstoque(x);
                                System.out.println("Estoque incrementado.\n");
                            }
                            break;

                        case 2:
                            int y;
                            if(roupas.size() > i)
                            if(roupas.get(i).getCodigo() == codProduto){
                                System.out.println("Digite o tamanho do estoque: \n");
                                y = Ler.umInt();
                                roupas.get(i).setEstoque(y);
                                System.out.println("Estoque editado.\n");
                            }

                            if(calcado.size() > i)
                            if(calcado.get(i).getCodigo() == codProduto){
                                System.out.println("Digite o tamanho do estoque: \n");
                                y = Ler.umInt();
                                calcado.get(i).setEstoque(y);
                                System.out.println("Estoque editado.\n");
                            }

                            if(acessorio.size() > i)
                            if(acessorio.get(i).getCodigo() == codProduto){
                                System.out.println("Digite o tamanho do estoque: \n");
                                y = Ler.umInt();
                                acessorio.get(i).setEstoque(y);
                                System.out.println("Estoque editado.\n");
                            }
                            break;

                        default:
                            System.out.println("A opção é inválida. Tente novamente. \n");
                            break;
                    }
                    cont = false;
                    break;

                case 12:
                    System.out.println("Saindo... \n");
                    cont = false;
                    break;

                default:
                    System.out.println("A opção é inválida. Tente Novamente. \n");
                    break;
            }
        }
        //*Atualização dos Ficheiros*//
        try {
            try (ObjectOutputStream osA = new ObjectOutputStream(new FileOutputStream ("Acessorios.dat"))) {
                osA.writeObject(acessorio);
                osA.flush();
            }

            try (ObjectOutputStream osR = new ObjectOutputStream(new FileOutputStream ("Roupas.dat"))) {
                osR.writeObject(roupas);
                osR.flush();
            }

            try (ObjectOutputStream osC = new ObjectOutputStream(new FileOutputStream ("Calcados.dat"))) {
                osC.writeObject(calcado);
                osC.flush();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean verificarProduto(ArrayList<Roupa> roupas, ArrayList<Calcado> calcado, ArrayList<Acessorio> acessorio, int codPesquisa){
        for(int i = 0; i < roupas.size(); i++){
            if(roupas.get(i).getCodigo() == codPesquisa){
                return true;
            }
        }
        for(int i = 0; i < calcado.size(); i++){
            if(calcado.get(i).getCodigo() == codPesquisa){
                return true;
            }
        }
        for(int i = 0; i < acessorio.size(); i++){
            if(acessorio.get(i).getCodigo() == codPesquisa){
                return true;
            }
        }
        return false;
    }

    public static int verificarIndice(ArrayList<Roupa> roupas, ArrayList<Calcado> calcado, ArrayList<Acessorio> acessorio, int codPesquisa){
        for(int i = 0; i < roupas.size(); i++){
            if(roupas.get(i).getCodigo() == codPesquisa){
                return i;
            }
        }
        for(int i = 0; i < calcado.size(); i++){
            if(calcado.get(i).getCodigo() == codPesquisa){
                return i;
            }
        }
        for(int i = 0; i < acessorio.size(); i++){
            if(acessorio.get(i).getCodigo() == codPesquisa){
                return i;
            }
        }
        return 0;
    }
}
