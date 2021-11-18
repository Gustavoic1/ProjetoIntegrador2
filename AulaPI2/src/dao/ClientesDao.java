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
import model.Clientes;


public class ClientesDao {
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    
    /**
     *
     * @param con
     */
    public ClientesDao(Connection con) {
        this.con = con;
    }
    
    public void insert(Clientes clientes)throws SQLException{
        try {
                     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
                     st = (Statement) con.createStatement();
                     //JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
         
                 
        String sql = "insert into clientes (nome, cpf, email, telefone) values ('"+ clientes.getNome() +"', '"+ clientes.getCpf() +"', '"+ clientes.getEmail()+"', '"+ clientes.getTelefone() +"');";
                 
        try {
            st = con.prepareStatement(sql);
             st.execute(sql);
             con.close(); 
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
