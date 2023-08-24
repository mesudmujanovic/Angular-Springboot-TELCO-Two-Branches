import { ITariff } from "src/app/Interface/ITariff";
import { UserJWT } from "src/app/Interface/UserJWT";
import { City } from "src/app/Interface/city-interface";
import { IRouters } from "src/app/Interface/iRouters";


export class SalesUserState{
    city: any;
    user: UserJWT;
    tariff: ITariff;
    router: IRouters;
}

export const initialUserState: SalesUserState ={
    city: [],
    user:{
        id:0,
        username:'',
        password: "1"
    },
    tariff:{
        id:0,
        name: '',
        speed: '',
        priceList:[
            {
                id:0,
                price:'',
                contractDuration: 0,
                oneTime: false,
                name:'',
                discount: 0,
            }
        ]   
    },
    router:{
        id: 0,
        description:'',
        price:0
    }
}