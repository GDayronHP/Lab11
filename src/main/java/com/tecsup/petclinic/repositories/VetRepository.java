package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Vet entity.
 */
@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {

    // Fetch vets by last name
    List<Vet> findByFirstName(String firstName);

    List<Vet> findByLastName(String lastName);

    // Fetch all vets
    @Override
    List<Vet> findAll();
}