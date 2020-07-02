import React, { Component } from "react";
import Page from "../Page";
import Login from "../../scenes/login/Login";
export default function Display(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <Page />;
  }
  return <Login />;
}
