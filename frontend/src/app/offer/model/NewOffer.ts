import {Offer} from "./Offer";

export class NewOffer implements Offer {
  id: string;
  title: string;
  telephone: string;
  content: string;

  constructor(id: string, title: string, telephone: string, content: string) {
    this.id = id;
    this.title = title;
    this.telephone = telephone;
    this.content = content;
  }
}
