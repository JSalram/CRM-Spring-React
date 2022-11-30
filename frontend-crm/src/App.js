import "./App.css";
import Login from "./components/Login";
import Home from "./components/Home";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";

function App() {
  const [data, setData] = useState({
    username: "",
    password: ""
  });

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="" element={<Login props={[data, setData]} />} />
          <Route path="home" element={<Home user={data} />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
