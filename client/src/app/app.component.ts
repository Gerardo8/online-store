import { Component, OnInit } from '@angular/core';
import { ColorService } from './shared/service/color.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  colors: any;

  constructor(private colorService: ColorService) {}

  ngOnInit() {
    this.colorService.getColors()
    .subscribe(colors => this.colors = colors);
  }
}
