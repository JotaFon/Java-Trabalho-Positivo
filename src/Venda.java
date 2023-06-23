//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Date;
import java.util.Iterator;
import java.util.List;

abstract class Venda {
    private int id;
    private Date data;
    private double valor;
    private int vendedorId;
    private String vendedorNome;

    Venda() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getVendedorId() {
        return this.vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getVendedorNome() {
        return this.vendedorNome;
    }

    public void setVendedorNome(String vendedorNome) {
        this.vendedorNome = vendedorNome;
    }

    public abstract void imprimir();

    public void processarVenda(List<Venda> vendas, Date data, double valor, int vendedorId, String vendedorNome) {
        try {
            if (valor <= 0.0) {
                throw new IllegalArgumentException("O valor da venda deve ser maior que zero.");
            }

            Iterator var7 = vendas.iterator();

            while(var7.hasNext()) {
                Venda venda = (Venda)var7.next();
                if (venda.getVendedorId() == this.vendedorId) {
                    venda.setData(data);
                    venda.setValor(valor);
                    venda.setVendedorNome(vendedorNome);
                    return;
                }
            }


            Venda novaVenda = criarVenda();
            novaVenda.setId(vendas.size() + 1);
            novaVenda.setData(data);
            novaVenda.setValor(valor);
            novaVenda.setVendedorId(this.vendedorId);
            novaVenda.setVendedorNome(vendedorNome);
            vendas.add(novaVenda);
        } catch (IllegalArgumentException var9) {
            System.out.println("Erro ao processar a venda: " + var9.getMessage());
        }

    }

    public static Venda criarVenda() {
        return new VendaProduto();
    }

    public void adicionarProduto(Produto produto) {
    }
}
