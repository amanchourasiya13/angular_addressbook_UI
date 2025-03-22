//package com.bridgelabz.addressbook.service;
//
//import com.bridgelabz.addressbook.dto.AddressBookDTO;
//import com.bridgelabz.addressbook.model.AddressBook;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AddressBookService {
//    private List<AddressBook> addressBookList = new ArrayList<>();
//    private long idCounter = 1; // To generate unique IDs
//
//    // Add an address
//    public AddressBook addAddress(AddressBookDTO addressBookDTO) {
//        AddressBook newAddress = new AddressBook(idCounter++, addressBookDTO.getName(),
//                addressBookDTO.getAddress(), addressBookDTO.getCity(), addressBookDTO.getPhone());
//        addressBookList.add(newAddress);
//        return newAddress;
//    }
//
//    // Get all addresses
//    public List<AddressBook> getAllAddresses() {
//        return addressBookList;
//    }
//
//    // Get address by ID
//    public AddressBook getAddressById(Long id) {
//        Optional<AddressBook> address = addressBookList.stream()
//                .filter(entry -> entry.getId().equals(id))
//                .findFirst();
//        return address.orElse(null);
//    }
//
//    // Update an address by ID
//    public AddressBook updateAddress(Long id, AddressBookDTO addressBookDTO) {
//        for (AddressBook entry : addressBookList) {
//            if (entry.getId().equals(id)) {
//                entry.setName(addressBookDTO.getName());
//                entry.setAddress(addressBookDTO.getAddress());
//                entry.setCity(addressBookDTO.getCity());
//                entry.setPhone(addressBookDTO.getPhone());
//                return entry;
//            }
//        }
//        return null; // Address not found
//    }
//
//    // Delete an address by ID
//    public boolean deleteAddress(Long id) {
//        return addressBookList.removeIf(entry -> entry.getId().equals(id));
//    }
//}

package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    // Add a new address
    public AddressBook addAddress(AddressBookDTO addressBookDTO) {
        AddressBook newAddress = new AddressBook(null, addressBookDTO.getName(),
                addressBookDTO.getAddress(), addressBookDTO.getCity(), addressBookDTO.getPhone());
        return addressBookRepository.save(newAddress); // Save to MySQL
    }

    // Get all addresses
    public List<AddressBook> getAllAddresses() {
        return addressBookRepository.findAll(); // Fetch from MySQL
    }

    // Get address by ID
    public AddressBook getAddressById(Long id) {
        Optional<AddressBook> address = addressBookRepository.findById(id);
        return address.orElse(null);
    }

    // Update an address by ID
    public AddressBook updateAddress(Long id, AddressBookDTO addressBookDTO) {
        Optional<AddressBook> existingAddress = addressBookRepository.findById(id);
        if (existingAddress.isPresent()) {
            AddressBook updatedAddress = existingAddress.get();
            updatedAddress.setName(addressBookDTO.getName());
            updatedAddress.setAddress(addressBookDTO.getAddress());
            updatedAddress.setCity(addressBookDTO.getCity());
            updatedAddress.setPhone(addressBookDTO.getPhone());
            return addressBookRepository.save(updatedAddress); // Save updated entry to MySQL
        }
        return null;
    }

    // Delete an address by ID
    public boolean deleteAddress(Long id) {
        if (addressBookRepository.existsById(id)) {
            addressBookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
