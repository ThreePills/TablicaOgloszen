import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'FilterlistTitle'
})
export class FilterlistTitle implements PipeTransform {

  transform(value: any, args?: any): any {
    if(!args)
      return value;
    return value.filter(
      item => item.title.toLowerCase().indexOf(args.toLowerCase()) > -1
    );
  }
}
