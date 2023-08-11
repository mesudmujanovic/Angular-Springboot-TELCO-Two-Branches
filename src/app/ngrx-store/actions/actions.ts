import { Action } from "@ngrx/store";
import { City } from "src/app/Interface/city-interface";


export enum _SaveCity{
    AddCity = '[City] Add City'
}

export class AddCity implements Action{
    public readonly type = _SaveCity.AddCity;
    constructor(public payload: any){}
}

export type UserAction = AddCity