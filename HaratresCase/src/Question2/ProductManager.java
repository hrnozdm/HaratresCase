package Question2;

import java.util.*;

public class ProductManager {
    private Scanner scanner;
    private List<Product> products;

    public ProductManager(Scanner scanner) {
        this.scanner = scanner;
        this.products = new ArrayList<>();
    }

    public void addProduct() {
        System.out.println("Ürün Ekleyin:");
        String name = getValidProductName();
        double price = getValidProductPrice();
        int stock = getValidProductStock();
        double rating = getValidProductRating();

        products.add(new Product(name, price, stock, rating));
        System.out.println("Ürün başarıyla eklendi.");
    }

    public void listProducts() {
        System.out.println("Ürünler:");
        products.forEach(System.out::println);
    }

    public void sortProducts() {
        System.out.println("Ürünleri hangi kritere göre sıralamak istersiniz? (name/stock/rating): ");
        String criteria = scanner.nextLine();

        System.out.println("Sıralama türü artan mı yoksa azalan mı olsun? (artan/azalan): ");
        String order = scanner.nextLine();

        boolean ascending = order.equalsIgnoreCase("artan");
        Comparator<Product> comparator = new ProductComparator(criteria, ascending);
        Collections.sort(products, comparator);

        System.out.println("Sıralanmış Ürünler:");
        products.forEach(System.out::println);
    }

    public void addToCart(Cart cart) {
        System.out.print("Sepete eklemek istediğiniz ürünün adı: ");
        String productName = scanner.nextLine();
        Product product = findProductByName(productName);

        if (product == null) {
            System.out.println("Ürün bulunamadı.");
            return;
        }

        int quantity = getValidQuantity(product);
        cart.addProduct(product, quantity);
        System.out.println("Ürün sepete başarıyla eklendi.");
    }

    private String getValidProductName() {
        String name;
        while (true) {
            System.out.print("Ürün Adı: ");
            name = scanner.nextLine();
            if (name.length() <= 20) {
                break;
            } else {
                System.out.println("Ürün adı en fazla 20 karakter olmalıdır.");
            }
        }
        return name;
    }

    private double getValidProductPrice() {
        double price;
        while (true) {
            System.out.print("Birim Fiyat: ");
            price = scanner.nextDouble();
            scanner.nextLine(); // Enter tuşunu temizle
            if (price >= 1 && price <= 100) {
                break;
            } else {
                System.out.println("Fiyat 1 ve 100 arasında olmalıdır.");
            }
        }
        return price;
    }

    private int getValidProductStock() {
        int stock;
        while (true) {
            System.out.print("Stok Miktarı: ");
            stock = scanner.nextInt();
            scanner.nextLine(); // Enter tuşunu temizle
            if (stock >= 1) {
                break;
            } else {
                System.out.println("Stok miktarı en az 1 olmalıdır.");
            }
        }
        return stock;
    }

    private double getValidProductRating() {
        double rating;
        while (true) {
            System.out.print("Değerlendirme Puanı (5 üzerinden): ");
            rating = scanner.nextDouble();
            scanner.nextLine(); // Enter tuşunu temizle
            if (rating >= 0 && rating <= 5) {
                break;
            } else {
                System.out.println("Değerlendirme puanı 0 ile 5 arasında olmalıdır.");
            }
        }
        return rating;
    }

    private Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private int getValidQuantity(Product product) {
        int quantity;
        while (true) {
            System.out.print("Eklemek istediğiniz adet: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); // Enter tuşunu temizle
            if (quantity <= product.getStock()) {
                break;
            } else {
                System.out.println("Stokta yeterli ürün yok.");
            }
        }
        return quantity;
    }
}
