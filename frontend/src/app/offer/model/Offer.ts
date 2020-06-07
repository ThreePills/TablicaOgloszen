import { Contact } from './Contact';
import { Localization } from './Localization';

export interface Offer {
  id?: string;
  title: string;
  contact: Contact;
  localization: Localization;
  content: string;
}
