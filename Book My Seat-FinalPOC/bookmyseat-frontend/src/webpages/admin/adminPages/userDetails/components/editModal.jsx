import React, { useEffect, useRef, useState } from "react";
import axios from "axios";
import styles from "../styles/editModal.module.css";

const EditModal = ({ isOpen, onClose, onSubmit, selectedIndex }) => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const inputRef = useRef(null);
  useEffect(() => {
    try {
      // Setting axios header for authorization
      const token = sessionStorage.getItem("token");
      axios.defaults.headers.common["Authorization"] = token;
      // console.log(token);

      axios
        .get("http://localhost:3031/usersDetailForAdmin")
        .then((res) => {
          setData(res.data);
          setLoading(false); // Set loading to false when data is fetched
        })
        .catch((err) => console.log(err));
    } catch (error) {
      console.error("Error fetching user Details: ", error);
    }
  }, []);
  const initialData = data[selectedIndex];

  // const handleChange = (e) => {
  //   const { name, value } = e.target;
  //   setData(prevData => ({
  //     ...prevData,
  //     [selectedIndex]: {
  //       ...prevData[selectedIndex],
  //       [name]: value
  //     }
  //   }));
  // };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setData((prevData) => {
      const newData = prevData.map((item, index) => {
        if (index === selectedIndex) {
          return { ...item, [name]: value };
        }
        return item;
      });
      return newData;
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Prepare the data in the expected structure
      const updatedUserData = {
        updatedUser: [data[selectedIndex]], // Wrap the selected user data in an array
      };

      // Get the id of the user to be updated
      const userId = initialData.id;
      // Setting axios header for authorization
      const token = sessionStorage.getItem("token");
      axios.defaults.headers.common["Authorization"] = token;
      // console.log(token);

      // Send updated data to the backend
      await axios.put(
        `http://localhost:3031/usersDetailForAdmin/${userId}`,
        updatedUserData
      );

      // Pass the updated data to the parent component and close the modal
      onSubmit(data[selectedIndex]);
      onClose();

      
      // Fetch updated data again if needed
      const updatedDataResponse = await axios.get(
        "http://localhost:3031/usersDetailForAdmin"
      );
      const updatedData = updatedDataResponse.data;
      setData(updatedData);
      // Handle the updated data as needed (update state, etc.)
    } catch (error) {
      console.error("Error updating user: ", error);
    }
  };

  useEffect(() => {
    if (isOpen) {
      inputRef.current.focus();
    }
  }, [isOpen]);

  return (
    <div className={styles.editcontainer}>
      <div className={`${styles.modal} ${isOpen ? styles.open : ""}`}>
        <div className={styles.modelContent}>
          <form onSubmit={handleSubmit}>
            <div className={styles.formContent}>
              <div className={styles.firstHalf}>
                <label>
                  From Date:
                  <input
                    type="text"
                    name="fromDate"
                    value={initialData?.fromDate}
                    disabled
                  />
                </label>
                <label>
                  Booking Type:
                  <input
                    type="text"
                    name="bookingType"
                    value={initialData?.bookingType}
                    disabled
                  />
                </label>
                <label>
                  Shift Time:
                  <input
                    type="text"
                    name="shiftType"
                    value={initialData?.shiftTime}
                    disabled
                  />
                </label>
                <label>
                  Seat Number:
                  <input
                    type="text"
                    name="seatNumber"
                    value={initialData?.bookedSeatNumber}
                    onChange={handleChange}
                    className={styles.boldInput}
                    autoFocus={isOpen}
                    ref={inputRef}
                  />
                </label>
                <label>
                  Floor:
                  <input
                    type="text"
                    name="floor"
                    value={initialData?.floor}
                    disabled
                  />
                </label>
              </div>
              <div className={styles.secondHalf}>
                <label>
                  Desktop:
                  <input
                    type="text"
                    name="desktop"
                    value={initialData?.desktop}
                    disabled
                  />
                </label>
                <label>
                  Beverage:
                  <input
                    type="text"
                    name="beverage"
                    value={initialData?.beverage}
                    disabled
                  />
                </label>
                <label>
                  Lunch:
                  <input
                    type="text"
                    name="lunch"
                    value={initialData?.lunch}
                    disabled
                  />
                </label>
                <label>
                  Parking :
                  <input
                    type="text"
                    name="parking"
                    value={initialData?.parking}
                    disabled
                  />
                </label>
                <label>
                  Vehicle Type:
                  <input
                    type="text"
                    name="vehicleType"
                    value={initialData?.vehicleType || "NA"}
                    disabled
                  />
                </label>
              </div>
            </div>

            <div className={styles.btncontainer}>
              <button className={styles.btnsubmit} type="submit">
                Submit
              </button>
              <button
                className={styles.btncancel}
                type="button"
                onClick={onClose}
              >
                Cancel
              </button>
            </div>

            {/* Add input fields for other data points here */}
          </form>
        </div>
      </div>
    </div>
  );
};

export default EditModal;
