package NewDevices;

public abstract class Device{
    final private int serialNumber;
    final protected int cpuCapacity;
    protected int cpuRemaining;
    protected Task [] tasks;

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
        this.cpuRemaining = cpuCapacity;
    }

    /**
     * Constructor (2) that takes in the device's serial number and number of tasks
     * and sets cpuCapacity to its default of 512.
     * @param serialNumber int representing a unique identifier for the device
     * @param length int representing the number of tasks in the task array
     */
    public Device (int serialNumber, int length){
        this(serialNumber, 512, length);
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

    /**
     * Method (3) Takes in a Task object and returns a boolean of whether the task was processed successfully.
     * @param task Task representing a device's tasks
     * @return
     */
    public boolean processTask(Task task){
        if (task == null) return false;
        for (int i = 0; i < this.tasks.length; i++){
            if (tasks[i].equals(task)){
                cpuRemaining += tasks[i].getCpuCost();
                System.out.printf("Processed: %s", tasks[i].toString());
                tasks[i] = null;
                return true;
            }
        }
        return false;
    }

    //// java docs - check
    @Override
    public boolean equals (Object obj){
        if (obj == null)
            return false;

        Device otherDevice = (Device) obj;

        return (serialNumber == otherDevice.serialNumber &&
                cpuCapacity == otherDevice.cpuCapacity &&
                cpuRemaining == otherDevice.cpuRemaining);
    }

    /////java docs
    @Override
    public String toString(){
        return String.format("Device with serial number %d has %d of %d CPU remaining.", serialNumber,
                cpuRemaining, cpuCapacity);
    }

}
