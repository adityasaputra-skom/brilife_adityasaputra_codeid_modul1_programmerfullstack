import { combineReducers } from "redux";
import {
  findProvs,
  findProvById,
  deletedProvById,
  saveProvs,
} from "./provinsi";
export default combineReducers({
  findProvs,
  findProvById,
  deletedProvById,
  saveProvs
});
