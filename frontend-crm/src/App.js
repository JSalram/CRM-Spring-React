import "./App.css";
import Login from "./components/Login";
import Home from "./components/Home";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";

function App() {
  const [user, setUser] = useState({
    username: "",
    password: ""
  });

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="" element={<Login props={[user, setUser]} />} />
          <Route path="home" element={<Home />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
