/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Funcionarios;
import model.Usuario;

/**
 *
 * @author rohas
 */
public class UsuarioDao {
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    //private final Connection con;

    public UsuarioDao(Connection con) {
        this.con = con;
    }
    
 public void insert(Funcionarios funcionario)throws SQLException{
   
      try {
                     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
                     st = (Statement) con.createStatement();
                     //JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
         
          String sql = "insert into login (usuario, senha) values ('"+funcionario.getLogin()+"', '"+funcionario.getSenha()+"'); ";       
        //String sql = "insert into funcionarios (nome, email, telefone) values ('"+ funcionarios.getNome() +"', '"+ funcionarios.getEmail()+"', '"+ funcionarios.getTelefone() +"');";
                 
        try {
            st = con.prepareStatement(sql);
             st.execute(sql);
             con.close(); 
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public boolean existePorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql ="select * from login where usuario = '"+usuario.getUsuario()+"' and senha = '"+usuario.getSenha()+"';";
         st = con.prepareStatement(sql);
         st.execute(sql);
         
        ResultSet resultSet = st.getResultSet();
        
        return resultSet.next();
    }

 
}
