package br.com.senac2.exemplo_security_api2.useCase.domains;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProdutoRequestDom {
    private String name;
    private String descricao;
    private Double preco;

    public String getName() {return  name; }

    public void setName(String name) { this.name = name;}

    public  String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public Double getPreco() {return preco; }

    public void setPreco(Double preco) { this.preco = preco;}


}

