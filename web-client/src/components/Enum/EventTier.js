import React from "react";

export default function EventTier(tier) {
  if (tier === 0) {
    return <div>BRONZE</div>;
  } else if (tier === 1) {
    return <div>SILVER</div>;
  } else if (tier === 2) {
    return <div>GOLD</div>;
  } else if (tier === 3) {
    return <div>PLATINUM</div>;
  }
}
