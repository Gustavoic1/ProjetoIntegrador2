/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Telas.Fr_Cad_Clientes;
import dao.ClientesDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Clientes;

/**
 *
 * @author rohas
 */
public class CadastroClienteController {
    
    private Fr_Cad_Clientes view;

    public CadastroClienteController(Fr_Cad_Clientes view) {
        this.view = view;
    }
    
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    
    public void salvaCliente(){
              
         String nomeCliente = view.getNomecliente().getText();
         String cpfCliente = view.getCpfcliente().getText();
         String emailCliente = view.getEmailcliente().getText();
         String telefoneCliente = view.getTelefonecliente().getText();
         
         Clientes clienteLoja = new Clientes(nomeCliente, cpfCliente, emailCliente, telefoneCliente);
         
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
            st = (Statement) con.createStatement();
            
            ClientesDao clienteDao = new ClientesDao(con);  
            
            clienteDao.insert(clienteLoja);
            
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
        
    
    }
    
}
