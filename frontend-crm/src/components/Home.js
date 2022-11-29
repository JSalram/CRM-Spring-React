import APIService from "../services/APIService";
import { useEffect, useState } from "react";

export default function Home() {
  const [opportunities, setOpportunities] = useState([]);

  useEffect(() => {
    APIService.getOpportunities().then(({ data }) => {
      console.log(data);
    });
  }, []);

  return (
    <div>
      <h1>Home</h1>
      <p>lorem ipsum</p>
    </div>
  );
}
