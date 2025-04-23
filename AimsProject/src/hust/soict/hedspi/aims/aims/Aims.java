package hust.soict.hedspi.aims.aims;
public class Aims {
    public static void main(String[] arg) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // Test removeDigitalVideoDisc
        System.out.println("\nTest removeDigitalVideoDisc: ");
        anOrder.removeDigitalVideoDisc(dvd1);
        // Remove The lion King
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        //Test method overloading
        System.out.println("\nTest method overloading");
        anOrder.addDigitalVideoDisc(dvd1);

        System.out.println("\nTest add 2 digital video disc: ");
        anOrder.addDigitalVideoDisc(dvd1, dvd2);

        System.out.println("\nTest add array digital video disc: ");
            DigitalVideoDisc[] dvdArray = new DigitalVideoDisc[3];
            dvdArray[0] = dvd1;
            dvdArray[1] = dvd2;
            dvdArray[2] = dvd3;
        anOrder.addDigitalVideoDisc(dvdArray);
    }
}