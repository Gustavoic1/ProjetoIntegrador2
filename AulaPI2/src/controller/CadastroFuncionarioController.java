/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Telas.Fr_Cad_Funcionarios;
import dao.FuncionarioDao;
import dao.UsuarioDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Funcionarios;

/**
 *
 * @author rohas
 */
public class CadastroFuncionarioController {
    
    private Fr_Cad_Funcionarios view;

    public CadastroFuncionarioController(Fr_Cad_Funcionarios view) {
        this.view = view;
    }
    
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    
    public void salvaFuncionario(){
              
         String nomeFuncionario = view.getNomeFunc().getText();
         String emailFuncionario = view.getEmailFunc().getText();
         String telefoneFunc = view.getTeleFunc().getText();
         
         Funcionarios funcLoja = new Funcionarios(nomeFuncionario, emailFuncionario, telefoneFunc);
         //Clientes clienteLoja = new Clientes(nomeCliente, cpfCliente, emailCliente, telefoneCliente);
         
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
            st = (Statement) con.createStatement();
            
            FuncionarioDao funcionarioDao = new FuncionarioDao(con);  
            
            funcionarioDao.insert(funcLoja);
            
            JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
        
    
    }
    
    public void salvaUsuario(){
        
        
        String usuario = view.getLoginFunc().getText();
        String senha = view.getSenhaFunc().getText();
        
        Funcionarios funcUsuario = new Funcionarios(usuario, senha);
            
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
            st = (Statement) con.createStatement();
            
            UsuarioDao  usuarioDao = new UsuarioDao(con);
            //FuncionarioDao funcionarioDao = new FuncionarioDao(con);
            
            usuarioDao.insert(funcUsuario);
            
            //JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
   
        
    }
    
}
