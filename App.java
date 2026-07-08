public class App{
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        if(args.length == 0) {
            System.out.println("Usage: java App <command>");
            System.out.println("Available commands: add, list, update, delete, mark-in-progress, mark-done");
            return;
        }

        switch (args[0]) {
            case "add":
                taskManager.addTask(args[1]);
                break;
            case "list":
                if(args.length==1){
                    taskManager.listTasks();
                }else{
                taskManager.listTasks(args[1]);
                }
                break;
            case "update":
                taskManager.updateTask(Integer.parseInt(args[1]),args[2]);
                break;
            case "mark-in-progress":
                taskManager.markStatus("in-progress", Integer.parseInt(args[1]));
                break;
            case "mark-done":
                taskManager.markStatus("done", Integer.parseInt(args[1]));
                break;
            case "delete":
                taskManager.deleteTask(Integer.parseInt(args[1]));
                break;
            default:
                System.out.println("Unknown command: " + args[0]);
                System.out.println("Available commands: add, list, update, mark-in-progress, mark-done, delete");
                break;
        }
    }
}