//Example 2.2.6-2
import javax.swing.JOptionPane;

public class FirstDegSystem {
    public static void main(String[] args) {

        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));
        
        // Use the following determinants:
        double D = a11 * a22 - a12 * a21;
        double Dx = b1 * a22 - b2 * a12;
        double Dy = a11 * b2 - a21 * b1;
        
        String result;
        
        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                result = "Infinite solutions"; 
            } else {
                result = "No solution"; 
            }
        } else {
            double x1 = Dx / D;
            double x2 = Dy / D;
            result = "Solution: x1 = " + x1 + ", x2 = " + x2;
        }
        
        // SIUUUUUUUUUUUUU
        JOptionPane.showMessageDialog(null, result, "Solution", JOptionPane.INFORMATION_MESSAGE);
    }
}
