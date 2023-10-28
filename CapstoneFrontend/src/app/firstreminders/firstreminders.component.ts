import { Component } from '@angular/core';
import { Reminders } from '../reminders';
import { DunningProcessService } from '../dunning-process.service';

@Component({
  selector: 'app-firstreminders',
  templateUrl: './firstreminders.component.html',
  styleUrls: ['./firstreminders.component.css']
})
export class FirstremindersComponent {
  reminders:Reminders[]=[];
  constructor(private dunningService: DunningProcessService){}
  
   
  ngOnInit(){
    this.firstreminders();
  }

  firstreminders(){
    this.dunningService.firstreminders().subscribe(res => {
      console.log(res);
      this.reminders= res;
    });
  }
}
