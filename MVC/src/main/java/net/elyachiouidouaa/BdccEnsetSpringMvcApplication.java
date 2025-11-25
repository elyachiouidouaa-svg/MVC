package net.elyachiouidouaa;

import net.elyachiouidouaa.entities.Product;
import net.elyachiouidouaa.repsoitory.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class BdccEnsetSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdccEnsetSpringMvcApplication.class, args);
    }

    // Bean pour exécuter du code au démarrage de l'application
    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            // Sauvegarde de quelques produits dans la base de données
            productRepository.save(Product.builder()
                            .name("Computer")
                            .price(5400)
                            .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(12000)
                    .quantity(33)
                    .build());
            // Affichage de tous les produits enregistrés dans la base de données
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}
