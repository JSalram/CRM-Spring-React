import "../styles/Home.css";
import Navbar from "./Navbar";
import HomePage from "./pages/HomePage";
import Opportunities from "./pages/Opportunities";
import NewOpportunity from "./pages/NewOpportunity";
import NewContact from "./pages/NewContact";
import { Routes, Route, useNavigate } from "react-router-dom";
import Clients from "./pages/Clients";
import { useEffect } from "react";
import APIService from "../services/APIService";

export default function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    APIService.checkUser()
      .then()
      .catch(() => {
        navigate("/")
      });
  }, []);

  return (
    <div>
      <div className="navbar">
        <Navbar />
      </div>
      <div className="content">
        <h1>Opportunity App</h1>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/opportunities" element={<Opportunities />} />
          <Route path="/opportunities/:id/new" element={<NewContact />} />
          <Route path="/opportunities/new" element={<NewOpportunity />} />
          <Route path="/clients" element={<Clients />} />
        </Routes>
      </div>
    </div>
  );
}
