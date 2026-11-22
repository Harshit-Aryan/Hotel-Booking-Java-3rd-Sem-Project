
# Hotel Booking System

## Project Overview

The Hotel Booking System is a console-based application developed using Java. It allows users to view available hotel rooms, search and sort rooms, book rooms, manage bookings, and cancel reservations.

The project demonstrates the implementation of Java Collections Framework concepts such as ArrayList and HashMap, along with searching, sorting, and Object-Oriented Programming.

## Features

- View all available hotel rooms.
- Search rooms by room type.
- Sort rooms based on price.
- Book hotel rooms.
- Generate unique booking IDs.
- Search bookings using booking ID.
- Cancel existing bookings.
- View all customer bookings.
- Automatically calculate total booking cost based on the number of nights.

## Technologies Used

- **Programming Language:** Java
- **Collections:** ArrayList, HashMap
- **Concepts:** Searching, Sorting, OOP
- **Input Handling:** Scanner
- **IDE:** VS Code

## Java Concepts Implemented

| Concept | Implementation |
|---|---|
| ArrayList | Stores hotel room details |
| HashMap | Stores booking details using booking IDs |
| Searching | Searches rooms by type and bookings by ID |
| Sorting | Sorts rooms by price |
| Classes & Objects | Room and Booking classes |
| Encapsulation basics | Room and booking objects |

## Project Structure

```text
HotelBookingSystem/
│
└── HotelBookingSystem.java
```

## How to Run the Project

### 1. Clone the Repository

```bash
git clone <your-repository-url>
```

### 2. Navigate to the Project Directory

```bash
cd HotelBookingSystem
```

### 3. Compile the Java File

```bash
javac HotelBookingSystem.java
```

### 4. Run the Application

```bash
java HotelBookingSystem
```

## Application Menu

```text
===== HOTEL BOOKING SYSTEM =====

1. View All Rooms
2. Search Rooms
3. Sort Rooms by Price
4. Book a Room
5. Search Booking
6. Cancel Booking
7. View All Bookings
0. Exit

Enter your choice:
```

## Sample Room Details

| Room Number | Room Type | Price Per Night |
|---|---|---:|
| 101 | Single | ₹1,500 |
| 102 | Double | ₹2,500 |
| 103 | Deluxe | ₹4,000 |
| 104 | Single | ₹1,800 |
| 105 | Suite | ₹6,000 |

## Future Improvements

- Add check-in and check-out dates.
- Implement file handling or database connectivity.
- Add customer login and registration.
- Support multiple bookings for the same room on different dates.
- Develop a graphical user interface using Java Swing or JavaFX.

## Limitations

- Booking information is stored in memory.
- Data is lost when the application is closed.
- A room cannot be booked again until its existing booking is cancelled.

## Author

**Harshit Aryan**

## License

This project is created for educational and academic purposes.
