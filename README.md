# 🏟️ Sports Field Management System

An enterprise-grade backend platform designed for **sports complex owners, schools, or universities** to manage booking, maintenance, and scheduling of sports fields and courts. Designed to simulate real-world systems used by urban turf platforms or stadium administrators.

---

## 🚀 Features

- 🏏 **Sports Field Module**: Add, edit, delete fields (e.g., cricket, football, basketball)
- 📅 **Booking System**: Authenticated users can view availability & book slots
- 🧹 **Maintenance Tracker**: Admins can block fields for cleaning or renovation
- 🔁 **Recurring Bookings**: Schedule repeated bookings (e.g., weekly leagues)
- 👥 **Role-Based Access**: Player, Admin, Manager access separation
- 📊 **Field Usage Stats API**: Check popular time slots, frequent users
- 🔐 **JWT Security**, Exception Handling, Validation
- 📄 **Swagger Documentation**

---

## 🧠 Architecture Principles

✅ **Clean Architecture (SoC layers)**  
✅ **SOLID**, **DRY**, **KISS**  
✅ Decoupled Entities, Services, Controllers  
✅ Domain-driven structure with Mapper and DTO layer separation  
✅ Designed for easy integration with payment gateways, analytics, and maps

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Core language |
| Spring Boot 3 | API framework |
| Spring Security | Role-based access |
| PostgreSQL | Relational DB |
| MapStruct | Entity-DTO conversion |
| Flyway | Schema versioning |
| Swagger | API docs |
| Lombok | Clean boilerplate-free code |
| Logback | Logging |
| Docker | (Optional) Container support |

---

## 📁 Folder Structure

```shell
sports-field-system/
├── controller/
├── dto/
├── entity/
├── service/
├── repository/
├── mapper/
├── config/
├── exception/
└── util/

📌 Real-World Inspiration
	•	Can simulate platforms like BookMyTurf, Playo, or college field booking systems
	•	Easily extendable with payment systems, calendar sync, or location APIs
	•	Scalable microservice design-ready architecture

