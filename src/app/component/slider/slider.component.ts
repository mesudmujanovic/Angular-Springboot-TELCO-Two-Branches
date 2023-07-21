import { Component } from '@angular/core';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.css']
})
export class SliderComponent {

  divs = [
    { title: 'Div 1', content: 'Sadržaj za div 1', price:'222$' },
    { title: 'Div 2', content: 'Sadržaj za div 2', price:'12$' },
    { title: 'Div 3', content: 'Sadržaj za div 3', price:'22$' },
    { title: 'Div 4', content: 'Sadržaj za div 4', price:'122$' },
    { title: 'Div 5', content: 'Sadržaj za div 5', price:'41$' },
    { title: 'Div 6', content: 'Sadržaj za div 6', price:'90$' },
  ];
  currentIndex = 0;

  constructor() { }

  ngOnInit(): void {
  }

  prevSlide() {
    if (this.currentIndex > 0) {
      this.currentIndex--;
    }
  }

  nextSlide() {
    if (this.currentIndex < this.divs.length - 3) {
      this.currentIndex++;
    }
  }

  isActive(index: number): boolean {
    return index === this.currentIndex +1;
  }

}
