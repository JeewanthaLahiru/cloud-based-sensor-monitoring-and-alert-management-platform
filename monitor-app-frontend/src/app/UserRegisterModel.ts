export class UserRegisterModel{
    constructor(
        public name:string,
        public email:string,
        public password:string,
        public phone:string,
        public notification:string
    ){}
}