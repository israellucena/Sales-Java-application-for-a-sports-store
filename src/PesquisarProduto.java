import com.sun.security.jgss.GSSUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PesquisarProduto extends Main{
    public static void pesquisarProduto(ArrayList<Roupa> roupas, ArrayList<Calcado> calcado, ArrayList<Acessorio> acessorio, ArrayList<Compra> compras){
        boolean b = true;
        while(b){
            //*Declarações*//
            //*Aqui as strings e inteiros são inicializados em branco ou em 0 para assegurar que não serão reutilizados, devido ao loop, com valores anteriores*//
            String p = "";
            int opcao = 0, opcao2, codPesquisa;
            ArrayList<Roupa> roupaPesquisa = new ArrayList<Roupa>();
            ArrayList<Calcado> calcadoPesquisa = new ArrayList<Calcado>();
            ArrayList<Acessorio> acessorioPesquisa = new ArrayList<Acessorio>();

            //*Modo de pesquisa*//
            System.out.println("Escolha o modo de pesquisa: \n" +
                    "1. Nome\n" + "2. Código\n" + "3. Sexo\n" + "4. Categoria\n" +
                    "5. Tamanho\n" + "6. Tipo\n" + "7. Desporto\n" + "8. Marca\n" +
                    "9. Promoção\n" + "10. Novidades\n" + "11. Listar Produtos\n" + "12.Sair\n");
            opcao = Ler.umInt();

            switch (opcao) {
                //Nome
                case 1:
                    System.out.println("Escreva o nome que deseja pesquisar:");
                    p = Ler.umaString();
                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++) {
                        if (p != null && roupas.get(i).getNome().toLowerCase().contains(p.toLowerCase())) {
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++) {
                        if (p != null && calcado.get(i).getNome().toLowerCase().contains(p.toLowerCase())) {
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        if (p != null && acessorio.get(i).getNome().toLowerCase().contains(p.toLowerCase())) {
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Código
                case 2:
                    System.out.println("Digite o código que deseja pesquisar:");
                    codPesquisa = Ler.umInt();

                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++) {
                        if(codPesquisa == roupas.get(i).getCodigo()) {
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++) {
                        if(codPesquisa == calcado.get(i).getCodigo()) {
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        if(codPesquisa == acessorio.get(i).getCodigo()) {
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Sexo
                case 3:
                    System.out.println("Escolha o sexo que deseja pesquisar: \n" +
                                       "1. Homem \n" +
                                       "2. Mulher \n" +
                                       "3. Unisex \n" +
                                       "4. Criança \n");
                    opcao2 = Ler.umInt();

                    switch(opcao2) {
                        //Homem
                        case 1:
                            for (int i = 0; i < roupas.size(); i++){
                                if (roupas.get(i).getSexo().toLowerCase().equals("homem")){
                                    roupaPesquisa.add(roupas.get(i));
                                }
                            }
                            for (int i = 0; i < calcado.size(); i++){
                                if (calcado.get(i).getSexo().toLowerCase().equals("homem")){
                                    calcadoPesquisa.add(calcado.get(i));
                                }
                            }
                            for (int i = 0; i < acessorio.size(); i++){
                                if (acessorio.get(i).getSexo().toLowerCase().equals("homem")){
                                    acessorioPesquisa.add(acessorio.get(i));
                                }
                            }
                            break;

                        //Mulher
                        case 2:
                            for (int i = 0; i < roupas.size(); i++) {
                                if (roupas.get(i).getSexo().toLowerCase().equals("mulher")) {
                                    roupaPesquisa.add(roupas.get(i));
                                }
                            }
                            for (int i = 0; i < calcado.size(); i++) {
                                if (calcado.get(i).getSexo().toLowerCase().equals("mulher")) {
                                    calcadoPesquisa.add(calcado.get(i));
                                }
                            }
                            for (int i = 0; i < acessorio.size(); i++) {
                                if (acessorio.get(i).getSexo().toLowerCase().equals("mulher")) {
                                    acessorioPesquisa.add(acessorio.get(i));
                                }
                            }
                            break;

                        //Unisex
                        case 3:
                            for(int i = 0; i < roupas.size(); i++){
                                if (roupas.get(i).getSexo().toLowerCase().equals("unisex")){
                                    roupaPesquisa.add(roupas.get(i));
                                }
                            }
                            for(int i = 0; i < calcado.size(); i++){
                                if (calcado.get(i).getSexo().toLowerCase().equals("unisex")){
                                    calcadoPesquisa.add(calcado.get(i));
                                }
                            }
                            for(int i = 0; i < acessorio.size(); i++){
                                if (acessorio.get(i).getSexo().toLowerCase().equals("unisex")){
                                    acessorioPesquisa.add(acessorio.get(i));
                                }
                            }
                            break;

                        //Criança
                        case 4:
                            for (int i = 0; i < roupas.size(); i++) {
                                if (roupas.get(i).getSexo().toLowerCase().equals("criança")) {
                                    roupaPesquisa.add(roupas.get(i));
                                }
                            }
                            for (int i = 0; i < calcado.size(); i++) {
                                if (calcado.get(i).getSexo().toLowerCase().equals("criança")) {
                                    calcadoPesquisa.add(calcado.get(i));
                                }
                            }
                            for (int i = 0; i < acessorio.size(); i++) {
                                if (acessorio.get(i).getSexo().toLowerCase().equals("criança")) {
                                    acessorioPesquisa.add(acessorio.get(i));
                                }
                            }
                            break;

                        default:
                            System.out.println("A opção é inválida. Tente novamente.");
                            break;
                    }
                    b = false;
                    break;

                //Categoria
                case 4:
                    System.out.println("Escolha o sexo que deseja pesquisar: \n" +
                            "1. Roupa \n" +
                            "2. Calçado \n" +
                            "3. Acessório \n");
                    opcao = Ler.umInt();

                    switch(opcao){
                        case 1:
                            for (int i = 0; i < roupas.size(); i++) {
                                System.out.println(roupas.get(i).toString());
                            }
                            break;

                        case 2:
                            for (int i = 0; i < calcado.size(); i++) {
                                System.out.println(calcado.get(i).toString());
                            }
                            break;
                        case 3:
                            for(int i = 0; i < acessorio.size(); i++){
                                System.out.println(acessorio.get(i).toString());
                            }
                            break;
                        default:
                            System.out.println("A opção é inválida. Tente Novamente.");
                    }
                    b = false;
                    break;

                //Tamanho
                case 5:
                    System.out.println("Escreva o tamanho que deseja pesquisar:");
                    p = Ler.umaString();

                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++) {
                        if (p != null && roupas.get(i).getTamanho().toLowerCase().contains(p.toLowerCase())) {
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++) {
                        if (p != null && calcado.get(i).getTamanho().toLowerCase().contains(p.toLowerCase())) {
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        if (p != null && acessorio.get(i).getTamanho().toLowerCase().contains(p.toLowerCase())) {
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Tipo
                case 6:
                    System.out.println("Escreva o tipo de produto que deseja pesquisar:");
                    p = Ler.umaString();

                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++) {
                        if (p != null && roupas.get(i).getTipo().toLowerCase().contains(p.toLowerCase())) {
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++) {
                        if (p != null && calcado.get(i).getTipo().toLowerCase().contains(p.toLowerCase())) {
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        if (p != null && acessorio.get(i).getTipo().toLowerCase().contains(p.toLowerCase())) {
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Desporto
                case 7:
                    System.out.println("Escreva o desporto que deseja pesquisar:");
                    p = Ler.umaString();

                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++) {
                        if (p != null && roupas.get(i).getDesporto().toLowerCase().contains(p.toLowerCase())) {
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++) {
                        if (p != null && calcado.get(i).getDesporto().toLowerCase().contains(p.toLowerCase())) {
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        if (p != null && acessorio.get(i).getDesporto().toLowerCase().contains(p.toLowerCase())) {
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Marca
                case 8:
                    System.out.println("Escreva a marca que deseja pesquisar?");
                    p = Ler.umaString();

                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++) {
                        if (p != null && roupas.get(i).getMarca().toLowerCase().contains(p.toLowerCase())) {
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++) {
                        if (p != null && calcado.get(i).getMarca().toLowerCase().contains(p.toLowerCase())) {
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        if (p != null && acessorio.get(i).getMarca().toLowerCase().contains(p.toLowerCase())) {
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Promoção
                case 9:
                    System.out.println("Esses são os produtos em promoção: ");

                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++){
                        if(roupas.get(i).getDesconto() > 0) {
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++){
                        if (calcado.get(i).getDesconto() > 0) {
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        if (acessorio.get(i).getDesconto() > 0) {
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Novidades
                case 10:
                    System.out.println("Novidades:");
                    LocalDate data = java.time.LocalDate.now();

                    long dif;

                    //*Pesquisando*//
                    for (int i = 0; i < roupas.size(); i++){
                        dif = ChronoUnit.DAYS.between(data, roupas.get(i).getData());
                        if(dif <= 60){
                            roupaPesquisa.add(roupas.get(i));
                        }
                    }
                    for (int i = 0; i < calcado.size(); i++){
                        dif = Duration.between(data,calcado.get(i).getData()).toDays();
                        if(dif <= 60){
                            calcadoPesquisa.add(calcado.get(i));
                        }
                    }
                    for (int i = 0; i < acessorio.size(); i++) {
                        dif = Duration.between(data,acessorio.get(i).getData()).toDays();
                        if(dif <= 60){
                            acessorioPesquisa.add(acessorio.get(i));
                        }
                    }
                    b = false;
                    break;

                //Listar Produtos
                case 11:
                    System.out.println("Lista de Roupas: \n");
                    for(int i=0; i < roupas.size(); i++){
                        System.out.println(roupas.get(i).toString());
                    }
                    System.out.println("Lista de Calçados: \n");
                    for(int i=0; i < calcado.size(); i++){
                        System.out.println(calcado.get(i).toString());
                    }
                    System.out.println("Lista de Acessórios: \n");
                    for(int i=0; i < acessorio.size();i++){
                        System.out.println(acessorio.get(i).toString());
                    }
                    b = false;
                    break;

                //Sair
                case 12:
                    System.out.println("Saindo... \n");
                    b = false;
                    break;

                default:
                    System.out.println("A opção é inválida. Tente Novamente. \n");
                    break;
            }

            //*Prints*//
            if(opcao == 1 || opcao == 2 || opcao == 3 || opcao == 5 || opcao == 6 || opcao == 7 || opcao == 8 || opcao == 9 || opcao == 10){
                System.out.println("Deseja aplicar algum filtro?\n" +
                        "1. Sim\n" +
                        "2. Não\n");
                opcao = Ler.umInt();

                switch(opcao){
                    case 1:
                        int opcaoFiltro = 0;
                        System.out.println("Escolha o filtro que deseja aplicar:\n" +
                                "1. Mais Barato - Mais Caro\n" +
                                "2. Maiores Descontos\n" +
                                "3. Ordem Alfabética\n");
                        opcaoFiltro = Ler.umInt();

                        switch(opcaoFiltro){
                            case 1:
                                Collections.sort(roupaPesquisa, Comparator.comparing(Roupa::getPrecoFinal));
                                System.out.println("Roupas: \n");
                                for(int i = 0; i < roupaPesquisa.size(); i++){
                                    System.out.println(roupaPesquisa.get(i).toString());
                                }

                                Collections.sort(calcadoPesquisa, Comparator.comparing(Calcado::getPrecoFinal));
                                System.out.println("Calçados: \n");
                                for(int i = 0; i < calcadoPesquisa.size(); i++){
                                    System.out.println(calcadoPesquisa.get(i).toString());
                                }

                                Collections.sort(acessorioPesquisa, Comparator.comparing(Acessorio::getPrecoFinal));
                                System.out.println("Acessórios: \n");
                                for(int i = 0; i < acessorioPesquisa.size(); i++){
                                    System.out.println(acessorioPesquisa.get(i).toString());
                                }
                                break;

                            case 2:
                                System.out.println("Roupas com maiores descontos: \n");
                                for (int i = 0; i < roupaPesquisa.size(); ++i){
                                    System.out.println(Collections.max(roupaPesquisa, Comparator.comparing(Roupa::getDesconto)));
                                }
                                System.out.println("Calçados com maiores descontos: \n");
                                for (int i = 0; i < calcadoPesquisa.size(); ++i){
                                    System.out.println(Collections.max(calcadoPesquisa, Comparator.comparing(Calcado::getDesconto)));
                                }
                                System.out.println("Acessórios com maiores descontos: \n");
                                for (int i = 0; i < acessorioPesquisa.size(); ++i){
                                    System.out.println(Collections.max(acessorioPesquisa, Comparator.comparing(Acessorio::getDesconto)));
                                }
                                break;

                            case 3:
                                System.out.println("Roupas em ordem alfabética: \n");
                                Collections.sort(roupaPesquisa, Comparator.comparing(Roupa::getNome));
                                for (int i = 0; i < roupaPesquisa.size(); ++i){
                                    System.out.println(roupaPesquisa.get(i).toString());
                                }
                                System.out.println("Calçados em ordem alfabética: \n");
                                Collections.sort(calcadoPesquisa, Comparator.comparing(Calcado::getNome));
                                for (int i = 0; i < calcadoPesquisa.size(); ++i){
                                    System.out.println(calcadoPesquisa.get(i).toString());
                                }
                                System.out.println("Acessórios em ordem alfabética: \n");
                                Collections.sort(acessorioPesquisa, Comparator.comparing(Acessorio::getNome));
                                for (int i = 0; i < acessorioPesquisa.size(); ++i){
                                    System.out.println(acessorioPesquisa.get(i).toString());
                                }
                                break;

                            default:
                                System.out.println("A opção é inválida. Tente Novamente.");
                                break;
                        }
                        break;

                    case 2:
                        for (int i = 0; i < roupaPesquisa.size(); i++) {
                        System.out.println(roupaPesquisa.get(i).toString());
                        }
                        for (int i = 0; i < calcadoPesquisa.size(); i++) {
                            System.out.println(calcadoPesquisa.get(i).toString());
                        }
                        for (int i = 0; i < acessorioPesquisa.size(); i++) {
                            System.out.println(acessorioPesquisa.get(i).toString());
                        }
                        break;

                    default:
                        System.out.print("A opção é inválida. Tente Novamente. \n");
                        return;
                }
            }
        }
    }
}
