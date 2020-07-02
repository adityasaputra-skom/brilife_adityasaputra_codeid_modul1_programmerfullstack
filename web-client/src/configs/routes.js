import Provinsi from "../scenes/provinsi";
import Pemakai from "../scenes/pemakai";

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
    }
]

export default routes;