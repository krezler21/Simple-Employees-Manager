package project.model;

public enum EmployeeCondition {
    PRESENT(0,"Present"),
    ABSENT(1,"Absent"),
    DURING_DELEGATION(2,"During delegation"),
    SICK(3,"Sick");

    private final int value;
    private final String description;

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

    EmployeeCondition(int value, String desc) {
        this.value = value;
        this.description = desc;
    }

    static EmployeeCondition createFromInt(int option){
        return EmployeeCondition.values()[option];
    }
}
