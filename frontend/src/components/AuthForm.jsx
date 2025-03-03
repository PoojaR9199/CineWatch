import { useState } from "react";

const AuthForm = () => {
  const [isLogin, setIsLogin] = useState(false);

  return (
    <div className="auth-form">
      <h2>{isLogin ? "Sign in to your account" : "Create an account"}</h2>

      <form>
        {/* Email Field */}
        <div className="input-group">
          <label>Email</label>
          <input type="email" placeholder="Enter your email" required />
        </div>

        {/* Password Field */}
        <div className="input-group">
          <label>Password</label>
          <input type="password" placeholder="Enter your password" required />
        </div>

        {/* Confirm Password (Only for Register) */}
        {!isLogin && (
          <div className="input-group">
            <label>Confirm Password</label>
            <input
              type="password"
              placeholder="Confirm your password"
              required
            />
          </div>
        )}

        {/* Submit Button */}
        {isLogin ? (
          <button type="submit">Login</button>
        ) : (
          <button type="submit">Register</button>
        )}
      </form>

      {/* Toggle Link */}
      <p className="toggle-text">
        {isLogin ? "Don't have an account?" : "Already have an account?"}
        <span onClick={() => setIsLogin(!isLogin)}>
          {isLogin ? " Sign up" : " Log in"}
        </span>
      </p>
    </div>
  );
};

export default AuthForm;
