import { Component } from '@angular/core';

@Component({
  selector: 'app-comment-customer',
  templateUrl: './comment-customer.component.html',
  styleUrls: ['./comment-customer.component.css']
})
export class CommentCustomerComponent {

  comments = [
    { name: "Mesud", comment: "Vrlo dobro", stars: [2] },
    { name: "Emir", comment: "Dobro", stars: [3] },
    { name: "Sara", comment: "Odlično", stars: [4] },
    { name: "Ana", comment: "Super" },
  ];

 currentIndex = 0;

 slideWidth = 300;

  constructor(){
  }


  prevSlide() {
    this.currentIndex = Math.max(this.currentIndex - 1, 0);
  }
 
  nextSlide() {
    this.currentIndex = Math.min(this.currentIndex + 1, this.comments.length - 1);
  }
 
  selectedRating = 0;
  stars = [1, 2, 3, 4, 5];
 
  rate(rating: number) {
    this.selectedRating = rating;
  }

}
