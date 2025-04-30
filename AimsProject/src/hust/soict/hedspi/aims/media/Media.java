package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost) { this.cost = cost; }

    public void setId(int id) { this.id = id; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media other = (Media) obj;
        return this.title != null && this.title.equalsIgnoreCase(other.getTitle());
    }

    public boolean isMatch(String title) {
        if (this.title == null || title == null) return false;
        return this.title.equalsIgnoreCase(title);
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            Comparator.comparing(Media::getTitle)
                    .thenComparing(Media::getCost, Comparator.reverseOrder());
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            Comparator.comparing(Media::getCost, Comparator.reverseOrder())
                    .thenComparing(Media::getTitle);
    public abstract String toString();
}