package ADVANCED.EXERCISE6_Defining_Classes.P7_Google;

public class Parents {
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString(){
        return parentName + " " + parentBirthday;
    }

}
