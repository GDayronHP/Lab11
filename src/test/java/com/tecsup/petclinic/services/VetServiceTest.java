package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testUpdateVet() {

        String VET_NAME = "James";
        String LAST_NAME = "Carter";

        String UP_VET_NAME = "James editado";
        String UP_VET_LAST_NAME = "Carter editado";

        Vet vet = new Vet(VET_NAME, LAST_NAME);

        // ------------ Create ---------------

        log.info(">" + vet);
        Vet vetCreated = this.vetService.create(vet);
        log.info(">>" + vetCreated);

        // ------------ Update ---------------

        // Prepare data for update
        vetCreated.setFirstName(UP_VET_NAME);
        vetCreated.setLastName(UP_VET_LAST_NAME);

        // Execute update
        Vet upgradeVet = this.vetService.update(vetCreated);
        log.info(">>>>" + upgradeVet);

        //            EXPECTED        ACTUAL
        assertEquals(UP_VET_NAME, upgradeVet.getFirstName());
        assertEquals(UP_VET_LAST_NAME, upgradeVet.getLastName());
    }

    @Test
    public void testDeleteVet() {

        String FIRST_NAME = "Jane";
        String LAST_NAME = "Doe";

        // ------------ Create ---------------

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);
        vet = this.vetService.create(vet);
        log.info("" + vet);

        // ------------ Delete ---------------

        try {
            this.vetService.delete(vet.getId());
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        // ------------ Validation ---------------

        try {
            this.vetService.findById(vet.getId());
            assertTrue(false); // Si no se lanza una excepción, la prueba falla
        } catch (VetNotFoundException e) {
            assertTrue(true); // Si se lanza la excepción, la prueba es exitosa
        }

    }

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
