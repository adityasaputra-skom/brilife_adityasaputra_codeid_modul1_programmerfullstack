import {
    FIND_PKONTRASEPSIS_FAILURE,
    FIND_PKONTRASEPSIS_SUCCESS,
    FIND_PKONTRASEPSIS_REQUEST,
    DELETE_PKONTRASEPSI_REQUEST,
    DELETE_PKONTRASEPSI_SUCCESS,
    DELETE_PKONTRASEPSI_FAILURE,
    SAVE_PKONTRASEPSI_FAILURE,
    SAVE_PKONTRASEPSI_REQUEST,
    SAVE_PKONTRASEPSI_SUCCESS,
    FIND_PKONTRASEPSI_REQUEST,
    FIND_PKONTRASEPSI_SUCCESS,
    FIND_PKONTRASEPSI_FAILURE,
  } from "../actions/constants";


  
  const defaultState = {
    data: null,
    loading: false,
    error: null,
    saveSucces: null
  };
  
  export function savePKontrasepsi(state = defaultState, action) {
    switch (action.type) {
      case SAVE_PKONTRASEPSI_REQUEST:
        return {
          ...state,
          loading: true,
          data: null
        };
      case SAVE_PKONTRASEPSI_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case SAVE_PKONTRASEPSI_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  
  export function deletedPKontrasepsiById(state = defaultState, action) {
    switch (action.type) {
      case DELETE_PKONTRASEPSI_REQUEST:
        return {
          ...state,
          loading: true,
          data: null
        };
      case DELETE_PKONTRASEPSI_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case DELETE_PKONTRASEPSI_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  
  export function findPKontrasepsiById(state = defaultState, action) {
    switch (action.type) {
      case FIND_PKONTRASEPSI_REQUEST:
        return {
          ...state,
          loading: true,
          data: null
        };
      case FIND_PKONTRASEPSI_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case FIND_PKONTRASEPSI_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  
  export function findPemakaiKontrasepsis(state = defaultState, action) {
    switch (action.type) {
      case FIND_PKONTRASEPSIS_REQUEST:
        return {
          loading: true,
          data: null
        };
      case FIND_PKONTRASEPSIS_SUCCESS:
        return {
          data: action.data,
          loading: false,
          error: null
        };
      case FIND_PKONTRASEPSIS_FAILURE:
        return {
          ...state,
          loading: false,
          error: action.error
        };
      default:
        return state;
    }
  }
  