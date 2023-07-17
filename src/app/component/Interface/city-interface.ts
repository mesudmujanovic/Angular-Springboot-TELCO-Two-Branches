import { Address } from './address-interface';
export interface City{
    id: number;
    name: string;
    addressDtoList:Address[];
}