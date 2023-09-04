
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Estatisticas extends Main{
    public static void Estatisticas(ArrayList<Roupa> roupas, ArrayList<Calcado> calcados, ArrayList<Acessorio> acessorios, ArrayList<Compra> compras) {
        boolean b = true;

        while(b){
            int opcao = 0;
            System.out.println("Escolha qual estatística deseja verificar: \n" +
                    "1. Estoque total\n" +
                    "2. Produtos com maior estoque\n" +
                    "3. Produtos sem estoque\n" +
                    "4. Produtos mais caros\n" +
                    "5. Produtos com mais desconto\n" +
                    "6. Valor total das vendas\n" +
                    "7. Sair");
            opcao = Ler.umInt();

            switch (opcao) {
                case 1:
                    int total = 0;

                    if(roupas.size()>0)
                        total += roupas.stream().mapToInt(Roupa::getEstoque).sum();
                    if(calcados.size()>0)
                        total += calcados.stream().mapToInt(Calcado::getEstoque).sum();
                    if(acessorios.size()>0)
                        total += acessorios.stream().mapToInt(Acessorio::getEstoque).sum();

                    System.out.println("Estoque total: \n" + total + "\n");
                    break;

                case 2:
                    if(roupas.size()>0)
                        System.out.println("Roupa com maior estoque:\n" + Collections.max(roupas, Comparator.comparingInt(Roupa::getEstoque)));
                    if(calcados.size()>0)
                        System.out.println("Calçado com maior estoque:\n" + Collections.max(calcados, Comparator.comparing(Calcado::getEstoque)));
                    if(acessorios.size()>0)
                        System.out.println("Acessorio com maior estoque:\n"+ Collections.max(acessorios, Comparator.comparingInt(Acessorio::getEstoque)));
                    break;

                case 3:
                    if(roupas.size()>0)
                        Collections.sort(roupas, Comparator.comparingInt(Roupa::getEstoque));
                        System.out.println("Roupas sem estoque:\n");
                    for (int i = 0; i < roupas.size(); ++i){
                        if(roupas.get(i).getEstoque() == 0)
                            System.out.println(roupas.get(i).toString());
                    }
                    if(calcados.size()>0)
                        Collections.sort(calcados, Comparator.comparingInt(Calcado::getEstoque));
                        System.out.println("Calçados sem estoque:\n");
                    for (int i = 0; i < calcados.size(); ++i){
                        if(calcados.get(i).getEstoque() == 0)
                            System.out.println(calcados.get(i).toString());
                    }
                    if(acessorios.size()>0)
                        Collections.sort(acessorios, Comparator.comparingInt(Acessorio::getEstoque));
                        System.out.println("Acessorios sem estoque:\n");
                    for (int i = 0; i < acessorios.size(); ++i){
                        if(acessorios.get(i).getEstoque() == 0)
                            System.out.println(acessorios.get(i).toString());
                    }
                    break;

                case 4:
                    if(roupas.size()>0)
                        System.out.println("Roupa mais cara: \n" + Collections.max(roupas, Comparator.comparing(Roupa::getPreco)));
                    if(calcados.size()>0)
                        System.out.println("Calçado mais cara: \n" + Collections.max(calcados, Comparator.comparing(Calcado::getPreco)));
                    if(acessorios.size()>0)
                        System.out.println("Acessório mais caro: \n" + Collections.max(acessorios, Comparator.comparing(Acessorio::getPreco)));
                    break;

                case 5:
                    if(roupas.size()>0)
                        System.out.println("Roupa com mais desconto: \n" + Collections.max(roupas, Comparator.comparing(Roupa::getDesconto)));
                    if(calcados.size()>0)
                        System.out.println("Calçado com mais desconto: \n" + Collections.max(calcados, Comparator.comparing(Calcado::getDesconto)));
                    if(acessorios.size()>0)
                        System.out.println("Acessório com mais desconto: \n" + Collections.max(acessorios, Comparator.comparing(Acessorio::getDesconto)));
                    break;

                case 6:
                    double X = compras.stream().mapToDouble(Compra::getPrecoFinal).sum();
                    System.out.println("Valor total das vendas: \n" + X + "\n");
                    break;

                case 7:
                    System.out.println("Saindo... \n");
                    b = false;
                    break;

                default:
                    System.out.println("A opção é inválida. Tente Novamente. \n");
                    break;
            }

        }
    }
}
