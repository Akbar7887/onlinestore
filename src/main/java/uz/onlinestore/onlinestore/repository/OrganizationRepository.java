package uz.onlinestore.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.onlinestore.onlinestore.models.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

//    @Query(value = "SELECT  o.id FROM Organization o ORDER BY o.id LIMIT 1", nativeQuery = true)
//    Organization getFirst();

}