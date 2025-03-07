/*
 * Class: CMSC203
 * Instructor: Ashique Tanveer
 * Description: 
 * Due Date: 2/28/25
 * Platform/compiler: Eclipse IDE for Java Developers - 2024-12
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   
* any source. I have not given my code to any student.
 * Print your Name here: William Keller
*/

package myself;

public class Procedure {
    private String procedureName,
    procedureDate,
    practitionerName;
    private double procedureCharges;

    public Procedure() {
        //no args construct
    }

    //name date construct
    public Procedure(String name, String date) {
        procedureName = name;
        procedureDate = date;
    }

    //full data construct
    public Procedure(String name, String date, String practitioner, double charges) {
        procedureName = name;
        procedureDate = date;
        practitionerName = practitioner;
        procedureCharges = charges;
    }

    //mutators
    //procedure name
    public String getProcedureName() {
        return procedureName;
    }
    public void setProcedureName(String name) {
        procedureName = name;
    }
    
    //procedure date
    public String getProcedureDate() {
        return procedureDate;
    }
    public void setProcedureDate(String date) {
        procedureDate = date;
    }
    
    //practitioner name
    public String getPractitionerName() {
        return practitionerName;
    }
    public void setPractitionerName(String practitioner) {
        practitionerName = practitioner;
    }
    
    //procedure charges
    public double getProcedureCharges() {
        return procedureCharges;
    }
    public void setProcedureCharges(double charges) {
        procedureCharges = charges;
    }
    
    // fully formatted data
    public String toString() {
        return "\n\tProcedure: " + procedureName + "\n" +
            "\tProcedureDate=" + procedureDate + "\n" +
            "\tPractitioner=" + practitionerName + "\n" +
            String.format("\tCharge=%.2f", procedureCharges);
    }
}
