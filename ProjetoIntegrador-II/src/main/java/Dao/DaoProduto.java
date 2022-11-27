
package Dao;
import static Dao.Dao.login;
import static Dao.Dao.senha;
import static Dao.Dao.url;
import Model.Cliente;
import Model.Produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.spi.LoginModule;
import javax.swing.JOptionPane;





public class DaoProduto {
    public static String url= "jdbc:mysql://localhost:3306/lojamusica";
   public static String login= "root";
   public static String senha = "root";
   
   
   public static boolean SalvarP(Produtos p){
       boolean retorno = false;
       Connection conexao =null;
       
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO Produto (Descri,Quantidade,Valor) VALUES(?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            comandoSQL.setInt(1, p.getId());
            comandoSQL.setString(1,p.getDescricao());
            comandoSQL.setInt(2, p.getQuantidade());
            comandoSQL.setString(3, p.getValor());
            
            int numeroLinha = comandoSQL.executeUpdate();
            if(numeroLinha>0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs!=null){
                    if(rs.next()){
                        p.setId(rs.getInt(1));
                    }
                }
            }
       }catch(ClassNotFoundException ex){
            retorno=false;
            System.out.println(ex);
        }catch(SQLException ex){
            retorno = false;
            System.out.println(ex);
        }
        return retorno;
 
  
   }
    
   public static List<Produtos>Listar(){
        List<Produtos>listarRetornon = new ArrayList();
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto");
            ResultSet rs  = comandoSQL.executeQuery();
            if(rs!=null){
                while(rs.next()){
                   Produtos produto = new Produtos();
                   produto.setId(rs.getInt("IdCodigo"));
                   produto.setDescricao(rs.getString("Descri"));
                   produto.setQuantidade(rs.getInt("Quantidade"));
                   produto.setValor(rs.getString("Valor"));
                    
                    listarRetornon.add(produto);
                }
                
                return listarRetornon;

            }
            return null;

        } catch(ClassNotFoundException | SQLException ex){
            listarRetornon = null;
            System.out.println(ex.getMessage());
            return null;
            
        }
    }

   public static boolean Excluir(int id ){
       boolean retorno = false;
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             
            conexao = DriverManager.getConnection(url,login,senha);
            
            PreparedStatement comandoSQL =conexao.prepareStatement("DELETE FROM produto WHERE IdCodigo=?");
            comandoSQL.setInt(1, id);
            
            int numeroLinha = comandoSQL.executeUpdate();
            if(numeroLinha>0){
                retorno=true;
            }
            
                    
        }catch (ClassNotFoundException ex){
            retorno = false;
        }catch(SQLException ex){
            retorno=false;
        }
        return retorno;
    }
    
   
    
        public static boolean Altera(Produtos p){
            boolean retorno = false;
        Connection conexao = null;
        
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produto Set Descri=?,Quantidade=?,Valor=? WHERE IdCodigo=?"
                     , Statement.RETURN_GENERATED_KEYS);
            
            comandoSQL.setString(1, p.getDescricao());
            comandoSQL.setInt(2, p.getQuantidade());
            comandoSQL.setString(3, p.getValor());
            comandoSQL.setInt(4, p.getId());
             int numeroLinha = comandoSQL.executeUpdate();
              if(numeroLinha>0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs!=null){
                if(rs.next()){
                    p.setId(rs.getInt(1));
                }
            }
            }
            
        }catch(ClassNotFoundException ex){
            retorno=false;
            System.out.println(ex);
        }catch(SQLException ex){
            retorno = false;
            System.out.println(ex);
        }
        return retorno;
               
    }
    

    
}
