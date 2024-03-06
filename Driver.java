

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
        CellPhone iPhone = new CellPhone(1234, 512, 4);
        CellPhone samsung = new CellPhone(4567, 1024, 20);
        Task task1 = new Task("compute sum", 64);
        Task task2 = new Task("play game :)", 512);
        Task task3 = new Task("call mumm", 12);
        samsung.addTask(task1);
        samsung.addTask(task2);
        samsung.addTask(task3);

        samsung.processTask(task2);
        samsung.processTask(task3);

        System.out.println(samsung.toString());
    }
}
