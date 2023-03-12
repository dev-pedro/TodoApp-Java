package controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Projects;
import util.ConnectionFactory;

/**Essa classe ProjectController controla a conexão com o banco de dados
 * para criação das projetos
 *
 * @author dev-pedro <dev.pedro.rjas@gmail.com>
 */
public class ProjectController {
    
    public void save(Projects project){
        String sql = "INSERT INTO projects ("
                + "name, "
                + "description, "
                + "createdAt, "
                + "updatedAt) "
                + "VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            //executa a eql para inserçaõ dos dados
            statement.execute();
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao salvar o projeto no banco de dados ", error);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Projects project){
        
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores no statement
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            //Executa a sql para inserção dos dados
            statement.execute();
            
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao atualizar o projeto ", error);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void removeById(int idProject){
        String sql = "DELETE FROM projects WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando o valor no statement para remover a tarefa
            statement.setInt(1, idProject);
            //Executando a query
            statement.execute();
            
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao deletar o projeto ", error);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public List<Projects> getAllProject(){
        
        String sql = "SELECT * FROM projects";
        
        //Lista de projetos que será devolvida quando a chamada do método acontecer
        List<Projects> projects = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        //classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //valor retornado pela execução da query
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Projects project = new Projects();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdateAt(resultSet.getDate("updatedAt"));
                projects.add(project);
            }
            
        } catch (SQLException error) {
            throw  new RuntimeException("Erro ao buscar o projeto " + error.getMessage(), error);
        }finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return projects;
    }
    
}
