package com.valtech.team3.bookmyseat.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.team3.bookmyseat.dao.BookingMappingRepo;
import com.valtech.team3.bookmyseat.dao.BookingRepo;
import com.valtech.team3.bookmyseat.dao.BuildingRepo;
import com.valtech.team3.bookmyseat.dao.FloorRepo;
import com.valtech.team3.bookmyseat.dao.HolidayRepo;
import com.valtech.team3.bookmyseat.dao.ProjectRepo;
import com.valtech.team3.bookmyseat.dao.RoleRepo;
import com.valtech.team3.bookmyseat.dao.SeatRepo;
import com.valtech.team3.bookmyseat.dao.ShiftDetailsRepo;
import com.valtech.team3.bookmyseat.dao.UserRepo;
import com.valtech.team3.bookmyseat.entities.Booking;
import com.valtech.team3.bookmyseat.entities.BookingMapping;
import com.valtech.team3.bookmyseat.entities.BookingRange;
import com.valtech.team3.bookmyseat.entities.Building;
import com.valtech.team3.bookmyseat.entities.Floor;
import com.valtech.team3.bookmyseat.entities.Holiday;
import com.valtech.team3.bookmyseat.entities.Project;
import com.valtech.team3.bookmyseat.entities.Role;
import com.valtech.team3.bookmyseat.entities.Seat;
import com.valtech.team3.bookmyseat.entities.ShiftDetails;
import com.valtech.team3.bookmyseat.entities.User;
import com.valtech.team3.bookmyseat.entities.VehicleType;

import jakarta.annotation.PostConstruct;

@Service
public class PopulatingClasses {

	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private ProjectRepo projectRepo;
	@Autowired
	private BuildingRepo buildingRepo;
	@Autowired
	private FloorRepo floorRepo;
	@Autowired
	private ShiftDetailsRepo shiftDetailsRepo;
	@Autowired
	private HolidayRepo holidayRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BookingRepo bookingRepo;
	@Autowired
	private SeatRepo seatRepo;
	@Autowired
	private BookingMappingRepo bookingMappingRepo;

	@PostConstruct
	void populateRoles() {
		Role role1 = new Role(1, "ADMIN");
		roleRepo.save(role1);
		Role role2 = new Role(2, "EMPLOYEE");
		roleRepo.save(role2);
		Role role3 = new Role(3, "RECEPTIONIST");
		roleRepo.save(role3);
		Role role4 = new Role(4, "ADMIN/EMPLOYEE");
		roleRepo.save(role4);

		Project project = new Project(1, "Campus Trainee", LocalDate.now(), LocalDateTime.now());
		Project project1 = new Project(1, "RMG", LocalDate.now(), LocalDateTime.now());
		Project project2 = new Project(1, "Others", LocalDate.now(), LocalDateTime.now());
		projectRepo.save(project);
		projectRepo.save(project1);
		projectRepo.save(project2);

		Building building = new Building(1, "Mass Unique", "Banglore", LocalDateTime.now());
		buildingRepo.save(building);

		Floor floor = new Floor(1, "Ground Floor", building);
		floorRepo.save(floor);

		ShiftDetails shift = new ShiftDetails(1, "Morning Shift", LocalTime.of(6, 00), LocalTime.of(15, 00), LocalDateTime.now());
		ShiftDetails shift1 = new ShiftDetails(2, "General Shift", LocalTime.of(9, 00), LocalTime.of(18, 00), LocalDateTime.now());
		ShiftDetails shift2 = new ShiftDetails(3, "General Shift", LocalTime.of(10, 00), LocalTime.of(19, 00), LocalDateTime.now());
		ShiftDetails shift3 = new ShiftDetails(4, "Evening Shift", LocalTime.of(14, 00), LocalTime.of(23, 00), LocalDateTime.now());
		ShiftDetails shift4 = new ShiftDetails(5, "Night Shift", LocalTime.of(22, 00), LocalTime.of(6, 00), LocalDateTime.now());
		shiftDetailsRepo.save(shift);
		shiftDetailsRepo.save(shift1);
		shiftDetailsRepo.save(shift2);
		shiftDetailsRepo.save(shift3);
		shiftDetailsRepo.save(shift4);

		Holiday holiday = new Holiday(1, "Gandhi Jayanthi", LocalDate.of(2023, 10, 2));
		holidayRepo.save(holiday);

		User user1 = new User(1, 5718, "Kruthik", "Bhupal", "kruthik.b@valtech.com", 9916878237L, "Kruthik@123", true, LocalDateTime.now(), project, role2);
		User user2 = new User(2, 5724, "Murali", "Raj", "murali.kr@valtech.com", 9353539655L, "Murali@123", true, LocalDateTime.now(), project, role2);
		User user3 = new User(3, 5712, "Gagana", "Mahadev", "gagana.cm@valtech.com", 9535925188L, "Gagana@123", true, LocalDateTime.now(), project1, role4);
		User user4 = new User(4, 5719, "Laxman", "Kuddemmi", "laxman.kuddemmi@valtech.com", 9945711296L, "Laxman@123", true, LocalDateTime.now(), project, role1);
		User user5 = new User(5, 5725, "Poojitha", "Sathyaprakash", "poojitha.sp@valtech.com", 9900725879L, "Poojitha@123", true, LocalDateTime.now(), project, role2);
		User user6 = new User(6, 5732, "Sandeep", "Kumar", "sandeep.kumar@valtech.com", 8107058611L, "Sandeep@123", true, LocalDateTime.now(), project2, role3);

		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		userRepo.save(user4);
		userRepo.save(user5);
		userRepo.save(user6);

		Seat seat1 = new Seat(1, 1, true, floor);
		Seat seat2 = new Seat(2, 2, true, floor);
		Seat seat3 = new Seat(3, 3, true, floor);
		Seat seat4 = new Seat(4, 4, true, floor);
		Seat seat5 = new Seat(5, 5, true, floor);
		seatRepo.save(seat1);
		seatRepo.save(seat2);
		seatRepo.save(seat3);
		seatRepo.save(seat4);
		seatRepo.save(seat5);

		Booking booking1 = new Booking(1, BookingRange.DAILY, LocalDate.now(), LocalDate.now(), true, true, true, VehicleType.WHEELER_2, true, LocalDateTime.now(), user1, shift, seat1);
		bookingRepo.save(booking1);

		BookingMapping mapping1 = new BookingMapping(1, booking1, LocalDate.now(), true);
		bookingMappingRepo.save(mapping1);

	}

}
