import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import AuthScreen from "../pages/AuthScreen";
import HomePage from "../pages/HomePage";

const isAuthenticated = false; // Update this dynamically

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        {/* If authenticated, show HomePage; otherwise, redirect to /auth */}
        <Route
          path="/"
          element={isAuthenticated ? <HomePage /> : <Navigate to="/auth" />}
        />

        {/* AuthScreen accessible only if NOT authenticated */}
        <Route
          path="/auth"
          element={!isAuthenticated ? <AuthScreen /> : <Navigate to="/" />}
        />

        {/* Catch-all Route */}
        <Route
          path="*"
          element={<Navigate to={isAuthenticated ? "/" : "/auth"} />}
        />
      </Routes>
    </Router>
  );
};

export default AppRoutes;
