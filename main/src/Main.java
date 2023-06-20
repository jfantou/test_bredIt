import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        List<String> listValue = Arrays.asList("a", "b", "c", "d", "e");
        Tabletest table = new Tabletest();
        String html = table.process(listValue, 2);
        System.out.println(html);

        AppleTest appletest = new AppleTest();
        System.out.println(appletest.process(10, 2,1));
        System.out.println(appletest.process(10, 2,2));
        System.out.println(appletest.process(10, 2,5));
        System.out.println(appletest.process(20, 3,3));

    }



    public static Map<String, List<String>> groupByColour(List<Product> products) {
        // TODO return products which don't contain a word iphone
        // (P.S. use toLowerCase() to match all the cases like iPhone, IPhone, etc.)
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.getAttributes().getOrDefault("colour", "No colour"),
                        Collectors.mapping(Product::getName, Collectors.toList())));
    }

    public static List<Product> nonIPhoneProducts(List<Product> products) {
        // TODO return products which don't contain a word iphone
        // (P.S. use toLowerCase() to match all the cases like iPhone, IPhone, etc.)
        return products.stream()
                .filter(product -> !product.getName().toLowerCase().contains("iphone"))
                .collect(Collectors.toList());
    }

    public static List<Product> sixPointOneInchesScreenSizeProducts(List<Product> products) {
        // TODO return products which have "6.1 inches" screen size as part of their attributes
        return products.stream()
                .filter(product -> product.getAttributes().get("screen size").equalsIgnoreCase("6.1 inches"))
                .collect(Collectors.toList());
    }

    public static double sixPointOneInchesScreenSizeIPhoneAveragePriceExcludingDiscount(List<Product> products) {
        // TODO return the average price without considering the discount of the iphones which have 6.1 inches screen size
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains("iphone"))
                .filter(product -> product.getAttributes().get("screen size").equalsIgnoreCase("6.1 inches"))
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
    }

    public static double sixPointOneInchesScreenSizeIPhoneAveragePriceIncludingDiscount(List<Product> products) {
        // TODO return the average price after applying the discount of the iphones which have 6.1 inches screen size
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains("iphone"))
                .filter(product -> product.getAttributes().get("screen size").equalsIgnoreCase("6.1 inches"))
                .mapToDouble(product -> product.getPrice()-(product.getPrice()) * product.getDiscount())
                .average()
                .orElse(0);
    }

    public static Product productWithMaxDiscountInDollars(List<Product> products) {
        // TODO return the product which has the greatest discount in the dollars equivalent
        return products.stream()
                .max(Comparator.comparing(p -> p.getPrice() * p.getDiscount())).get();
    }

    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Map<String, String> productAttributes1 = new HashMap<String, String>() {{
            put("colour", "black");
            put("screen size", "4.7 inches");
        }};
        products.add(new Product("IPhone 8 64GB Black", 280, 0.05, productAttributes1));

        Map<String, String> productAttributes2 = new HashMap<String, String>() {{
            put("colour", "red");
            put("screen size", "6.1 inches");
        }};
        products.add(new Product("IPhone XR 64GB Red", 370, 0.03, productAttributes2));

        Map<String, String> productAttributes3 = new HashMap<String, String>() {{
            put("colour", "green");
            put("screen size", "6.1 inches");
        }};
        products.add(new Product("IPhone 13 128GB Green", 1000, 0, productAttributes3));

        Map<String, String> productAttributes4 = new HashMap<String, String>() {{
            put("colour", "black");
            put("screen size", "6.7 inches");
        }};
        products.add(new Product("Google Pixel 6 Pro 128 GB", 800, 0, productAttributes4));

        Map<String, String> productAttributes5 = new HashMap<String, String>() {{
            put("colour", "white");
            put("screen size", "6.3 inches");
        }};
        products.add(new Product("Samsung Galaxy Note10 Plus 256GB", 410, 0.07, productAttributes5));

        return products;
    }

}