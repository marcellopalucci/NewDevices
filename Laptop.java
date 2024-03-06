
/**
 * @author mpalucci3
 * @version 1.03
 */
public class Laptop extends Device {
    private boolean overclockable;

    /**
     * Constructor (1) that takes the serialNumber, cpuCapacity, the length of the tasks array, and
     * whether it is overclockable.
     * @param serialNumber int representing a unique identifier for the laptop
     * @param cpuCapacity int representing the total amount of processing power for the laptop
     * @param length int representing the number of tasks in the task array
     * @param overclockable boolean representing if a laptop has overclocking capabilities
     */
    public Laptop(int serialNumber, int cpuCapacity, int length, boolean overclockable) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = overclockable;
    }

    /**
     * Constructor (2) that takes in the serialNumber, cpuCapacity, and the length of the tasks
     * array, and defaults overclockable to false.
     * @param serialNumber int representing a unique identifier for the laptop
     * @param cpuCapacity int representing the total amount of processing power for the laptop
     * @param length int representing the number of tasks in the task array
     */
    public Laptop(int serialNumber, int cpuCapacity, int length) {
        this(serialNumber, cpuCapacity, length, false);
    }

    /**
     * Method (1) calculates how many slots should be left open in the tasks
     * array to ensure that the instance of Laptop is able to function optimally
     * while completing tasks.
     * @param cpuRemaining int representing the total amount of processing power for the laptop
     * @return int representing the number of slots that should be left open
     */
    public int bufferSlotsRequired(int cpuRemaining) {
        if (super.tasks.length <= 4) {
            return 0;
        } else if (cpuRemaining < 128) {
            return 2;
        } else {
            return 1;
        }
    }
    @Override
    public boolean canAddTask(Task task) {
        int emptyslotCounter = 0;
        for (int i = 0; i < super.tasks.length; i++) {
            if (tasks[i] == null) {
                emptyslotCounter++;
            }
        }
        if ((super.cpuRemaining > task.getCpuCost())
                && (emptyslotCounter - bufferSlotsRequired(super.cpuRemaining) > 0)) {
            return true;
        } else if ((super.cpuRemaining < task.getCpuCost()) && overclockable) {
            return (super.cpuRemaining * 5 / 4 > task.getCpuCost() && (emptyslotCounter
                    - bufferSlotsRequired(super.cpuRemaining) > 0));
        }
        return false;
    }

    @Override
    public boolean addTask(Task task) {
        if (canAddTask(task)) {
            if (overclockable) {
                this.overclockable = false;
            }
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Laptop otherLaptop = (Laptop) obj;

        return this.overclockable == otherLaptop.overclockable
                && super.equals(obj);
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        if (overclockable) {
            result = 31 * result;
        }
        return result;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" This laptop %s have overclocking.\n",
                (overclockable) ? "does" : "does not");
    }
}
