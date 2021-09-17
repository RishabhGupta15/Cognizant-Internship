import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quantity-increment',
  templateUrl: './quantity-increment.component.html',
  styleUrls: ['./quantity-increment.component.css']
})
export class QuantityIncrementComponent implements OnInit {
  show: boolean = false;
  text: string = 'Click Me button clicked!';
  dispNum: number = 0;
  constructor() { }

  ngOnInit(): void {
  }

  changeShow(){
    this.show = !this.show;
  }

  incrementByOne(){
    this.dispNum += 1;
  }

  decrementByOne(){
    this.dispNum -= 1;
  }

}
