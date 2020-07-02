import React, { Component } from "react";

export default function Status(status) {
  if (status === 0) {
    return <div>Active</div>;
  } else if (status === 1) {
    return <div>None - Active</div>;
  } else if (status === 2) {
    return <div>Pending</div>;
  } else if (status === 3) {
    return <div>Rejected</div>;
  } else if (status === 3) {
    return <div>Suspended</div>;
  }
}
