import { DRAWER_WIDTH } from "./constants";

const styles = (theme) => ({
  root: {
    display: "flex",
  },
  appTitle: {
    fontFamily: "Sofia",
    marginRight: 20,
  },
  link: {
    color: "#9400D3",
    textDecoration: "none",
  },
  isActive: {
    backgroundColor: "bisque",
    color: "#9400D3",
    textDecoration: "none",
  },
  primaryIcon: {
    color: "#9400D3",
  },
  appBar: {
    background: "linear-gradient(45deg, #890089 30%, #602080 90%)",
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    marginLeft: DRAWER_WIDTH,
    width: `calc(100% - ${DRAWER_WIDTH}px)`,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginRight: 36,
  },
  hide: {
    display: "none",
  },
  drawer: {
    width: DRAWER_WIDTH,
    flexShrink: 0,
    whiteSpace: "nowrap",
  },
  drawerOpen: {
    width: DRAWER_WIDTH,
    boxShadow: "0 3px 5px 2px #890089",
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  drawerClose: {
    border: 0,
    borderRadius: 3,
    boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    overflowX: "hidden",
    width: theme.spacing(7) + 1,
    [theme.breakpoints.up("sm")]: {
      width: theme.spacing(9) + 1,
    },
  },
  toolbar: {
    display: "flex",
    alignItems: "center",
    justifyContent: "flex-end",
    padding: theme.spacing(0, 1),
    ...theme.mixins.toolbar,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
    marginLeft: 10,
    marginRight: 10,
  },
  breadcrumbCard: {
    marginBottom: 25,
    backgroundColor: "#890089",
  },
  mybreadcrumb: {
    color: "white",
  },
  linkBreadcrumb: {
    color: "white",
    textDecoration: "none",
  },
});

export default styles;
