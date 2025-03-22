
// import { Component } from '@angular/core';
// import { FormsModule } from '@angular/forms';
// import { CommonModule } from '@angular/common';

// @Component({
//   selector: 'app-root',
//   standalone: true,
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css'],
//   imports: [FormsModule, CommonModule],
// })
// export class AppComponent {
//   title = 'Address_book';  // ✅ Add this to match the test expectation

//   contact = {
//     fullName: '',
//     address: '',
//     city: '',
//     state: '',
//     zip: '',
//     phoneNumber: '',
//   };

//   contacts: any[] = []; // Store contacts in an array

//   addContact() {
//     if (this.contact.fullName && this.contact.phoneNumber) {
//       this.contacts.push({ ...this.contact }); // Add contact to the array
//       this.contact = { fullName: '', address: '', city: '', state: '', zip: '', phoneNumber: '' }; // Reset form
//     } else {
//       alert('Full Name and Phone Number are required!'); // Simple validation
//     }
//   }

// }



// import { Component } from '@angular/core';
// import { AppService } from './services/app.service';

// @Component({
//   selector: 'app-root',
//   standalone: true,
//   templateUrl: './app.component.html',
//   providers: [AppService],
// })
// export class AppComponent {
//   contacts: any[] = [];
//   contact = { fullName: '', address: '', city: '', state: '', zip: '', phoneNumber: '' };

//   constructor(private appService: AppService) {}

//   addContact() {
//     this.appService.saveContact(this.contact).subscribe((response) => {
//       this.contacts.push(response);
//       this.contact = { fullName: '', address: '', city: '', state: '', zip: '', phoneNumber: '' }; // Reset form
//     });
//   }

//   loadContacts() {
//     this.appService.getContacts().subscribe((data) => {
//       this.contacts = data;
//     });
//   }
// }












import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppService } from './services/app.service';  // ✅ Ensure correct import

@Component({
  selector: 'app-root',
  standalone: true,  // ✅ Standalone Component
  imports: [CommonModule, FormsModule],  // ✅ Ensure CommonModule for NgIf, NgFor
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Address_book';
  contacts: any[] = [];
  newContact = { name: '', email: '', phone: '' };

  constructor(private appService: AppService) {
    this.loadContacts();
  }

  loadContacts() {
    this.appService.getContacts().subscribe(data => {
      this.contacts = data;
    }, error => {
      console.error('Error fetching contacts:', error);
    });
  }

  addNewContact() {
    this.appService.addContact(this.newContact).subscribe(contact => {
      console.log('Contact added:', contact);
      // this.newContact = { name: '', phone: '' }; // Clear form
      this.loadContacts(); // Reload contacts
    }, error => {
      console.error('Error adding contact:', error);
    });
  }
  deleteContact(id: number) {
    this.appService.deleteContact(id).subscribe(() => {
      this.contacts = this.contacts.filter(contact => contact.id !== id);
    });
  }
}
