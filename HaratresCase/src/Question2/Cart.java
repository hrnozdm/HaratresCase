package Question2;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        products.add(new Product(product.getName(), product.getPrice(), quantity, product.getRating()));
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getStock();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sepetiniz:\n");
        for (Product product : products) {
            sb.append(product.getName()).append(" - Adet: ").append(product.getStock())
                    .append(", Toplam Fiyat: ").append(product.getPrice() * product.getStock()).append("\n");
        }
        return sb.toString();
    }
}
