
import { useState, useEffect } from "react";
import axios from "axios";
import "./register.css";

const Register = ({ fetchUsers,  }) => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });
  // Update filed name based user type input filed
  const handleChange = (e) => {
    setFormData({...formData,[e.target.name]: e.target.value }); //spread opa
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!formData.firstName || !formData.lastName || !formData.email) {
      return alert('all felds are reuired');
    }
  
    try {
      await axios.post("http://localhost:8080/api/employees", formData);//body
      alert("Registration successful!");
      fetchUsers(); // Fetch updated users list
      setFormData({  firstName: "", lastName: "", email: "" }); // Reset form with updated ID
    } catch (error) {
      console.error("Error registering:", error);
    }
  };

  return (
    <div className="header">
      <h2>Register</h2>
      
      <form onSubmit={handleSubmit}>
      
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          value={formData.firstName}
          onChange={handleChange}
        />
        <br />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          value={formData.lastName}
          onChange={handleChange}
        />
        <br />
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
        />
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Register;
