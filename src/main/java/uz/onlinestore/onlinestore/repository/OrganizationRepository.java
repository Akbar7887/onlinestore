package uz.onlinestore.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.onlinestore.onlinestore.models.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}