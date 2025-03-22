// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root',
// })
// export class AddressBookService {
//   private apiUrl = 'http://localhost:8080/addressbook'; // ✅ Correct URL

//   constructor(private http: HttpClient) {}

//   getContacts(): Observable<any[]> {
//     return this.http.get<any[]>(`${this.apiUrl}/all`); // ✅ Ensure correct endpoint
//   }

//   addContact(contact: any): Observable<any> {
//     return this.http.post<any>(`${this.apiUrl}/add`, contact);
//   }
// }

// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';

// @Injectable({ providedIn: 'root' }) // ✅ No need to provide it manually in `main.ts`
// export class AppService {
//   private apiUrl = 'http://localhost:8080/contacts'; // Your Spring Boot backend URL

//   constructor(private http: HttpClient) {}

//   // Fetch all contacts
//   getContacts(): Observable<any[]> {
//     return this.http.get<any[]>(this.apiUrl);
//   }

//   // Save a new contact
//   saveContact(contact: any): Observable<any> {
//     return this.http.post<any>(this.apiUrl, contact);
//   }
// }








import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private apiUrl = 'http://localhost:8080/contacts'; // Adjust based on your backend

  constructor(private http: HttpClient) {}

  getContacts(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  addContact(contact: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, contact);
  }

  deleteContact(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
