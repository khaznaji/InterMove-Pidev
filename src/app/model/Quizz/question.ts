export class Question {
  id!: number;
  question!: string;
  type!: string[];
  questionNote!: number;



  responsses!: string[];
  responses!: string[];
  correctResponsesIndex!: number[];
  quiz_id!: number;


  studentResponses!: Response[];


}
