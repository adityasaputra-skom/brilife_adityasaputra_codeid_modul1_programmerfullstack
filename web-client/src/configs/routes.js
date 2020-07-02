import Provinsi from "../scenes/provinsi";

const { default: Home } = require("../scenes/Home");


const routes = [
    {
        path: "/",
        component: Home,
        exact: true
    },{
        path: "/provinsi",
        component: Provinsi,
        exact: true
    }
]

export default routes;