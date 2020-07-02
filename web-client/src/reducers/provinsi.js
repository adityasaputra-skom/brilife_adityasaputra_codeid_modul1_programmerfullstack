import {
    FIND_PROVS_FAILURE,
    FIND_PROVS_REQUEST,
    FIND_PROVS_SUCCESS
  } from "../actions/constants";

  const defaultState = {
    data: null,
    loading: false,
    error: null,
  };

  export function Provs(state = defaultState, action) {
    switch (action.type) {
      case FIND_PROVS_REQUEST:
        return {
          ...state,
          loading: true,
          error: null,
        };
      case FIND_PROVS_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null,
        };
      case FIND_PROVS_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error,
        };
      default:
        return state;
    }
  }