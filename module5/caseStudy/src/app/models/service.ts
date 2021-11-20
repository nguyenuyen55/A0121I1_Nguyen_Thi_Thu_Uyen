export interface IService {
  idService:number,
  name:string,
  area:number,
  floors:number,
  maxPeople:number,
  constRent:number,
  idRent:number,
  status:string
}
export const services : IService[]=[
  {
    idService:100,
    name:"valli",
    area:100,
    floors:2,
    maxPeople:4,
    constRent:150000,
    idRent:1,
    status:"chưa thuê"
  },
  {
    idService:101,
    name:"house",
    area:120,
    floors:1,
    maxPeople:2,
    constRent:120000,
    idRent:2,
    status:"đã được thuê"
  },
  {
    idService:102,
    name:"resort",
    area:500,
    floors:3,
    maxPeople:10,
    constRent:880000,
    idRent:1,
    status:"đã được thuê"
  }
]
