package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**Classe de conexão com o banco de dados
 *
 * @author dev-pedro <dev.pedro.rjas@gmail.com>
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    /**Cria uma conexão com o banco de dados
     * @return  */
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
                    
        } catch (ClassNotFoundException | SQLException error) {
            throw new RuntimeException("Erro de conexão com banco de dados!", error);
        }
    }
    /**Fecha a conexão com o banco de dados
     * @param connection */
    public static void closeConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
                
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao fechar conecção com banco de dados!", error);
        }
        
    }
    
    
}
