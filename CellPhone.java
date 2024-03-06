
/**
 * @author mpalucci3
 * @version 1.02
 */
public class CellPhone extends Device {

    private int tasksCompleted = 0;

    /**
     * Constructor (1) taking in a cellphone's serialNumber, cpuCapacity, and the number of tasks.
     * @param serialNumber int representing a unique identifier for the cellphone
     * @param cpuCapacity int representing the total amount of processing power for the cellphone
     * @param length int representing the number of tasks in the task array
     */
    public CellPhone(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
    }

    /**
     * Constructor (2) taking in a cellphone's serialNumber and cpuCapacity, setting the
     * number of tasks to its default of 10.
     * @param serialNumber int representing a unique identifier for the cellphone
     * @param cpuCapacity int representing the total amount of processing power for the cellphone
     */
    public CellPhone(int serialNumber, int cpuCapacity) {
        super(serialNumber, cpuCapacity, 10);
    }

    @Override
    public boolean canAddTask(Task task) {
        for (int i = 0; i < super.tasks.length; i++) {
            if (super.tasks[i] == null || super.tasks[i].getCpuCost() < super.cpuRemaining) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addTask(Task task) {
        if (canAddTask(task)) {
            for (int i = 0; i < super.tasks.length; i++) {
                if (tasks[i] == null) {
                    tasks[i] = task;
                    super.cpuRemaining -= tasks[i].getCpuCost();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean processTask(Task task) {
        if (super.processTask(task)) {
            tasksCompleted++;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        CellPhone otherCellPhone = (CellPhone) obj;

        return tasksCompleted == otherCellPhone.tasksCompleted && super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" It has completed %d tasks.\n", tasksCompleted);
    }

}
