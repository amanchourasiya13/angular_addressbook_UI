import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root', // Correct selector for main component
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [FormsModule, CommonModule],
})
export class AppComponent {
  title = 'Address_book'; // Title property to match your tests

  // Model for a single contact
  contact = {
    fullName: '',
    address: '',
    city: '',
    state: '',
    zip: '',
    phoneNumber: '',
  };

  // Array to store contacts
  contacts: any[] = [
    { fullName: 'Varaz Mishra', address: 'Marve Road,Next TO Maniratna,Malad(west)', city: 'Mumbai', state: 'Maharastra', zip: 'p400064',phoneNumber: '02228017752' },
    { fullName: 'Trishna Bhalla', address: '456 Elm St', city: 'Mumbai', state: 'Maharastra', zip: '400003', phoneNumber: '55567800' }
  ];

  // Method to add a contact to the contacts array
  addContact() {
    if (this.contact.fullName && this.contact.phoneNumber) {
      this.contacts.push({ ...this.contact }); // Add the contact to the array
      this.contact = { fullName: '', address: '', city: '', state: '', zip: '', phoneNumber: '' }; // Reset form
    } else {
      alert('Full Name and Phone Number are required!'); // Basic validation
    }
  }
}
