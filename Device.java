package NewDevices;

public abstract class Device{
    final private int serialNumber;
    final protected int cpuCapacity;
    protected int cpuRemaining;
    private Task [] tasks;

    /**
     * Constructor (1) that takes in and int serialNumber, int cpuCapacity, and int length,
     * and setting serialNumber, cpuCapacity, and length of the task array.
     * @param serialNumber int representing a unique identifier for the device
     * @param cpuCapacity int representing the total amount of processing power for the device
     * @param length int representing the number of tasks in the task array
     */
    public Device (int serialNumber, int cpuCapacity, int length){
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        this.tasks = new Task[]{tasks[length]};
        this.cpuRemaining = cpuCapacity - Task.getCpuCost();
    }

    /**
     * Constructor (2) that takes in the device's serial number and number of tasks.
     * @param serialNumber int representing a unique identifier for the device
     * @param length int representing the number of tasks in the task array
     */
    public Device (int serialNumber, int length){
        this.serialNumber = serialNumber;
        this.tasks = new Task[]{tasks[length]};
        this.cpuCapacity = 512;
    }

    /**
     * Method (1) Takes in a Task object and returns a boolean of whether the task can be added to the tasks array.
     * @param task Task representing a devices tasks
     * @return true if a task can be added, otherwise return false
     */
    public abstract boolean canAddTask(Task task);

    /**
     * Method (2) Takes in a Task object. This method will add the task to the tasks array
     * @param task Task representing a devices tasks
     * @return true if the task is successfully added to the tasks array, and false otherwise
     */
    public abstract boolean addTask(Task task);



    //// java docs
    public boolean processTask(Task task){
        //need to do
    }

    //// java docs - check
    @Override
    public boolean equals (Object obj){
        return (this == obj);
    }

    /////java docs
    @Override
    public String toString(){
        return String.format("Device with serial number %d has %d of %d CPU remaining.");
    }




}
