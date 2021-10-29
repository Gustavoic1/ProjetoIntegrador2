/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
 public void insert(Usuario usuario)throws SQLException{
   
     String sql = "insert into usuario (users, pass) values ('"+usuario.getUsuario()+"', '"+usuario.getSenha()+"'); ";
     st = con.prepareStatement(sql);

    }

    public boolean existePorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql ="select * from usuario where users = '"+usuario.getUsuario()+"' and pass = '"+usuario.getSenha()+"';";
         st = con.prepareStatement(sql);
         st.execute(sql);
         
        ResultSet resultSet = st.getResultSet();
        
        return resultSet.next();
    }

 
}
