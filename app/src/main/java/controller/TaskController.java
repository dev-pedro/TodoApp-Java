package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author dev-pedro <dev.pedro.rjas@gmail.com>
 */
public class TaskController {
    
    public void save(Task task){
        
    }
    
    public void update(Task task){
        
    }
    
    public void removeById(int taskId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (SQLException error) {
            throw  new SQLException("Erro ao deletar a tarefa", error);
        }finally{
            ConnectionFactory.closeConnection(connection);
        }
        
    }
    
    public List<Task> getAllTask(int idProject){
        return null;
    }
}
