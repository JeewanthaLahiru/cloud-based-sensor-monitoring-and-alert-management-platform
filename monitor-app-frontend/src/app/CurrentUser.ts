export class CurrentUser{
    
    constructor(
        public email:string,
        public id:string,
        public name:string,
        public notification:string,
        public password:string,
        public phone:string
        ){}
}