import { combineReducers } from "redux";
import {
  findProvs,
  findProvById,
  deletedProvById,
  saveProvs,
} from "./provinsi";

import {
  savePKontrasepsi,
  deletedPKontrasepsiById,
  findPKontrasepsiById,
  findPemakaiKontrasepsis,
} from "./pemakai";

export default combineReducers({
  findProvs,
  findProvById,
  deletedProvById,
  saveProvs,
  savePKontrasepsi,
  deletedPKontrasepsiById,
  findPKontrasepsiById,
  findPemakaiKontrasepsis,
});
