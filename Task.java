
/**
 * @author mpalucci3
 * @version 1.00
 */
public final class Task {
    private final String name;
    private final int cpuCost;

    /**
     * Constructor (1) that takes in String name, checks for null, and sets name.
     * Takes in int cpuCost, checks for cost to be set to at least 8 and sets to cpuCost.
     * @param name String representing description of the task
     * @param cpuCost int representing the cost of processing power for this task
     */
    public Task(String name, int cpuCost) {
        //check this!!!
        this.name = isValidName(name);
        this.cpuCost = isValidCPUcost(cpuCost);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Task otherTask = (Task) obj;
        return (name == otherTask.name
                && cpuCost == otherTask.cpuCost);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + cpuCost;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s has CPU cost of %d", name, cpuCost);
    }

    /**
     * Method (3) getter method which returns the cpuCost.
     * @return int representing the cost of processing power for this task
     */
    public int getCpuCost() {
        return cpuCost;
    }

    private String isValidName(String nameValidator) {
        return (nameValidator != null) ? nameValidator : "GEN_TASK";
    }
    private int isValidCPUcost(int cpuCostValidator) {
        return (cpuCostValidator >= 8) ? cpuCostValidator : 8;
    }


}
