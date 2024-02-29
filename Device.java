package NewDevices;

public class Device {
    private int serialNumber;
    private int cpuCapacity;
    private int cpuRemaining;
    private Task [] tasks;
    public Device (int serialNumber, int cpuCapacity, int length){
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        tasks = tasks[length];

    }

}
