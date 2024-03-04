package NewDevices;

public class CellPhone extends Device{

    private int tasksCompleted;

    public CellPhone (int serialNumber, int cpuCapacity, int length){
        super(serialNumber, cpuCapacity, length);
    }

    public CellPhone (int serialNumber, int cpuCapacity){
        super(serialNumber, cpuCapacity, 10);
    }


    @Override
    public boolean canAddTask(Task task) {
        return false;
    }

    @Override
    public boolean addTask(Task task) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("It has completed %d tasks.", tasksCompleted);
    }

}
