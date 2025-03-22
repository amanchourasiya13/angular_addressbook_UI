//package com.bridgelabz.addressbook.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data  // Generates getters, setters, toString(), equals(), and hashCode()
//@NoArgsConstructor  // Generates a no-args constructor
//@AllArgsConstructor // Generates a constructor with all fields
//public class AddressBook {
//    private Long id;
//    private String name;
//    private String address;
//    private String city;
//    private String phone;
//}

package com.bridgelabz.addressbook.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_book") // Ensure it maps to your MySQL table
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String phone;
}

