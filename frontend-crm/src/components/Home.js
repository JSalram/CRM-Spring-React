import APIService from "../services/APIService";
import { useEffect, useState } from "react";

export default function Home({ user }) {
  const [opportunities, setOpportunities] = useState([]);

  useEffect(() => {
    console.log(document.cookie);
    APIService.getOpportunities(user).then(({data}) => {
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
