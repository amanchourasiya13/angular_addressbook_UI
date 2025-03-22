package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")

public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping
    public String test() {
        return "Spring Boot is running!";
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBook> addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok(addressBookService.addAddress(addressBookDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllAddresses() {
        return ResponseEntity.ok(addressBookService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id) {
        AddressBook address = addressBookService.getAddressById(id);
        if (address == null) {
            return ResponseEntity.badRequest().body("Address with ID " + id + " not found!");
        }
        return ResponseEntity.ok(address);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook updatedAddress = addressBookService.updateAddress(id, addressBookDTO);
        if (updatedAddress == null) {
            return ResponseEntity.badRequest().body("Address with ID " + id + " not found!");
        }
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        boolean deleted = addressBookService.deleteAddress(id);
        if (!deleted) {
            return ResponseEntity.badRequest().body("Address with ID " + id + " not found!");
        }
        return ResponseEntity.ok("Address deleted successfully");
    }
}
