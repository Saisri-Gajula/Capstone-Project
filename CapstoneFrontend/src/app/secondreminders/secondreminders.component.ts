import { Component } from '@angular/core';
import { Reminders } from '../reminders';
import { DunningProcessService } from '../dunning-process.service';

@Component({
  selector: 'app-secondreminders',
  templateUrl: './secondreminders.component.html',
  styleUrls: ['./secondreminders.component.css']
})
export class SecondremindersComponent {
  reminders:Reminders[]=[];
  constructor(private dunningService: DunningProcessService){}
  
   
  ngOnInit(){
    this.secondreminders();
  }
  secondreminders(){
    this.dunningService.secondreminders().subscribe(res => {
      console.log(res);
      this.reminders= res;
    });
  }
}
