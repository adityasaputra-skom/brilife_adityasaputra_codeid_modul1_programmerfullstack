import Provinsi from "../scenes/provinsi";
import Pemakai from "../scenes/pemakai";
import Kontrasepsi from "../scenes/kontrasepsi/Kontrasepsi";

const { default: Home } = require("../scenes/Home");


const routes = [
    {
        path: "/",
        component: Pemakai,
        exact: true
    },{
        path: "/provinsi",
        component: Provinsi,
        exact: true
    }, {
        path: "/kontrasepsi",
        component: Kontrasepsi,
        exact: true
    }
]

export default routes;