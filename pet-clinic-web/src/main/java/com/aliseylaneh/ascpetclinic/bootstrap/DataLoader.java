package com.aliseylaneh.ascpetclinic.bootstrap;

import com.aliseylaneh.ascpetclinic.model.Owner;
import com.aliseylaneh.ascpetclinic.model.Pet;
import com.aliseylaneh.ascpetclinic.model.PetType;
import com.aliseylaneh.ascpetclinic.model.Vet;
import com.aliseylaneh.ascpetclinic.services.OwnerService;
import com.aliseylaneh.ascpetclinic.services.PetTypeService;
import com.aliseylaneh.ascpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ali");
        owner1.setLastName("Seylaneh");
        owner1.setAddress("123 Bickered");
        owner1.setCity("Miami");
        owner1.setTelephone("123456");

        Pet alisPet = new Pet();
        alisPet.setPetType(dog);
        alisPet.setBirthDate(LocalDate.now());
        alisPet.setOwner(owner1);
        alisPet.setName("Rosco");
        owner1.getPets().add(alisPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Jake");
        owner2.setLastName("Thompson");
        owner2.setAddress("123 Bickered");
        owner2.setCity("Miami");
        owner2.setTelephone("123456");

        Pet jakesPet = new Pet();
        jakesPet.setPetType(cat);
        jakesPet.setBirthDate(LocalDate.now());
        jakesPet.setOwner(owner2);
        jakesPet.setName("Roswell");
        owner2.getPets().add(jakesPet);
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Robert");
        owner3.setLastName("Johnson");
        owner3.setAddress("123 Bickered");
        owner3.setCity("Miami");
        owner3.setTelephone("123456");
        Pet robertPet = new Pet();
        robertPet.setPetType(dog);
        robertPet.setBirthDate(LocalDate.now());
        robertPet.setOwner(owner3);
        robertPet.setName("Roxy");
        owner3.getPets().add(robertPet);
        ownerService.save(owner3);


        System.out.println("Loaded Owners...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Chris");
        vet1.setLastName("Evans");
        Vet vet2 = new Vet();
        vet2.setFirstName("Mohammad");
        vet2.setLastName("Seylaneh");
        Vet vet3 = new Vet();
        vet3.setFirstName("Chrissy");
        vet3.setLastName("Costanza");
        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);
        System.out.println("Loaded Vets...");
    }
}
