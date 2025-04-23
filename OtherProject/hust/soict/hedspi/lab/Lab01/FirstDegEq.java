//Example 2.2.6-1
import javax.swing.JOptionPane;
public class FirstDegEq {

    public static void main(String[] args) {
        String str_a = JOptionPane.showInputDialog(null, "Enter the value of x's coefficient", "Input:", JOptionPane.INFORMATION_MESSAGE);
        String str_b = JOptionPane.showInputDialog(null, "Enter the value of the constant term", "Input:", JOptionPane.INFORMATION_MESSAGE);
        String str_c = JOptionPane.showInputDialog(null, "Enter the value of the result", "Input:", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(str_a);
        double b = Double.parseDouble(str_b);
        double c = Double.parseDouble(str_c);
        String result;
        if (a == 0){
            if (b == c){
                result = "Infinite solutions";
            }
            else result = "No solutions";
        }
        else{
            double x = (c - b) / a;
            result ="x = " + x + " is the solution of the equation " + a + "x + " + b + " = " + c ;
        }
        JOptionPane.showMessageDialog(null, result, "Solution",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}