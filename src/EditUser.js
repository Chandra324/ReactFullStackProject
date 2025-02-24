import { useState } from "react";
import axios from "axios";
import "./edituser.css";


const EditUser = ({ fetchUsers  }) => {
    const [formData, setFormData] = useState({
      id: '',
      firstName: "",
      lastName: "",
      email: "",
    });
    const [error, setError] = useState("");
  
    const handleChange = (e) => {
      setFormData({ ...formData, [e.target.name]: e.target.value });
    };
  
    const handleEdit = async () => {
      //alert('id is required')
      if (!formData.id) {
        // setError("ID is required for editing");
        return;
      }
    
      try {
        const updatedData = {
          firstName: formData.firstName,
          lastName: formData.lastName,
          email: formData.email,
        };
        await axios.put(`http://localhost:8080/api/employees/${formData.id}`, updatedData);
        alert("User updated successfully!");
        fetchUsers();
        setFormData({ id:'', firstName: "", lastName: "", email: "" })
      } catch (error) {
        console.error("Error updating user:", error);
      }
    };
  
    return (
      <div className="nav">
        <h2 >Edit User</h2>
        {error && <p >{error}</p>}
        <input
          type="number"
          name="id"
          placeholder="User ID"
          value={formData.id}
          onChange={handleChange}
        />
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          value={formData.firstName}
          onChange={handleChange}
         
        />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          value={formData.lastName}
          onChange={handleChange}
         
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
         
        />
        <button
          onClick={handleEdit}
        >
          Edit User
        </button>
      </div>
    );
  };
  export default EditUser