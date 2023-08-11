import { SalesUserState, initialUserState } from '../state/users.state';
import { UserAction, _SaveCity } from '../actions/actions';


export const userReducer =
( state = initialUserState,
  action: UserAction ): SalesUserState =>{
         
        switch(action.type){
            case _SaveCity.AddCity:
                return{
                    ...state,
                    city: action.payload
                }
                break;
            
        }
  }