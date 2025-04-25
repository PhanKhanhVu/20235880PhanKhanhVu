package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Test swap
        System.out.println("-- Before swap --");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);

        System.out.println("-- After swap (no effect) --");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        // Test changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("-- After changeTitle --");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        DigitalVideoDisc tmp = d1;
        d1 = d2;
        d2 = tmp;
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);

        dvd = new DigitalVideoDisc(oldTitle);
    }
}