export class ITariff{
    id:number;
    name: string;
    speed: string;
    priceList:[
        {
            id:number;
            price:string;
            contractDuration: number;
            oneTime: boolean;
            name:string;
            discount: number
        }
    ]
}