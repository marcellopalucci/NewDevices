
/**
 * @author mpalucci3
 * @version 1.05
 */
public class Driver {
    /**
     * Main driver method, basically to test classe.
     * @param args no args used in this method
     */
    public static void main(String[] args) {
        //2 CellPhone objects
        CellPhone iPhone = new CellPhone(1234, 512, 4);
        CellPhone samsung = new CellPhone(4567, 20);
        //Create new tasks
        Task task1 = new Task("compute sum", 64);
        Task task2 = new Task("play game :)", 512);
        Task task3 = new Task("call mumm", 104);
        //use addtask on one cell phone object
        samsung.addTask(task1);
        samsung.addTask(task2);
        samsung.addTask(task3);
        iPhone.addTask(task2);
        //use process task on at least one of cellphone objects
        samsung.processTask(task2);
        samsung.processTask(task3);
        iPhone.processTask(task2);
        //call tostring on at least one of the cellphone objects
        System.out.println(samsung.toString());
        System.out.println(iPhone.toString());

        //call equals on at least one cellphone object
        System.out.println(samsung.equals(iPhone));

        //create 2 laptops
        Laptop macbook = new Laptop(5543223, 1024, 56);
        Laptop razr4090 = new Laptop(1234532, 4048, 128, true);
        Laptop razr4080 = new Laptop(1234532, 4048, 128, true);

        //2 addtasks to at least one laptop
        macbook.addTask(task1);
        macbook.addTask(task2);
        razr4090.addTask(task1);
        razr4080.addTask(task1);

        //at least 1 processtask
        razr4080.processTask(task1);
        razr4090.processTask(task2);

        //at least 1 tostring
        System.out.println(razr4080.toString());
        //check two laptops if they are equal
        System.out.println(razr4080.equals(razr4090));

    }
}
