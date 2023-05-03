import { Component } from '@angular/core';
import { QuizService } from 'src/app/shared/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent {
  quizs: any;
  score!: number;
  badge!: string;
  constructor(private guizService: QuizService,) {
  }
  ngOnInit() {
    this.reloadData();
    this.score = 8500;
this.badge = this.getBadge(this.score);
  }
  getBadge(score: number): string {
    if (score >= 5000) {
      return 'PLATINUM';
    } else if (score >= 3000) {
      return 'GOLD';
    } else if (score >= 700 ) {
      return 'SILVER';
    } else {
      return 'BRONZE';
    }
  }

  reloadData() {
    this.guizService.getQuizScoreByUser(1).subscribe(data => {
      if (data) {
        console.log("this.quizs,data", data);
      }
    });
    this.guizService.getQuiz().subscribe(data => {
      if (data) {
        this.quizs = data
        console.log(this.quizs);
      }
    });
  }
}
