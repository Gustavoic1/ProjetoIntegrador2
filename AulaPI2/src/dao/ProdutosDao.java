package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Produtos;


public class ProdutosDao {
    public Connection con;
    public Statement st;
    public ResultSet resultado = null;
    

    public ProdutosDao(Connection con) {
        this.con = con;
    }
    
    public void insert(Produtos produtos)throws SQLException{
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
            st = (Statement) con.createStatement();
                 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não Conectado");
        }
         
                 
        String sql = "insert into produtos (produto, fornecedor, quantidade, preco_prod, preco_venda) values ('"+ produtos.getProduto() +"', '"+ produtos.getFornecedor() +"', "+ produtos.getQuantidade() +", "+ produtos.getPrecProd()+", "+ produtos.getPrecVenda() +");";
                 
        try {
            st = con.prepareStatement(sql);
            st.execute(sql);
            con.close(); 
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
