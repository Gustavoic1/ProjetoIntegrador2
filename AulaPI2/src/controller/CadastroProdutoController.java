/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Telas.Fr_Cad_Produto;
import dao.ProdutosDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Produtos;

public class CadastroProdutoController {
    
    private Fr_Cad_Produto view;
    
        public CadastroProdutoController(Fr_Cad_Produto view) {
        this.view = view;
    }
        
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    
    
        public void salvaProdutos(){
           
            String produto = view.getProd().getText();
            String fornecedor = view.getFornecedorProd().getSelectedItem().toString();
            double precCompra = Double.parseDouble(view.getPrecCompra().getText().toString());
            double precVenda = Double.parseDouble(view.getPrecVenda().getText().toString());
            int quantidade = Integer.valueOf(view.getQtdProd().getText().toString());
            
         //String nomeFuncionario = view.getNomeFunc().getText();
         //String emailFuncionario = view.getEmailFunc().getText();
         //String telefoneFunc = view.getTeleFunc().getText();
         
         Produtos produtos = new Produtos(produto, fornecedor, quantidade, precCompra, precVenda);
         //Clientes clienteLoja = new Clientes(nomeCliente, cpfCliente, emailCliente, telefoneCliente);
         
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
            st = (Statement) con.createStatement();
            
            ProdutosDao produtosDao = new ProdutosDao(con);  
            
            produtosDao.insert(produtos);
            
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
        
    
    }
    
    
    
    
}
