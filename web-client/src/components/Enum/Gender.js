import React from "react";

export default function Gender(gender) {
  console.log(gender);
  if (gender === 0) {
    return <div>Male</div>;
  } else if (gender === 1) {
    return <div>Female</div>;
  }
}
