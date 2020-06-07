import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'FilterlistCity',
})
export class FilterlistCity implements PipeTransform {
  transform(value: any, args?: any): any {
    if (!args || args.length === 0) {
      return value;
    }

    return value.filter((val) =>
      args.some((item) => {
        return item.includes(val.localization.localizationName);
      })
    );
  }
}
