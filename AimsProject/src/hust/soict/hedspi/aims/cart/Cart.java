package hust.soict.hedspi.aims.cart;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public Cart(){
        qtyOrdered =0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(this.qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }else {
            this.itemsOrdered[qtyOrdered] = disc;
            System.out.println("The disc has been added");
            this.qtyOrdered = this.qtyOrdered + 1;
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                addDigitalVideoDisc(disc);
            } else {
                System.out.println("The cart is full. Cannot add more discs.");
                break;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2){
        if (this.qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The cart is almost full");
        } else {
            this.itemsOrdered[qtyOrdered++] = disc1;
            this.itemsOrdered[qtyOrdered++] = disc2;
            System.out.println("The disc1 and disc2 have been added");
        }

    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int check = -1;
        for(int i=0; i< this.qtyOrdered; i++){
            if(this.itemsOrdered[i] == disc){
                check = i;
                break;
            }
        }
        if(check == -1){
            System.out.println("The disk does not exist");
        }else{
            this.qtyOrdered = this.qtyOrdered - 1;
            this.itemsOrdered[check] = this.itemsOrdered[qtyOrdered];
            this.itemsOrdered[qtyOrdered] = null;
            System.out.println("The disc has been removed");
        }
    }
    public float totalCost(){
        float totalCost = 0;
        for(int i = 0; i < qtyOrdered; i++){
            if (this.itemsOrdered[i] != null) {
                totalCost += this.itemsOrdered[i].getCost();
            }
        }
        return totalCost;
    }
}