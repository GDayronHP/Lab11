package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Vet;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCreateVet() {

        // Test data
        String FIRST_NAME = "Jhon";
        String LAST_NAME = "Herrera";

        // Create Vet object
        Vet vet = new Vet();
        vet.setFirstName(FIRST_NAME);
        vet.setLastName(LAST_NAME);

        // Call create method in VetService
        Vet vetCreated = this.vetService.create(vet);

        // Log created vet
        log.info("VET CREATED :" + vetCreated.toString());

        // Assertions to verify that vet was created successfully
        assertNotNull(vetCreated.getId());
        assertEquals(FIRST_NAME, vetCreated.getFirstName());
        assertEquals(LAST_NAME, vetCreated.getLastName());
    }

	
}
