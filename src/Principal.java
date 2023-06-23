import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Venda> vendas = new ArrayList<>();
        Date data = new Date();
        double totalVendas = 0;
        java.lang.Object System;
        Scanner input = new Scanner(System.in);
        int opcao = 1;

        while (opcao == 1) {
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|Para continuar digite 1. Para terminar a venda digite 2: |");
            System.out.println("|---------------------------------------------------------|");
            opcao = input.nextInt();
            if (opcao >= 2) {
                break;
            }
            System.out.println("|---------------------------|");
            System.out.println("|Digite o nome do vendedor: |");
            System.out.println("|---------------------------|");
            String vendedorNome = input.next();
            System.out.println("|-------------------------|");
            System.out.println("|Digite o id do vendedor: |");
            System.out.println("|-------------------------|");
            int vendedorId = input.nextInt();
            System.out.println("|---------------------------|");
            System.out.println("|Digite o preço do produto: |");
            System.out.println("|---------------------------|");
            double preco = input.nextDouble();
            System.out.println("|------------------------|");
            System.out.println("|Digite o id do produto: |");
            System.out.println("|------------------------|");
            int produtoId = input.nextInt();
            System.out.println("|--------------------------------|");
            System.out.println("|Digite a quantidade do produto: |");
            System.out.println("|--------------------------------|");
            int quantidade = input.nextInt();

            Produto produto = new Produto(produtoId, "Nome do Produto", preco, 100);

            double valorTotal = produto.calcularValorTotal(quantidade);

            Venda venda = Venda.criarVenda();
            venda.processarVenda(vendas, data, valorTotal, vendedorId, vendedorNome);
            vendas.add(venda);
            venda.imprimir();

            // Atualizar o total das vendas a cada nova venda registrada
            totalVendas += valorTotal;
        }

        double media = totalVendas / vendas.size();
        System.out.println("|-----------------|");
        System.out.println("|Total de vendas: |" + totalVendas);
        System.out.println("|Média de vendas: |" + media);
        System.out.println("|-----------------|");

        // Interface polimórfica
        VendaServico servico = new VendaServicoImpl();
        servico.executar();
    }
}
