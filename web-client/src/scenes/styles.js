const styles = (theme) => ({
    root: {
      display: "flex",
    },
    modal: {
      display: "flex",
      alignItems: "center",
      justifyContent: "center",
    },
    paper: {
      backgroundColor: theme.palette.background.paper,
      border: "2px solid #000",
      boxShadow: theme.shadows[5],
      padding: theme.spacing(2, 4, 3),
      minWidth: 600,
      minHeight: 300,
    },
    gridListContainer: {
      display: "flex",
      flexWrap: "wrap",
      justifyContent: "space-around",
      overflow: "hidden",
      backgroundColor: theme.palette.background.paper,
      borderRadius: "10px",
    },
    gridList: {
      width: 800,
      height: 450,
    },
    icon: {
      color: "magenta",
    },
    link: {
      textDecoration: "none",
    },
    table: {
      display: "table",
      tableLayout: "fixed",
      width: "100%",
    },
    form: {
      padding: 30,
    },
    progressButton: {
      margin: "50%",
    },
    backdrop: {
      zIndex: theme.zIndex.drawer + 1,
      color: "#fff",
    },
    card: {
      borderRadius: 15,
      backgroundColor: "#b590ca",
      color: theme.palette.primary.contrastText,
      boxShadow: "none",
    },
    content: {
      flexGrow: 1,
      padding: theme.spacing(3),
    },
    formField: {
      padding: theme.spacing(2),
    },
    buttonContainerRight: {
      padding: theme.spacing(2),
      display: "flex",
      justifyContent: "flex-end",
      backgroundColor: "transparent",
      boxShadow: "none",
    },
    buttonReload: {
      marginRight: "20px",
      background: "linear-gradient(45deg, #890089 30%,#602080 90%)",
      borderRadius: 3,
      border: 0,
      color: "white",
      height: 45,
      padding: "0 30px",
      boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    },
    buttonAdd: {
      background: "linear-gradient(45deg, #890089 30%,#602080 90%)",
      borderRadius: 3,
      border: 0,
      color: "white",
      height: 45,
      padding: "0 30px",
      boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    },
    buttonBack: {
      backgroundColor: "magenta",
      color: "#fff",
    },
    formAction: {
      marginTop: 30,
      display: "flex",
      justifyContent: "space-between",
    },
    amountText: {
      color: "#000000a1",
    },
    numberInput: {
      minWidth: 300,
    },
    barChart: {
      background: "linear-gradient(45deg, #B993D6 30%, #8CA6DB 90%)",
    },
    paper: {
      marginTop: theme.spacing(8),
      display: "flex",
      flexDirection: "column",
      alignItems: "center",
    },
    avatar: {
      margin: theme.spacing(1),
      backgroundColor: theme.palette.secondary.main,
    },
    form: {
      width: "100%", // Fix IE 11 issue.
      marginTop: theme.spacing(1),
    },
    submit: {
      margin: theme.spacing(3, 0, 2),
      backgroundColor: "#890089",
    },
    submit: {
      margin: theme.spacing(3, 0, 2),
      color: "#fff",
      backgroundColor: "#890089",
      paddingLeft: 30,
      paddingRight: 30,
      borderRadius: 30,
      width: "100%",
    },
    loginBackground: {
      flex: 1,
    },
    large: {
      large: {
        width: theme.spacing(7),
        height: theme.spacing(7),
      },
    },
  });
  
  export default styles;
  