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
    
  } from "./constants";

  import { instanceAxios } from "../utils/api";

  export const deletedById = id => dispatch => {
    dispatch({ type: DELETE_PROV_REQUEST });
    instanceAxios
      .delete(`provinsi/${id}`)
      .then(data => {
        dispatch(deletedSuccess(data));
      })
      .catch(error => {
        dispatch(deletedItemFailure(error));
      });
  };
  
  export const saveProvs = ({ id, name }) => dispatch => {
    dispatch({ type: SAVE_PROV_REQUEST });
  
    const request = id
      ? instanceAxios.put(`provinsi/${id}`, { id, name })
      : instanceAxios.post(`provinsi`, { name });
    request
      .then(data => {
        dispatch(saveSuccess(data));
      })
      .catch(error => {
        dispatch(saveFailure(error));
      });
  };
  
  export const findProvById = id => dispatch => {
    dispatch({ type: FIND_PROV_REQUEST });
    instanceAxios
      .get(`provinsi/${id}`)
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
    type: FIND_PROVS_REQUEST
  });

  instanceAxios
    .get("provinsi", {
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
      type: FIND_PROV_SUCCESS,
      data: data
    };
  }
  
  function findByIdFailure(error) {
    return {
      type: FIND_PROV_FAILURE,
      error: error
    };
  }
  function findAllSucces(data) {
    return {
      type: FIND_PROVS_SUCCESS,
      data: data
    };
  }
  
  function findAllFailure(error) {
    return {
      type: FIND_PROVS_FAILURE,
      error: error
    };
  }
  
  function deletedSuccess(data) {
    return {
      type: DELETE_PROV_SUCCESS,
      data: data
    };
  }
  
  function deletedItemFailure(error) {
    return {
      type: DELETE_PROV_FAILURE,
      error: error
    };
  }
  
  function saveFailure(error) {
    return {
      type: SAVE_PROV_FAILURE,
      error: error
    };
  }
  
  function saveSuccess(data) {
    return {
      type: SAVE_PROV_SUCCESS,
      data: data
    };
  }
  