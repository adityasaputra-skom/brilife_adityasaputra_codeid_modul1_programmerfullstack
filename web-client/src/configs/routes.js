import Provinsi from "../scenes/provinsi";
import Pemakai from "../scenes/pemakai";
import Kontrasepsi from "../scenes/kontrasepsi/Kontrasepsi";
import PemakaiDetail from "../scenes/pemakai/PemakaiDetail/PemakaiDetail";

const routes = [
    {
        path: "/pemakai/:id",
        component: PemakaiDetail,
        exact: true
    },
    {
        path: "/pemakai/add",
        component: PemakaiDetail,
        exact: true
    },
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