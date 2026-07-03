import java.util.*;
import java.time.LocalDateTime;

public class TaskManager {
    ArrayList<Task> tasks;

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
    }

    public void listTask(){

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
}