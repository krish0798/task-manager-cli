import java.util.*;
import java.time.LocalDateTime;

public class TaskManager {
    ArrayList<Task> tasks;
    StorageManager storageManager;

    public void addTask(String description) {
        
        int maxId = 0;
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).id>maxId) maxId = tasks.get(i).id;
        }

        int newId = maxId+1;

        Task newTask = new Task();
        
        newTask.id=newId;
        newTask.description=description;
        newTask.status="todo";
        newTask.createdAt=LocalDateTime.now().toString();
        newTask.updatedAt=LocalDateTime.now().toString();
        
        tasks.add(newTask);
        storageManager.save(tasks);
    }

    public void listTasks(){

        if(tasks.size()==0){
            System.out.println("No tasks found.");
            return;
        }

        for(int i=0; i<tasks.size(); i++){
          System.out.println("ID: "+tasks.get(i).id);  
          System.out.println("Description: "+tasks.get(i).description);
          System.out.println("Status: "+tasks.get(i).status);
          System.out.println("CreatedAt: "+tasks.get(i).createdAt);
          System.out.println("UpdatedAt: "+tasks.get(i).updatedAt);
          System.out.println();
        }
    }

    public void listTasks(String filter){

        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).status.equals(filter)){
                System.out.println("ID: "+tasks.get(i).id);  
                System.out.println("Description: "+tasks.get(i).description);
                System.out.println("Status: "+tasks.get(i).status);
                System.out.println("CreatedAt: "+tasks.get(i).createdAt);
                System.out.println("UpdatedAt: "+tasks.get(i).updatedAt);
                System.out.println();
            }
        }
    }

    public void deleteTask(int id){

        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).id == id){
                tasks.remove(i);
                storageManager.save(tasks);
                return;
            } 
        }

        System.out.println("Task not found.");
    }

    public void updateTask(int id, String newDescription){

        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).id == id){
                tasks.get(i).description = newDescription;
                tasks.get(i).updatedAt = LocalDateTime.now().toString();
                storageManager.save(tasks);
                return;
            }
        }

        System.out.println("Task not found.");
    }

    public void markStatus(int id, String status){

        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).id==id){
                tasks.get(i).status = status;
                tasks.get(i).updatedAt = LocalDateTime.now().toString();
                storageManager.save(tasks);
                return;
            }
        }

        System.out.println("task not found.");
    }
}