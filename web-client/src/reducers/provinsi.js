import {
  FIND_PROVS_FAILURE,
  FIND_PROVS_SUCCESS,
  FIND_PROVS_REQUEST,
  DELETE_PROV_REQUEST,
  DELETE_PROV_SUCCESS,
  DELETE_PROV_FAILURE,
  SAVE_PROV_FAILURE,
  SAVE_PROV_REQUEST,
  SAVE_PROV_SUCCESS,
  FIND_PROV_REQUEST,
  FIND_PROV_SUCCESS,
  FIND_PROV_FAILURE,
  } from "../actions/constants";

  const defaultState = {
    data: null,
    loading: false,
    error: null,
    saveSucces: null
  };
  
  export function saveProvs(state = defaultState, action) {
    switch (action.type) {
      case SAVE_PROV_REQUEST:
        return {
          ...state,
          loading: true,
          data: null
        };
      case SAVE_PROV_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case SAVE_PROV_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  
  export function deletedProvById(state = defaultState, action) {
    switch (action.type) {
      case DELETE_PROV_REQUEST:
        return {
          ...state,
          loading: true,
          data: null
        };
      case DELETE_PROV_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case DELETE_PROV_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  
  export function findProvById(state = defaultState, action) {
    switch (action.type) {
      case FIND_PROV_REQUEST:
        return {
          ...state,
          loading: true,
          data: null
        };
      case FIND_PROV_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case FIND_PROV_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  
  export function findProvs(state = defaultState, action) {
    switch (action.type) {
      case FIND_PROVS_REQUEST:
        return {
          loading: true,
          data: null
        };
      case FIND_PROVS_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case FIND_PROVS_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  