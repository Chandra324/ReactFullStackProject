import { useState, useEffect } from "react";
import axios from "axios";
import "./userlist.css";

const UserList = ({users,fetchUsers}) => {
    const handleDelete = async (id) => { //params
      console.log('id',id)
      try {
        await axios.delete(`http://localhost:8080/api/employees/${id}`);//params
        alert("User deleted successfully!");
        fetchUsers(); 
      } catch (error) {
        console.error("Error deleting user:", error);
      }
    };  
    useEffect(() => {
      console.log('ueffect run')
        fetchUsers();
      }, []); //render pass asgrument
      
    return (
      <div className="header1">
        <h2 >Users List</h2>
        <table >
          <thead>
            <tr >
              <th >ID</th>
              <th >First Name</th>
              <th >Last Name</th> 
              <th >Email</th>
              <th >Action</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => ( //  (foreach) itaretion
              <tr key={user.id} className="text-center">
                <td >{user.id}</td>
                <td >{user.firstName}</td>
                <td >{user.lastName}</td>
                <td >{user.email}</td>
                <td >
                  <button
                    onClick={() => handleDelete(user.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };
export default UserList;  