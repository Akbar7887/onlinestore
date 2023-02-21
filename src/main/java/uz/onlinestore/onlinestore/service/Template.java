package uz.onlinestore.onlinestore.service;

import uz.onlinestore.onlinestore.models.Organization;

import java.util.List;

public interface Template {

    List<Object> getAll();

    Object save(Organization organization);

    void delete(Long id);
}
