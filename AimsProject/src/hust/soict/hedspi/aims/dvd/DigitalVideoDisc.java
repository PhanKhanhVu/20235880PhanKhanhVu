package hust.soict.hedspi.aims.dvd;
public class DigitalVideoDisc {
    private String title;
    private String categories;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title){
        this.title = title;
    }
    public DigitalVideoDisc(String categories, String title, float cost){
        this.categories = categories;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String director, String categories, String title, float cost){
        this.director = director;
        this.categories = categories;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String categories, String director, int length, float cost){
        this.title =title;
        this.categories = categories;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle(){
        return this.title;
    }
    public String getCategories(){
        return this.categories;
    }
    public String getDirector(){
        return this.director;
    }
    public int getLength(){
        return this.length;
    }
    public float getCost(){
        return this.cost;
    }
    public  void setTitle(String title){
        this.title = title;
    }
    public void setCategories(String categories){
        this.categories = categories;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setLength(int length){
        this.length = length;
    }
    public void setCost(float cost){
        this.cost = cost;
    }
}