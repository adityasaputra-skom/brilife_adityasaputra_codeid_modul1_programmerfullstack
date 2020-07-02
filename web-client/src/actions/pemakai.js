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
  } from "./constants";

  import { instanceAxios } from "../utils/api";

  
  export const deletedById = id => dispatch => {
    dispatch({ type: DELETE_PKONTRASEPSI_REQUEST });
    instanceAxios
      .delete(`pemakai/${id}`)
      .then(data => {
        dispatch(deletedSuccess(data));
      })
      .catch(error => {
        dispatch(deletedItemFailure(error));
      });
  };
  
  export const saveProvs = ({ id, provinsi, kontrasepsi, jumlah }) => dispatch => {
    dispatch({ type: SAVE_PKONTRASEPSI_REQUEST });
  
    const request = id
      ? instanceAxios.put(`pemakai/${id}`, { id, provinsi, kontrasepsi, jumlah})
      : instanceAxios.post(`pemakai`, { provinsi, kontrasepsi, jumlah });
    request
      .then(data => {
        dispatch(saveSuccess(data));
      })
      .catch(error => {
        dispatch(saveFailure(error));
      });
  };
  
  export const findProvById = id => dispatch => {
    dispatch({ type: FIND_PKONTRASEPSI_REQUEST });
    instanceAxios
      .get(`pemakai/${id}`)
      .then(data => {
        dispatch(findByIdSucces(data));
      })
      .catch(error => {
        dispatch(findByIdFailure(error));
      });
  };
  
  
export const findAll = ({ search, sort = "asc", page = 0, size = 10 } = {}) => (
  dispatch
) => {
  dispatch({
    type: FIND_PKONTRASEPSIS_REQUEST
  });

  instanceAxios
    .get("pemakai", {
      params: {
        ...search,
        sort,
        page,
        size
      }
    })
    .then((data) => {
      dispatch(findAllSucces(data));
      
    })
    .catch((error) => {
      dispatch(findAllFailure(error));
    });
};

  
  function findByIdSucces(data) {
    return {
      type: FIND_PKONTRASEPSI_SUCCESS,
      data: data
    };
  }
  
  function findByIdFailure(error) {
    return {
      type: FIND_PKONTRASEPSI_FAILURE,
      error: error
    };
  }
  function findAllSucces(data) {
    return {
      type: FIND_PKONTRASEPSIS_SUCCESS,
      data: data
    };
  }
  
  function findAllFailure(error) {
    return {
      type: FIND_PKONTRASEPSIS_FAILURE,
      error: error
    };
  }
  
  function deletedSuccess(data) {
    return {
      type: DELETE_PKONTRASEPSI_SUCCESS,
      data: data
    };
  }
  
  function deletedItemFailure(error) {
    return {
      type: DELETE_PKONTRASEPSI_FAILURE,
      error: error
    };
  }
  
  function saveFailure(error) {
    return {
      type: SAVE_PKONTRASEPSI_FAILURE,
      error: error
    };
  }
  
  function saveSuccess(data) {
    return {
      type: SAVE_PKONTRASEPSI_SUCCESS,
      data: data
    };
  }
  