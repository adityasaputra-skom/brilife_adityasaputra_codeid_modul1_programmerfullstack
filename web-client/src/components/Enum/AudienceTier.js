import React from "react";

export default function AudienceTier({ audienceTier }) {
  if (audienceTier === 0) {
    return <div>BRONZE</div>;
  } else if (audienceTier === 1) {
    return <div>SILVER</div>;
  } else if (audienceTier === 2) {
    return <div>GOLD</div>;
  } else if (audienceTier === 3) {
    return <div>PLATINUM</div>;
  }
}
