/** TodoApp - Aplicativo de lista de tarefas e projetos
 * @author dev-pedro <dev.pedro.rjas@gmail.com>
 */
package main;

import controller.ProjectController;
import controller.TaskController;
import java.util.Date;
import model.Project;
import model.Task;


public class Main {

    public static void main(String[] args) {
        
        ProjectController projectController = new ProjectController();
        TaskController taskController = new TaskController();
        
        Project project1 = new Project();
        //project1.setName("Projeto 1");
        //project1.setDescription("Descrição do projeto 1");
        //projectController.save(project1);
        project1.setId(13);
        
        
        Task task = new Task();
        task.setId(15);
        task.setName("Tarefa 25");
        task.setDescription("Descrição da tarefa 25");
        task.setCompleted(true);
        task.setIdProject(13);
        
        taskController.update(task);
        
        //taskController.removeById(16);
        
       
    }
    
    
    
}
