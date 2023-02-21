package uz.onlinestore.onlinestore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.models.Organization;
import uz.onlinestore.onlinestore.repository.OrganizationRepository;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrganizationService implements Template{

    private final OrganizationRepository organizationRepository;

    @Override
    public List<Object> getAll() {
        return Collections.singletonList(organizationRepository.findAll());
    }

    @Override
    public Object save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }
}
