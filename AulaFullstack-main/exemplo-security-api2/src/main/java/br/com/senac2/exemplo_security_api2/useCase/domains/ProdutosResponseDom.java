package br.com.senac2.exemplo_security_api2.useCase.domains;

public class ProdutosResponseDom {
    private Long id;
    private String name;
    private String descricao;
    private Double preco;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id; }

    public String getName() {return name;}

    public void setName(String name) {this.name = name; }

    public String getDescricao() {return  descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public Double getPreco() { return preco;}

    public void setPreco(Double preco) {this.preco = preco;}
}
