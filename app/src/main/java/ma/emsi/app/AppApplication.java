package ma.emsi.app;

import ma.emsi.app.entities.Product;
import ma.emsi.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"computer",49900,7));
        //productRepository.save(new Product(null,"Printer",2000,2));
        //productRepository.save(new Product(null,"Phone",1200,12));
        List<Product> products =productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        System.out.println("*******************");
        Product product=productRepository.findById(Long.valueOf(1L)).get();
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("*******************");
        List<Product> productList = productRepository.findByNameContains("c");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("*******************");
        List<Product> productList2 = productRepository.search("%c%");
        productList2.forEach(p->{
            System.out.println(p);
        });
        System.out.println("*******************");
        List<Product> productList1 = productRepository.findByPriceGreaterThan(1000);
        productList1.forEach(p->{
            System.out.println(p);
        });
        System.out.println("*******************");
        List<Product> productList3= productRepository.searchByPrice(2000);
        productList3.forEach(p->{
            System.out.println(p);
        });
    }
}
