package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;

/**
 *
 * @author jgomezm
 *
 */
@Service
@Slf4j
public class VetServiceImpl implements VetService {


    VetRepository vetRepository;

    public VetServiceImpl (VetRepository vetRepository) {
        this. vetRepository = vetRepository;
    }


    /**
     *
     * @param vet
     * @return
     */
    @Override
    public Vet create(Vet vet) {
        return vetRepository.save(vet);
    }

    /**
     *
     * @param vet
     * @return
     */
    @Override
    public Vet update(Vet vet) {
        return vetRepository.save(vet);
    }


    /**
     *
     * @param id
     * @throws VetNotFoundException
     */
    @Override
    public void delete(Integer id) throws VetNotFoundException{

        Vet vet = findById(id);
        vetRepository.delete(vet);

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Vet findById(Integer id) throws VetNotFoundException {

        Optional<Vet> vet = vetRepository.findById(id);

        if ( !vet.isPresent())
            throw new VetNotFoundException("Record not found...!");

        return vet.get();
    }

    /**
     *
     * @param first_name
     * @return
     */
    @Override
    public List<Vet> findByFirstName(String first_name) {

        List<Vet> vets = vetRepository.findByFirstName(first_name);

        vets.stream().forEach(vet -> log.info("" + vet));

        return vets;
    }

    /**
     *
     * @param last_name
     * @return
     */
    @Override
    public List<Vet> findByLastName(String last_name) {

        List<Vet> vets = vetRepository.findByLastName(last_name);

        vets.stream().forEach(vet -> log.info("" + vet));

        return vets;
    }


}