export interface IEmployee{
  id:number,
  name:String,
  birthday:string,
  idCard:string,
  salary:number,
  phone:string,
  email:string,
  address:string,
  positionId:number,
  eductionId:number,
  divisionId:number,
  username:string
}

export const employees:IEmployee[]=[
  {
    id: 1,
    name: "thi uyen",
    birthday: "05/05/2000",
    idCard: "78945612",
    salary: 2500,
    phone: "093938292",
    email: "uyen@gmail.com",
    address: "Quảng Ngãi",
    positionId: 1,
    eductionId: 2,
    divisionId: 1,
    username: "uyen"
  },
  {
    id: 2,
    name: "minh đạt",
    birthday: "12/09/1999",
    idCard: "78945612",
    salary: 100000,
    phone: "093938992",
    email: "dat@gmail.com",
    address: "Đà lạt",
    positionId: 2,
    eductionId: 2,
    divisionId: 1,
    username: "dat"
  },  {
    id: 3,
    name: "thuý loan",
    birthday: "10/07/2000",
    idCard: "71236982",
    salary: 3500,
    phone: "093944292",
    email: "loan@gmail.com",
    address: "Bình Định",
    positionId: 1,
    eductionId: 2,
    divisionId: 1,
    username: "loan"
  }

]
