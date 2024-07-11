package Question2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager(scanner);
        Cart cart = new Cart();

        while (true) {
            System.out.println("Menü:");
            System.out.println("1. Ürün Ekle");
            System.out.println("2. Ürünleri Listele");
            System.out.println("3. Ürünleri Sırala");
            System.out.println("4. Sepete Ürün Ekle");
            System.out.println("5. Sepeti Göster ve Tutarı Hesapla");
            System.out.println("6. Çıkış");

            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter tuşunu temizle

            switch (choice) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.listProducts();
                    break;
                case 3:
                    productManager.sortProducts();
                    break;
                case 4:
                    productManager.addToCart(cart);
                    break;
                case 5:
                    System.out.println(cart);
                    System.out.println("Sepet Toplamı: " + cart.getTotalPrice());
                    break;
                case 6:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}


