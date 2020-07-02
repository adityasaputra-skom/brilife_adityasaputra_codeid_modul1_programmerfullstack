import {
    FIND_PROVS_FAILURE,
    FIND_PROVS_SUCCESS,
    FIND_PROVS_REQUEST
    
  } from "./constants";

  import { instanceAxios } from "../utils/api";

  export const findAll = ({ search, sort = "asc", page = 0, size = 10 } = {}) => (
    dispatch
  ) => {
    dispatch({
      type: FIND_PROVS_REQUEST,
    });
  
    instanceAxios
      .get("provinsi", {
        params: {
          ...search,
          sort,
          page,
          size,
        },
      })
      .then((data) => {
        dispatch(findAudiencesSuccess(data));
      })
      .catch((error) => {
        dispatch(findAudiencesFailure(error));
      });
  };

  function findAudiencesSuccess(data) {
    return {
      type: FIND_PROVS_SUCCESS,
      data: data,
    };
  }
  
  function findAudiencesFailure(error) {
    return {
      type: FIND_PROVS_FAILURE,
      error: error,
    };
  }