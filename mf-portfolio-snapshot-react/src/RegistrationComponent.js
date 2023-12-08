// RegistrationComponent.jsx

import React, { useState } from 'react';
import axios from 'axios';

const RegistrationComponent = () => {
  const [user, setUser] = useState({
    name: '',
    age: 0,
    password: '',
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/register', user);
      console.log(response.data);
    } catch (error) {
      console.error('Error registering user:', error);
    }
  };

  return (
    <div>
      <h2>User Registration</h2>
      <form onSubmit={handleSubmit}>
        <label>Name:</label>
        <input type="text" name="name" onChange={handleChange} />

        <label>Age:</label>
        <input type="number" name="age" onChange={handleChange} />

        <label>Password:</label>
        <input type="password" name="password" onChange={handleChange} />

        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default RegistrationComponent;