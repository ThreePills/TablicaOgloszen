import {Offer} from "./Offer";
import {NewContact} from "./NewContact";
import {NewLocalization} from "./NewLocalization";

export class NewOffer implements Offer {
  id?: string;
  title: string;
  content: string;
  contact: NewContact;
  localization: NewLocalization;

  constructor(id: string, title: string, contact: NewContact, localization: NewLocalization, content: string) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.contact = contact;
    this.localization = localization;
  }

}
