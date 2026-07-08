import java.util.*;
import java.io.*;
import java.nio.file.*;

class StorageManager {
    String filename = "tasks.json";

    public ArrayList<Task> load(){
        
    }

    public void save(ArrayList<Task> tasks){

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("[\n");

            for(int i=0; i<tasks.size(); i++){
                Task t = tasks.get(i);
                String taskJson = " {\"id\":" + t.id + ",\"description\":\"" + t.description + "\"" + ",\"status\":\"" + t.status + "\"" + ",\"createdAt\":\"" + t.createdAt + "\"" + ",\"updatedAt\":\"" + t.updatedAt + "\"}";

                writer.write(taskJson);

                if(i < tasks.size()-1){
                    writer.write(",\n");
                }
        }
            writer.write("\n]");
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving tasks!");
        }
        
    }

}