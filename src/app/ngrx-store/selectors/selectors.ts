import { state } from "@angular/animations";
import { AppState } from "../state/app.state";
import { SalesUserState } from "../state/users.state";
import { createSelector } from "@ngrx/store";


const userSelectors = ( state:AppState ) => state.allInfo;

export const getUser = createSelector(
    userSelectors,
    (state: SalesUserState) => state.user
)

export const getTariff = createSelector(
    userSelectors,
    (state: SalesUserState) => state.tariff
)

export const getCity = createSelector(
    userSelectors,
    (state: SalesUserState) => state.city
)

export const getRouter = createSelector(
    userSelectors,
    (state: SalesUserState) => state.router
)