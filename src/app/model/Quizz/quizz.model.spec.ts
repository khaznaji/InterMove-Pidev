import { identity } from 'rxjs';
import { Quizz } from './quizz.model';
import { User } from '../User/user';
import { Domain } from './domain';

describe('Quiz', () => {
  it('should create an instance', () => {
    expect(new Quizz()).toBeTruthy();
  });
});
