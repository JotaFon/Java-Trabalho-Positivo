class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    public Produto(int id, String nome, double preco, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double calcularValorTotal(int quantidade) {
        try {
            if (preco < 0) {
                throw new IllegalArgumentException("O valor do produto não pode ser menor que zero.");
            }

            return preco * quantidade;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao calcular o valor total: " + e.getMessage());
            return 0.0;
        }
    }
}
