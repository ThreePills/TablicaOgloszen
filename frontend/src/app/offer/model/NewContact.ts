import {Contact} from "./Contact";

export class NewContact implements Contact {
  id?: string;
  email: string;
  name: string;
  phoneNumber: number;

  constructor(id: string, email: string, name: string, phoneNumber: number) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
}
