package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Funcionarios;


public class FuncionarioDao {
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    
    /**
     *
     * @param con
     */
    public FuncionarioDao(Connection con) {
        this.con = con;
    }
    
    public void insert(Funcionarios funcionarios)throws SQLException{
        try {
                     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
                     st = (Statement) con.createStatement();
                     //JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
         
                 
        String sql = "insert into funcionarios (nome, email, telefone) values ('"+ funcionarios.getNome() +"', '"+ funcionarios.getEmail()+"', '"+ funcionarios.getTelefone() +"');";
                 
        try {
            st = con.prepareStatement(sql);
             st.execute(sql);
             con.close(); 
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
