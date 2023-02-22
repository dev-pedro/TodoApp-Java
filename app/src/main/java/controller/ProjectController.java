package controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**Essa classe ProjectController controla a conexão com o banco de dados
 * para criação das projetos
 *
 * @author dev-pedro <dev.pedro.rjas@gmail.com>
 */
public class ProjectController {
    
    public void save(Project project){
        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "createdAt, "
                + "updatedAt) VALUE (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            statement.execute();
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao salvar o projeto no banco de dados ", error);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Project project){
        
    }
    
    public void removeById(int projectId){
        
    }
    
    public List<Project> getAllProject(){
        return null;
    }
    
}
