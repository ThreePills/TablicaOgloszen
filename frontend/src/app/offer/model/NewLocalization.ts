import {Localization} from "./Localization";

export class NewLocalization implements Localization {
  id?: string;
  country: string;
  localizationName: string;
  region: string;
  zipCode: string;

  constructor(id: string, country: string, region: string, zipCode: string, localizationName: string) {
    this.id = id;
    this.country = country;
    this.localizationName = localizationName;
    this.region = region;
    this.zipCode = zipCode;
  }
}
