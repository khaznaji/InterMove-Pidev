export class User {
    id:number; 
    public events: Event[] = [];
    constructor(id : number){
        this.id = id;
    }
}
