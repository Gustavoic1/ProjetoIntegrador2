/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Telas.Fr_Login;
import Telas.Fr_Principal;
import dao.UsuarioDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Usuario;



/**
 *
 * @author rohas
 */
public class LoginController {
    
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    
    private final Fr_Login view;
    

    public LoginController(Fr_Login view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //buscar um usuario da View
        String usuario = view.getjTextField1().getText();
        String senha = view.getjPasswordField1().getText();
        
        Usuario usuarioAtq = new Usuario(usuario, senha);
        //verificar se existe no banco de dados
        
       try {
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi","root","");
          st =(Statement)con.createStatement();
            //JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        }
        catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"não Conectado");
        }
       
       UsuarioDao usuarioDao = new UsuarioDao(con);
       
       boolean existe = usuarioDao.existePorUsuarioESenha(usuarioAtq);
       
        //se existe direciona para menu
        
        if (existe) {
            Fr_Principal telaDeMenu = new Fr_Principal();
            telaDeMenu.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos");
        }
    }
    
}
