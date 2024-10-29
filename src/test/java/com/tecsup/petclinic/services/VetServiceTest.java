package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

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
}
