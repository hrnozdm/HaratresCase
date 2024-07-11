package Question2;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    private String criteria;
    private boolean ascending;

    public ProductComparator(String criteria, boolean ascending) {
        this.criteria = criteria;
        this.ascending = ascending;
    }

    @Override
    public int compare(Product p1, Product p2) {
        if (criteria == null || criteria.isEmpty()) {
            throw new IllegalArgumentException("Sıralama kriteri belirtilmemiş.");
        }

        switch (criteria.toLowerCase()) {
            case "name":
                return ascending ? p1.getName().compareTo(p2.getName()) : p2.getName().compareTo(p1.getName());
            case "stock":
                return ascending ? Integer.compare(p1.getStock(), p2.getStock()) : Integer.compare(p2.getStock(), p1.getStock());
            case "rating":
                return ascending ? Double.compare(p1.getRating(), p2.getRating()) : Double.compare(p2.getRating(), p1.getRating());
            default:
                throw new IllegalArgumentException("Geçersiz sıralama kriteri: " + criteria);
        }
    }
}
