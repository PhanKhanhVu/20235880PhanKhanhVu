//Example 2.2.5
import javax.swing.JOptionPane;

public class Calculate {

    public static void main(String[] args) {
        String strnum1, strnum2;
        String strNotifi = "You've just entered: ";

        strnum1 = JOptionPane.showInputDialog(null, 
        "Please input the first number", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotifi += strnum1 + " and ";
        strnum2 = JOptionPane.showInputDialog(null, 
        "Please input the second number", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotifi += strnum2;
        double n1 = Double.parseDouble(strnum1);
        double n2 = Double.parseDouble(strnum2);
        double sum = n1 + n2, dif = n1 - n2, prod = n1 * n2;
        String quo = (n2 == 0) ? "Can't divide by 0" : String.valueOf(n1 / n2);
        strNotifi   += "\nSum: " + sum
                    + "\nDifference: " + dif
                    + "\nProduct: " + prod
                    + "\nQuotient: " + quo;
        JOptionPane.showMessageDialog(null, strNotifi, "Calculate", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}