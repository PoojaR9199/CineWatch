import AuthForm from "../components/AuthForm";
import "./AuthScreen.css"; // Import styles
import moviebg from "../assets/moviebg1.jpg";

const AuthScreen = () => {
  return (
    <div className="auth-container">
      {/* Left Side */}
      <div className="auth-image">
        <img src={moviebg} alt="Cinema Background" />
        <div className="auth-overlay">
          <h1>Welcome.</h1>
          <p>Begin your cinematic adventure now with our ticketing platform!</p>
        </div>
      </div>

      {/* Right Side (Login/Register Form) */}
      <div className="auth-form-container">
        <AuthForm />
      </div>
    </div>
  );
};

export default AuthScreen;
