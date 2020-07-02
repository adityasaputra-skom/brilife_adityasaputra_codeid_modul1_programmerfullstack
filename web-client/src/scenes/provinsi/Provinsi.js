import React, { Component } from 'react';
import MUIDataTable from "mui-datatables";
import { Button, ButtonGroup, CircularProgress } from "@material-ui/core";
import { withStyles } from "@material-ui/core/styles";
import { Cached as ReloadIcon } from "@material-ui/icons";
import { connect } from "react-redux";
import { findAll, deletedById } from "../../actions/provinsi";
import Page from "../../components/Page";
import styles from "../styles";
class Provinsi extends Component {
    constructor(props) {
        super(props);
        this.state = {
          data: [],
          total: 0,
          params: {
            search: { name: "" },
            sort: "asc",
            page: 0,
            size: 10,
          },
          error: null,
          rowsSelected: [],
        };
      }

      componentDidMount() {
        this.reload();
      }
    
      reload() {
        this.props.findAll(this.state.params);
      }
    
      componentDidUpdate(prevProps, prevState) {
        const { data } = this.props;
    
        if (prevProps.data !== data) {
          this.setState({ data: data.list, total: data.total });
        } 
      }
    
      onReload = () => {
        this.reload();
      };
    
      onChangePage = (currentPage) => {
        const { params } = this.state;
        this.setState({ params: { ...params, page: currentPage } });
      };
    
      onChangeRowsPerPage = (numberOfRows) => {
        const { params } = this.state;
        this.setState({ params: { ...params, size: numberOfRows } });
      };
    
      onSearchChange = (searchText) => {
        const { params } = this.state;
        this.setState({ params: { ...params, search: { name: searchText } } });
      };
    
      onColumnSortChange = (changedColumn, direction) => {
        const { params } = this.state;
        const sort = direction === "descending" ? "desc" : "asc";
        this.setState({ params: { ...params, sort } });
      };
    
      isRowSelectable = (index) => {
        const { data } = this.state;
        if (data[index]) {
          return data[index].isUsed ? false : true;
        } else {
          return false;
        }
      };
    
      onRowsSelect = (rowsSelected, allRows) => {
        const selected = allRows.map((item) => item.index);
        this.setState({
          rowsSelected: selected,
        });
      };
    render() { 
        const { loading } = this.props;
        const { data, total, params } = this.state;
        
        const columns = [
            {
              name: "id",
              label: "ID",
              options: {
                sortDirection: params.sort,
              },
            },
            {
              name: "nama",
              label: "Name",
              options: {
                sort: false,
              },
            },
          ];

          const options = {
            serverSide: true,
            page: params.page,
            count: total,
            rowsPerPage: params.size,
            rowsPerPageOptions: [5, 10, 15, 25, 30],
            filter: false,
            isRowSelectable: this.isRowSelectable,
            searchText: params.search.name,
            onChangePage: this.onChangePage,
            onChangeRowsPerPage: this.onChangeRowsPerPage,
            onSearchChange: this.onSearchChange,
            onColumnSortChange: this.onColumnSortChange,
            onRowsSelect: this.onRowsSelect,
            responsive: "scroll",
            textLabels: {
              body: {
                noMatch: loading ? (
                  <CircularProgress />
                ) : (
                  "Sorry, not match records not found"
                ),
              },
            },
          };
        return ( 
            <Page>
                <MUIDataTable
                title={"List Provinsi"}
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
    loading: state.findProvs.loading
  });
  
  const mapDispatchToProps = {
    findAll, deletedById
  };
  
  export default withStyles(styles, { withTheme: true })(
    connect(mapStateToProps, mapDispatchToProps)(Provinsi)
  );
  