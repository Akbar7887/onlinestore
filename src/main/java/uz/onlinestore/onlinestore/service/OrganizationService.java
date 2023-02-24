package uz.onlinestore.onlinestore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.models.Organization;
import uz.onlinestore.onlinestore.repository.OrganizationRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrganizationService{

    private final OrganizationRepository organizationRepository;


    public Optional<Organization> getFirst() {
        List<Organization> list = organizationRepository.findAll();
        return list.stream().findFirst();
    }

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }
}
