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
}