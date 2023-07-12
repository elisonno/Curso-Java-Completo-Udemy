package entities;

public class Student {
    public String name;
    public double note1;
    public double note2;
    public double note3;
    double noteFinal;
    boolean approved;

    public void finalGrade(){
        noteFinal = note1 + note2 + note3;
        approved = noteFinal >= 60;
    }

    public String toString() {
        finalGrade();
        if(approved){
            return "\n----------------\n"+
                    "FINAL GRADE = " + String.format("%.2f", noteFinal) +
                    "\nPASS";
        }else{
            return "\n----------------\n"+
                    "FINAL GRADE = " + String.format("%.2f", noteFinal) +
                    "\nFAILED" +
                    "\nMISSING " + String.format("%.2f", (60 - noteFinal)) + " POINTS";
        }
    }
}
