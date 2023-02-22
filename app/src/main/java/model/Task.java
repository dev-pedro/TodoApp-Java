package model;
import java.util.Date;


/**
 * 
 * @author dev-pedro <dev.pedro.rjas@gmail.com>
 */
public class Task {
    
    private int id;
    private int idProject;
    private String name;
    private String description;
    private Boolean isCompleted;
    private String notes;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idProject, String name, String description, Boolean completed, String notes, Date deadline, Date createAt, Date updateAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.isCompleted = completed;
        this.notes = notes;
        this.deadline = deadline;
        this.createdAt = createAt;
        this.updatedAt = updateAt;
    }

    public Task() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.deadline = new Date();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        this.isCompleted = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createAt) {
        this.createdAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", completed=" + isCompleted + ", notes=" + notes + ", deadline=" + deadline + ", createAt=" + createdAt + ", updateAt=" + updatedAt + '}';
    }
    
}
