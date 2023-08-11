import { SalesUserState, initialUserState } from "./users.state";

export class AppState{
    allInfo: SalesUserState;
}

export const initialAppState: AppState = {
    allInfo: initialUserState
}

export function getInitalState(): AppState{
    return initialAppState;
}

