import "../styles/Home.css";
import Navbar from "./Navbar";
import HomePage from "./pages/HomePage";
import Opportunities from "./pages/Opportunities";
import NewOpportunity from "./pages/NewOpportunity";
import { Routes, Route } from "react-router-dom";
import CookiesService from "../services/CookiesService";

export default function Home() {
  if (!CookiesService.getUserId()) return null;

  return (
    <div className="row">
      <div className="navbar">
        <Navbar />
      </div>
      <div className="content">
        <h1>Opportunity App</h1>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/opportunities" element={<Opportunities />} />
          <Route path="/opportunities/new" element={<NewOpportunity />} />
        </Routes>
      </div>
    </div>
  );
}
