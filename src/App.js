import { useEffect, useState } from "react";
import EditUser from "./EditUser";
import Register from "./Register";
import UserList from "./UserList";
import axios from "axios"
  
 const App = () => {          
  const [users, setUsers] = useState([]);    

  const fetchUsers = async () => {  
    try {
      console.log('calling api')
  const getData=await axios.get(`http://localhost:8080/api/employees`);
  console.log('getData',getData)   
    setUsers(getData.data||[])    
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };
  return (
    <div> 
      <Register fetchUsers={fetchUsers}   />
      <EditUser fetchUsers={fetchUsers } />
<UserList users={users} fetchUsers={fetchUsers} />
    </div>
  );
};

export default App;