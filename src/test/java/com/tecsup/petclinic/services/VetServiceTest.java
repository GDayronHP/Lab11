package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService ;

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

}
