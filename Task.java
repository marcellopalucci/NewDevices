package NewDevices;

public abstract class Task {
    private final String name;
    private final int cpuCost;

    /**
     * Constructor (1) that takes in String name, checks for null, and sets name.
     * Takes in int cpuCost, checks for cost to be set to at least 8 and sets to cpuCost.
     * @param name String representing description of the task
     * @param cpuCost int representing the cost of processing power for this task
     */
    public Task(String name, int cpuCost){
        //check this!!!
        this.name = isValidName(name);
        this.cpuCost = isValidCPUcost(cpuCost);
    }

    @Override
    public boolean equals (Object obj){
        return (this == obj);
    }

    @Override
    public String toString(String name, int cpuCost){
        return String.format("%s has a CPU cost of %d", name, cpuCost);
    }

    /**
     * Method (3) getter which returns the cpuCost
     * @return int representing the cost of processing power for this task
     */
    public int getCpuCost() {
        return cpuCost;
    }

    private String isValidName(String nameValidator){
        return (nameValidator != null) ? nameValidator : "GEN_TASK";
    }
    private int isValidCPUcost (int cpuCostValidator){
        return (cpuCostValidator >= 8) ? cpuCostValidator : 8;
    }


}
