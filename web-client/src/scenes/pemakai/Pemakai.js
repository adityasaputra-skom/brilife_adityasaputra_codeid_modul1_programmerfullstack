import React, { Component } from "react";
import MUIDataTable from "mui-datatables";
import { withStyles } from "@material-ui/core/styles";
import { Button, CircularProgress, ButtonGroup } from "@material-ui/core";
import { Assignment as Print } from "@material-ui/icons";
import AddCircleOutlineIcon from "@material-ui/icons/AddCircleOutline";
import { connect } from "react-redux";
import { findAll } from "../../actions/provinsi";
import Page from "../../components/Page";
import styles from "../styles";
class Pemakai extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      total: 0,
      table: {
        sort: "asc",
        size: 20,
        page: 0,
        search: {
          name: "",
        },
      },
      error: null,
    };
  }

  onReload = () => {
    this.reload();
  };

  reload = () => {
    this.props.findAll(this.state.table);
  };

  onRowClick = (rowData) => {
    this.props.history.push(`/pemakai/${rowData[0]}`);
  };

  onAdd = () => {
    this.props.history.push(`/pemakai/add`);
  };

  componentDidMount() {
    this.reload();
  }

  onChangeRowsPerPage = (numbersOfRow) => {
    const { table } = this.state;
    this.setState({ table: { ...table, size: numbersOfRow } });
  };

  componentDidUpdate(prevProps, prevState) {
    const { deleteData, deleteError, error, data } = this.props;
    const { table } = this.state;

    if (prevProps.data !== data) {
      this.setState({ data: data.list, total: data.total });
    } else if (
      prevState.table !== table ||
      prevProps.deleteData !== deleteData
    ) {
      this.reload();
    } else if (deleteError && prevProps.deleteError !== deleteError) {
      this.setState({ error: deleteError });
    } else if (error && prevProps.error !== error) {
      this.setState({ error: error });
    }
  }

  onChangePage = (currentPage) => {
    const { table } = this.state;
    this.setState({ table: { ...table, search: { name: currentPage } } });
  };

  onSearchChange = (searchText) => {
    const { table } = this.state;
    this.setState({ table: { ...table, search: { name: searchText } } });
  };

  onColumnSortChange = (changedColumn, direction) => {
    const { table } = this.state;
    const sort = direction === "descending" ? "desc" : "asc";
    this.setState({ table: { ...table, sort } });
  };

  onRowsDelete = (rowsDeleted) => {
    const { list } = this.props.data;
    const e = list[rowsDeleted.data[0].index];
    this.props.deletedById(e.id);
    return false;
  };

  render() {
    const { classes, loading } = this.props;
    const { data, total, error, table } = this.state;

    const columns = [
      {
        name: "id",
        label: "ID",
        options: {
          sortDirection: table.sort,
        },
      },
      {
        name: "provinsi.name",
        label: "Provinsi",
        options: {
          sort: false,
        },
      },
      {
        name: "kontrasepsi.name",
        label: "Alat Kontrasepsi",
        options: {
          sort: false,
        },
      },
      {
        name: "jumlah",
        label: "Jumlah Pemakai Kontrasepsi",
        options: {
          sort: false,
        },
      },
    ];

    const options = {
      serverSide: true,
      page: table.page,
      filter: false,
      count: total,
      onRowsDelete: this.onRowsDelete,
      onRowClick: this.onRowClick,
      rowsPerPage: table.size,
      rowsPerPageOptions: [5, 10, 25, 50, 100],
      onChangeRowsPerPage: this.onChangeRowsPerPage,
      onChangePage: this.onChangePage,
      onSearchChange: this.onSearchChange,
      onColumnSortChange: this.onColumnSortChange,
      searchText: table.search.name,
      selectableRows: "single",
      textLabels: {
        body: {
          noMatch: loading ? (
            <CircularProgress />
          ) : (
            "Sorry, no matching records found"
          ),
        },
      },
    };

    return (
      <Page>
        <ButtonGroup
          variant="contained"
          className={classes.buttonContainerRight}
        >
          <Button
            className={classes.buttonReload}
            onClick={this.onReload}
            disabled={loading}
            startIcon={<Print />}
          >
            Report
          </Button>
          <Button
            className={classes.buttonAdd}
            onClick={this.onAdd}
            startIcon={<AddCircleOutlineIcon />}
          >
            Add
          </Button>
        </ButtonGroup>
        <MUIDataTable
          title={"List Pemakai Kontrasepsi"}
          data={data}
          columns={columns}
          options={options}
        />
      </Page>
    );
  }
}

const mapStateToProps = (state) => ({
  data: state.findProvs.data,
  error: state.findProvs.error,
  loading: state.findProvs.loading,
});

const mapDispatchToProps = {
  findAll,
};

export default withStyles(styles, { withTheme: true })(
  connect(mapStateToProps, mapDispatchToProps)(Pemakai)
);
