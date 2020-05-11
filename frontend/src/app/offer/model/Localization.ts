import {Contact} from "./Contact";

export interface Localization {
  id?: string;
  country: string;
  region: string
  zipCode: string;
  localizationName: string;
}
