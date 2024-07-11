package Question2;

public class Product {
    private String name;
    private double price;
    private int stock;
    private double rating;

    public Product(String name, double price, int stock, double rating) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("%s - Fiyat: %.2f, Stok: %d, Değerlendirme: %.2f", name, price, stock, rating);
    }
}
