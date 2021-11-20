export interface IContract {
  idContract:number,
  idEmployee :number,
  idCustomer:number,
  idService:number,
  dateCreate:string,
  dateEnd:string,
  deposits:number,
  totalMoney:number
}
export const IContract:IContract[]=[
  {
    idContract:1,
    idEmployee :1,
    idCustomer:2,
    idService:2,
    dateCreate:"09/09/2019",
    dateEnd:"08/12/2019",
    deposits:1200,
    totalMoney:1500
  },
  {
    idContract:2,
    idEmployee :1,
    idCustomer:2,
    idService:2,
    dateCreate:"12/01/2019",
    dateEnd:"08/12/2019",
    deposits:1250,
    totalMoney:1520
  },  {
    idContract:3,
    idEmployee :1,
    idCustomer:2,
    idService:2,
    dateCreate:"03/09/2019",
    dateEnd:"08/1/2020",
    deposits:1000,
    totalMoney:1400
  }
]
