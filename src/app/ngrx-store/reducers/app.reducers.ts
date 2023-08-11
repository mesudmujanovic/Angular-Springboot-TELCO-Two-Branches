import { ActionReducerMap } from "@ngrx/store";
import { AppState } from "../state/app.state";
import { userReducer } from "./reducers";

export const appReducers: ActionReducerMap<AppState, any> = {
    allInfo: userReducer
}