package net.elyachiouidouaa.repsoitory;

import net.elyachiouidouaa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository : Hérite de toutes les opérations CRUD standard
public interface ProductRepository extends JpaRepository<Product, Long> {
}
