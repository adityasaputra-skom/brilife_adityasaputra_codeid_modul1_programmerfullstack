const { default: Home } = require("../scenes/Home");


const routes = [
    {
        path: "/",
        component: Home,
        exact: true
    }
]

export default routes;