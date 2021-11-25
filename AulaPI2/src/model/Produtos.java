/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Produtos {
    
    private int cod;
    private String produto;
    private String fornecedor;
    private int quantidade;
    private double precProd;
    private double precVenda;

    public Produtos(String produto, String fornecedor, int quantidade, double precProd, double precVenda) {
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.precProd = precProd;
        this.precVenda = precVenda;
    }



    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecProd() {
        return precProd;
    }

    public void setPrecProd(double precProd) {
        this.precProd = precProd;
    }

    public double getPrecVenda() {
        return precVenda;
    }

    public void setPrecVenda(double precVenda) {
        this.precVenda = precVenda;
    }
    
}
