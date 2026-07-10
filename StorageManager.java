import java.util.*;
import java.io.*;
import java.nio.file.*;

class StorageManager {
    String filename = "tasks.json";

    public ArrayList<Task> load(){
        try {
            if(!Files.exists(Paths.get(filename))){
                return new ArrayList<>(); 
            }

            String content = new String(Files.readAllBytes(Paths.get(filename)));
            content = content.trim();

            if(content.isEmpty() || content.equals("[]")){
                return new ArrayList<>();
            }
            
            content = content.substring(1, content.length()-1).trim();

            if(content.isEmpty()){
                return new ArrayList<>();
            }

            String[] taskStrings = content.split("},\\{");
            ArrayList<Task> tasks = new ArrayList<>();

            for(int i=0; i<taskStrings.length; i++){
                String ts = taskStrings[i];
                Task t = new Task();

                t.id = getIntValue(ts, "id");
                t.description = getValue(ts, "description");
                t.status = Status.valueOf(getValue(ts, "status"));
                t.createdAt = getValue(ts, "createdAt");
                t.updatedAt = getValue(ts, "updatedAt");

                tasks.add(t);
            }

            return tasks;

        } catch (IOException e) {
            System.out.println("Error loading tasks!");
            return new ArrayList<>();
        }
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

    String getValue(String taskStr, String key){
        int start = taskStr.indexOf("\"" + key + "\":\"") + key.length() + 4;
        int end = taskStr.indexOf("\"",start);

        return taskStr.substring(start, end);
    }

    int getIntValue(String taskStr, String key){
        int start = taskStr.indexOf("\"" + key + "\":") + key.length() + 3;
        int end = taskStr.indexOf(",",start);

        if(end == -1) end = taskStr.indexOf("}",start);

        return Integer.parseInt(taskStr.substring(start, end).trim());
    }

}